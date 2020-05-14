package com.java8.defaultmethod;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/5/14 10:37
 **/
public class InterfaceDefaultMethodImpl implements InterfaceDefaultMethod{
    @Override
    public void sleep(String name) {
        System.out.println(name+"-子类实现接口抽象方法-睡觉。。。");
    }

    /*@Override
    public void say(String name) {
        System.out.println(name+"-子类覆盖默认方法-说话。。。");
    }*/

}
