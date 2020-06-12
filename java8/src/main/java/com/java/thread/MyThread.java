package com.java.thread;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/19 9:08
 **/
public class MyThread extends Thread {
    private String threadName;
    public MyThread() {
    }
    public MyThread(String threadName) {
        this.threadName = threadName;
    }
    @Override
    public void run() {
        for(int i = 0 ; i <10000;i++){
            System.out.println("线程-"+threadName+"执行===>>>");
        }
    }
}
