package com.java.Sync;

import java.util.concurrent.Semaphore;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/12 10:43
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);//限制并发线程数为 5个线程
        for (int i = 0; i < 20; i++) {// 新建20个线程
            int num = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();// 当前线程尝试获取许可证
                        System.out.println("第" + num + "个线程执行任务");
                        Thread.sleep(5000L);    //休眠5秒钟
                        semaphore.release();// 当前线程释放获得的许可证
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }).start();
        }
    }
}
