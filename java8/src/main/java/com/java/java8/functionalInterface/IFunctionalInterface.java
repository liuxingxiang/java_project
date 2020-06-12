package com.java.java8.functionalInterface;

/**
 * @Description Java8新特性：函数式接口，为lambda表达式而设计
 * @Author Liu Xing Xiang
 * @Date 2020/5/14 11:20
 **/
@FunctionalInterface
public interface IFunctionalInterface {
    // 只有一个抽象方法的接口称为函数式接口
    // 在函数式接口里可以有多个默认方法
    default void eat(){
        System.out.println("default eat...");
    }

    // 函数是接口可以用注解@FunctionalInterface标注，以免他人在接口里添加其他抽象方法
    void say();

    // 在函数式接口里可以有多个静态方法，
    static void sleep(){
        System.out.println("static sleep...");
    }

    // 也可以有java.lang.object里的public方法（非final方法）
    boolean equals(Object obj);
}
