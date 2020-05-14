package com.java8.defaultmethod;

/**
 * @Description 演示Java8新特性：接口默认方法
 * @Author Liu Xing Xiang
 * @Date 2020/5/14 10:33
 **/
public interface InterfaceDefaultMethod {
    // 抽象方法
    void sleep(String name);

    // 默认方法，可以有多个，可以被子类覆盖，也可以不用覆盖
    default void say(String name) {
        System.out.println(name+"-接口默认方法-说话。。。");
    }

    // 静态方法，可以有多个。权限修饰符只能是public或者不写
    // 不能被子类覆盖
    public static void eat(String name) {
        System.out.println(name+"-接口静态方法-吃饭。。。");
    }
}
