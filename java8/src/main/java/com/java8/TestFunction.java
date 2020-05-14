package com.java8;

import java.nio.file.DirectoryStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @Description 内置功能函数接口测试，方法引用测试
 * @Author Liu Xing Xiang
 * @Date 2020/5/14 15:02
 **/
public class TestFunction {
    // 谓词：（Predicate）里的test方法实现
    static boolean test(String t) {
        if ("liu666".equals(t)) {
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        // 	1，谓词：（Predicate）
        //		谓词是单参数的返回布尔值的函数式接口，输入一个参数，返回true或者false。
        // boolean test(T t);
        Predicate<String> predicate = (String t) -> {
            if ("liu".equals(t)) {
                return true;
            } else{
                return false;
            }
        };

        // 内置功能 谓词 测试
        Boolean b = testPredicate("liu",predicate);
        System.out.println("内置功能接口的使用测试-谓词-返回值："+b);

        // 新特性：方法引用 测试；方法引用是lambda表达式的一种简写形式。
        // 如果lambda表达式只是调用一个特定的已经存在的方法，则可以使用方法引用。
        // 如果你觉得lambda的方法体会很长，影响代码可读性，则可以用方法引用来解决。
        Predicate<String> predicate1 = TestFunction :: test;
        boolean test1 = predicate1.test("liu66");
        System.out.println("方法引用测试——"+test1);

        //	2，函数：（Function）
        //		Function接受一个参数，并产生一个结果。
        // R apply(T t);
        Function<Integer, String> function = (Integer t) -> {
            String value = String.valueOf(t+80);
            return value;
        };

        String str = testFunction(20, function);
        System.out.println("内置功能接口的使用测试-函数-返回值："+str);

        //	3，生产者：（Supplier）
        //		Supplier产生一个给定的泛型类型的结果。与Function不同的是Supplier不接受输入的参数。
        // T get();
        Supplier<String> supplier = () ->{
            return "生产者-返回测试";
        };
        String testSupplier = testSupplier(supplier);
        System.out.println("内置功能接口的使用测试-生产者-返回值："+testSupplier);

        //	4，消费者：（Consumer）
        //		Consumer代表在一个单一的输入参数上执行操作。Consumer的操作可能会更改输入参数的内部状态。
        // void accept(T t);
        Consumer<String> consumer = (String t) ->{
            System.out.println("内置功能接口的使用测试-消费者-"+t);
        };
        consumer.accept("诸葛亮舌战群儒。。");
        testConsumer("煮酒论英雄。。",consumer);


    }

    private static <T> void testConsumer(T t,Consumer<T> consumer) {
        consumer.accept(t);
    }

    private static <T> T testSupplier(Supplier<T> supplier) {
        T t = supplier.get();
        return t;
    }

    private static <T,R> R testFunction(T t,Function<T, R> function) {
        R r = function.apply(t);
        return r;
    }

    // 内置功能接口的使用测试
    private static <T> Boolean testPredicate(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

}
