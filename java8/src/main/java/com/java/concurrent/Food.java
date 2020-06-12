package com.java.concurrent;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/9 14:35
 **/
public class Food {
    private static int counter = 0;

    private int i;  //代表生产的第几个菜

    public Food() {
        i = ++counter;
    }

    @Override
    public String toString() {
        return "第" + i + "个菜";
    }
}
