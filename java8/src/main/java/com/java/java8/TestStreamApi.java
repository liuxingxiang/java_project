package com.java.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 测试 Stream API
 * @Author Liu Xing Xiang
 * @Date 2020/5/15 9:02
 **/
public class TestStreamApi {

    public static void main(String[] args) {
        // 统计正数的个数
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);
        long count = numbers.parallelStream().filter(i -> i>0).count();
        System.out.println("正数个数是: " + count);

        // 遍历元素forEach
        numbers.stream().forEach(n -> System.out.println("List1 element: " + n));
        numbers.forEach(n ->  System.out.println("List2 element: " + n));

        // map方法
        numbers.stream().map(n -> Math.abs(n)).forEach(n ->  System.out.println("Element abs: " + n));

        // reduce方法 数组求和操作
        Integer total = numbers.stream().reduce((t, n) -> t + n).get();
        System.out.println("Total: " + total);

        // collect()方法 <R, A> R collect(Collector<? super T, A, R> collector);
        List<Integer> abss = numbers.stream().map( n -> Math.abs(n)).collect(Collectors.toList());
        System.out.println("Abs list: " + abss);

        // summaryStatistics()方法进行数值统计
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Max : " + stats.getMax());
        System.out.println("Min : " + stats.getMin());
        System.out.println("Sum : " + stats.getSum());
        System.out.println("Average : " + stats.getAverage());
        System.out.println("Count : " + stats.getCount());

    }
}
