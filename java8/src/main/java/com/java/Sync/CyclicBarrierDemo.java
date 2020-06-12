package com.java.Sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/12 10:47
 **/
public class CyclicBarrierDemo {
    /*public static void main(String[] args) {

        // 设置线程数为2，当两个线程都执行到调用await()方法时，两个线程同时执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();// 当最后一个线程执行到这里时，恢复之前等待的线程
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    System.out.println("原来的栅栏遭到了破坏，抛出了BrokenBarrierException异常");
                    return;
                }
                System.out.println("在线程t中输出一句话");
            }
        }, "t");
        t.start();


        try {
            Thread.sleep(1000L);    //确保线程t已经运行了await方法，实际操作中不鼓励使用sleep方法来控制执行顺序
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cyclicBarrier.reset();  //重置cyclicBarrier，弃用原来的栅栏

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();  //线程t2调用重置后的cyclicBarrier的await方法
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("在线程t2中输出一句话");
            }
        }, "t2").start();

        try {
            cyclicBarrier.await();  //线程main调用重置后的cyclicBarrier的await方法
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("在线程main中输出一句话");
    }*/

    /*public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("这句话会被优先执行");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("在线程t中输出一句话");
            }
        }, "t").start();

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("在线程main中输出一句话");
    }*/


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        new Fighter(cyclicBarrier, "狗哥").start();
        new Fighter(cyclicBarrier, "猫爷").start();
        new Fighter(cyclicBarrier, "王尼妹").start();
        new Fighter(cyclicBarrier, "狗剩").start();
        new Fighter(cyclicBarrier, "张大嘴巴").start();
    }
}
