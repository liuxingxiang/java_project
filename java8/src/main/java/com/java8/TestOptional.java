package com.java8;

import com.java8.entity.Student;

import java.util.Optional;

/**
 * @Description Optional 测试
 * @Author Liu Xing Xiang
 * @Date 2020/5/15 13:20
 **/
public class TestOptional {

    public static void main(String[] args) {
        Student student1 = new Student("男",60,"张三");
        Student student2 = new Student("女",40,"李四");
        Student student3 = new Student(null,18,"王五");

        // Optional 类典型接口的使用
        // get()方法 get()方法  主要用于返回包装对象的实际值，但是如果包装对象值为null，会抛出NoSuchElementException异常。
        // isPresent()方法  用于判断包装对象的值是否非空。
        String gender = getGender(student1);
        System.out.println("性别："+gender);

        // ifPresent()方法
        printName(student2);

        // filter()方法
        filterAge(student3);

        // map()方法
        Optional<Integer> age = getAge(student3);
        System.out.println("age:"+age.get());

        // flatMap()方法
        Optional<Integer> age1 = getAge1(student3);
        System.out.println("age1:"+age1.get());

        // orElse()方法
        String gender1 = getGender1(student3);
        System.out.println("gender1:"+gender1);

        // orElseGet()方法
        String gender2 = getGender2(student2);
        System.out.println("gender2:"+gender2);

        // orElseThrow()方法
        String gender3 = getGender3(student2);
        System.out.println("gender3:"+gender3);


    }


    // orElseThrow()方法其实与orElseGet()方法非常相似了，入参都是Supplier对象，
    // 只不过orElseThrow()的Supplier对象必须返回一个Throwable异常，并在orElseThrow()中将异常抛出：
    // orElseThrow()方法适用于包装对象值为空时需要抛出特定异常的场景。
    public static String getGender3(Student student) {
        return Optional.ofNullable(student).map(u -> u.getGender()).orElseThrow(() -> new RuntimeException("Unkown"));
    }

    // orElseGet()方法与orElse()方法类似，区别在于orElseGet()方法的入参为一个Supplier对象，
    // 用Supplier对象的get()方法的返回值作为默认值。如：
    public static String getGender2(Student student) {
        return Optional.ofNullable(student).map(u -> u.getGender()).orElseGet(() -> "Unkown");
    }

    // orElse()方法功能比较简单，即如果包装对象值非空，返回包装对象值，否则返回入参other的值（默认值）。
    public static String getGender1(Student student) {
        return Optional.ofNullable(student).map(u -> u.getGender()).orElse("Unkown");
    }

    // 跟map()方法不同的是，入参Function函数的返回值类型为Optional<U>类型，而不是U类型，
    // 这样flatMap()能将一个二维的Optional对象映射成一个一维的对象。进行faltMap()改写如下：
    public static Optional<Integer> getAge1(Student student) {
        return Optional.ofNullable(student).flatMap(u -> Optional.ofNullable(u.getAge()));
    }

    // map()方法的参数为Function（函数式接口）对象，map()方法将Optional中的包装对象用Function函数进行运算，
    // 并包装成新的Optional对象（包装对象的类型可能改变）。举例如下：
    public static Optional<Integer> getAge(Student student) {
        // 先用ofNullable()方法构造一个Optional<Student>对象，然后用map()计算学生的年龄，
        // 返回Optional<Integer>对象（如果student为null, 返回map()方法返回一个空的Optinal对象）
        return Optional.ofNullable(student).map(u -> u.getAge());
    }

    // filter()方法接受参数为Predicate对象，用于对Optional对象进行过滤，如果符合Predicate的条件，
    // 返回Optional对象本身，否则返回一个空的Optional对象。举例如下：
    public static void filterAge(Student student) {
        Optional.ofNullable(student).filter( u -> u.getAge() > 18).ifPresent(u -> System.out.println("The student age is more than 18."));
    }

    // ifPresent()方法接受一个Consumer对象（消费函数），如果包装对象的值非空，运行Consumer对象的accept()方法。示例如下：
    public static void printName(Student student) {
        Optional.ofNullable(student).ifPresent(u -> System.out.println("The student name is : " + u.getName()));
    }

    // 创建optional对象的方式
    // 1、创建一个包装对象值为空的Optional对象
    //Optional<String> optStr = Optional.empty();
    // 2、创建包装对象值非空的Optional对象
    //Optional<String> optStr1 = Optional.of("optional");
    // 3、创建包装对象值允许为空的Optional对象
    //Optional<String> optStr2 = Optional.ofNullable(null);

    // 获取性别
    // 这种用法不但没有减少null的防御性检查，而且增加了Optional包装的过程，
    // 违背了Optional设计的初衷，因此开发中要避免这种糟糕的使用~
    public static String getGender(Student student) {
        // 创建包装对象值允许为空的Optional对象
        Optional<Student> stuOpt =  Optional.ofNullable(student);
        if(stuOpt.isPresent()) {
            return stuOpt.get().getGender();
        }

        return "Unkown";
    }
}
