package com.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/10 14:46
 **/
public class UnBlockedIncrement {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception{
        UnBlockedIncrement increment = new UnBlockedIncrement();

        for (int i = 0;i < 20; i++) {   //创建20个线程
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {   //累加100次
                        increment.increase();
                    }
                }
            });
            t.setName("线程-"+i);
            t.start();
            System.out.println("<======"+increment.getCounter());
        }
        System.out.println("20个线程，每个线程累加100次的执行结果是：" + increment.getCounter());
    }

    public void increase() {    //累加操作
        while (true) {
            int cur = atomicInteger.get();
            if (atomicInteger.compareAndSet(cur, cur+1)) {    //比较并交换，如果失败则立即重试
                break;
            }
        }
    }

    public int getCounter() {
        return atomicInteger.get();
    }
}
