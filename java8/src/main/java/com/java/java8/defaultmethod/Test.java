package com.java.java8.defaultmethod;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/14 10:31
 **/
public class Test {

    public static void main(String[] args) {
        // 测试接口默认方法，接口静态方法
        InterfaceDefaultMethod defaultMethod = new InterfaceDefaultMethodImpl();
        // 调用默认方法，子类覆盖了，则调用子类的方法，子类未覆盖，则调用接口的默认方法
        defaultMethod.say("张三");
        // 调用抽象方法
        defaultMethod.sleep("李四");
        // 静态方法只能类名调用，不能用引用调用
        InterfaceDefaultMethod.eat("王五");
    }
}
