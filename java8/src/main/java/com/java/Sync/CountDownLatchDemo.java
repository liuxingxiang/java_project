package com.java.Sync;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/12 10:54
 **/
public class CountDownLatchDemo {
    /*public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {

            int num = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                }
            });
            threads[i] = t;
            t.start();
        }

        for (int i = 0; i < threads.length; i++) {  //等待所有线程执行完才可以执行main线程
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("等待所有线程执行完成之后才执行");
    }*/

    /*public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length); //创建CountDownLatch对象

        for (int i = 0; i < threads.length; i++) {

            int num = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                    countDownLatch.countDown(); //每个线程在执行完任务后，都调用这个方法
                }
            });
            threads[i] = t;
            t.start();
        }

        try {
            countDownLatch.await(); //在threads中线程都执行完成之前，此方法将阻塞
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("等待所有线程执行完成之后才执行");
    }*/


    public static void main(String[] args) {
        Queue<Runnable> runnableQueue = new LinkedList<>();
        CountDownLatch countDownLatch = new CountDownLatch(5); //创建CountDownLatch对象

        for (int i = 0; i < 5; i++) {

            int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000L);    //模拟耗时操作
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("第" + num + "个小任务执行完成");
                    countDownLatch.countDown(); //每个任务执行完成之后，都调用这个方法
                }
            };

            runnableQueue.add(runnable);
        }


        for (int i = 0; i < 2; i++) {   //创建两个线程来执行上边的5个任务
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Runnable runnable = null;
                        synchronized (CountDownLatchDemo.class) {   //runnableQueue的相关操作需要进行同步处理
                            if (runnableQueue.size() < 1) {
                                break;
                            }

                            runnable = runnableQueue.remove();
                        }
                        runnable.run(); //执行该任务{
                        // }
                    }
                }
            }).start();
        }

        try {
            countDownLatch.await(); //在runnableQueue中的所有任务都执行完成之前，此方法将阻塞
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("等待所有任务执行完成之后才执行");

        int numberOfCPUs = Runtime.getRuntime().availableProcessors();
        System.out.println("当前计算机处理器数量:"+numberOfCPUs);
    }
}
