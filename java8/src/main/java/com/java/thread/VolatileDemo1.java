package com.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description 可见性问题分析
 * @Author Liu Xing Xiang
 * @Date 2020/7/17 15:06
 **/
public class VolatileDemo1 {
    public static void main(String[] args){
        final MyData myData = new MyData();

        // 开启一个新的线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始了...");
            try{
                TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
            // 在子线程中修改了变量的信息，修改的是子线程在工作内存中的数据
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "更新后的数据是："+myData.number);
        },"BBB").start();

        // 因为在其他线程中修改的信息，主线程的工作内存中的数据并没有改变，所以此时number还是为0
        while(myData.number == 0){
            // 会一直卡在此处
            //System.out.println("1111");
        }

        System.out.println(Thread.currentThread().getName()+"\t number =  " + myData.number);
    }
}

class MyData{
    // 没有用volatile来修饰
    // int number = 0;

    // 用volatile来修饰后，其他线程修改的共享变量回写到主内存中时，另一个线程是可以立马知道的，这就是我们说的可见性。
    volatile int number = 0;

    public void addTo60(){
        this.number = 60;
    }
}
