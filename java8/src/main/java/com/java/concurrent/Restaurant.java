package com.java.concurrent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/9 14:37
 **/
public class Restaurant {
    public static void main(String[] args) {

        Queue<Food> queue = new LinkedList<>();
        new Cook(queue, "1号厨师").start();
        new Cook(queue, "2号厨师").start();
        new Cook(queue, "3号厨师").start();
        new Waiter(queue, "1号服务员").start();
        new Waiter(queue, "2号服务员").start();
        new Waiter(queue, "3号服务员").start();
    }
}
