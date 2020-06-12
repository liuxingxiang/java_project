package com.java.java8.functionalInterface;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/14 11:24
 **/
public class Test {
    public static void main(String[] args) {
        // Java8之前，用匿名内部类的方式实现
        IFunctionalInterface obj = new IFunctionalInterface() {
            @Override
            public void eat() {
                System.out.println("用匿名内部类的方式实现eat...");
            }

            @Override
            public void say() {
                System.out.println("用匿名内部类的方式实现say...");
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        // 匿名内部类实现测试
        obj.say();
        obj.eat();

        // lambda表达式实现函数式接口里的抽象方法
        IFunctionalInterface obj1 = () -> {
            System.out.println("lambda表达式实现函数式接口里的抽象方法");
        };
        // 调用默认方法
        obj1.eat();
        // 调用lambda表达式实现的方法
        obj1.say();


    }
}
