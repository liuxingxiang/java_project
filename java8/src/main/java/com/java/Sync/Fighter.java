package com.java.Sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/12 10:52
 **/
public class Fighter extends Thread{
    private CyclicBarrier cyclicBarrier;

    public Fighter(CyclicBarrier cyclicBarrier, String name) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);    //模拟上学中过程
            System.out.println(getName() + "放学了，向学校门跑去");

            cyclicBarrier.await();  //到达校门后等待，直到5个线程都执行到了这里

            System.out.println("人聚齐了，一起打架去喽～");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
