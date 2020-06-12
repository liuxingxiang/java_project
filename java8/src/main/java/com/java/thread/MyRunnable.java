package com.java.thread;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/19 9:05
 **/
public class MyRunnable implements Runnable {
    private String threadName;
    public MyRunnable() {
    }
    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void run() {
        for(int i = 0 ; i <10000;i++){
            System.out.println("线程-"+threadName+"执行===");
        }
    }
}
