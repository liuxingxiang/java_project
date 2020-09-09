package com.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 原子性问题分析
 * @Author Liu Xing Xiang
 * @Date 2020/7/17 15:21
 **/
public class VolatileDemo2 {
    public static void main(String[] args){
        final MyData2 myData = new MyData2();
        for (int i = 1; i <= 20 ; i++) {
            // 开启20个线程
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addAtomicPlus();
                }
            },String.valueOf(i)).start();
        }
        // 等待子线程执行完成
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        // 在主线程中获取统计的信息值
        System.out.println(Thread.currentThread().getName()+"\t finnally number value: "+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finnally number value: "+myData.atomicInteger.get());
    }
}

class MyData2{
    // 操作的变量被volatile修饰了
    volatile int number = 0;

    // AtomicInteger 来保证操作的原子性
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addPlusPlus(){
        number++;
    }

    public void addAtomicPlus(){
        atomicInteger.getAndIncrement();
    }

}
