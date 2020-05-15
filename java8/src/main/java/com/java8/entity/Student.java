package com.java8.entity;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/15 13:36
 **/
public class Student {
    // 性别
    private String gender;
    // 姓名
    private String name;
    // 年龄
    private int age;

    public Student() {
    }

    public Student(String gender, int age,String name) {
        this.gender = gender;
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
