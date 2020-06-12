package com.java.thread;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/19 9:09
 **/
public class Test {
    public static void main(String[] args) {
        // 继承Thread类创建的线程启动
        Thread myThread = new MyThread("myThread");
        myThread.start();

        // 实现Runnable接口创建的线程启动
        Runnable myRunnable = new MyRunnable("myRunnable");
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
