package com.java.concurrent;

import java.util.Random;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/9 14:35
 **/
public class SleepUtil {
    private static Random random = new Random();

    public static void randomSleep() {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
