package com.java.concurrent;

import java.util.Queue;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/9 14:36
 **/
public class Cook extends Thread {
    private Queue<Food> queue;

    public Cook(Queue<Food> queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            SleepUtil.randomSleep();    //模拟厨师炒菜时间
            Food food = new Food();
            System.out.println(getName() + " 生产了" + food);
            synchronized (queue) {
                while (queue.size() > 4) {
                    try {
                        System.out.println("队列元素超过5个，为：" + queue.size() + " " + getName() + "抽根烟等待中");
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.add(food);
                queue.notifyAll();
            }
        }
    }
}
