package com.java;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/26 15:31
 **/
public class Test {

    public static void main(String[] args) {

        Map<String,String> map = new LinkedHashMap();
        System.out.println(Optional.ofNullable(map).isPresent());

        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        set.forEach(t -> System.out.println(t));

    }

    private static void m1(int i) {
        i=20;
        System.out.println(i);
    }
    private static void m2(String str2) {
        str2="bbb";
        System.out.println(str2);
    }
}
