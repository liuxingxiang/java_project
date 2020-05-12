package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description Jdk代理类的一部分（不全是代理类）
 * @Author Liu Xing Xiang
 * @Date 2020/5/12 15:30
 **/
public class JdkProxy implements InvocationHandler {

    private Object targetObject;//需要代理的目标对象

    public Object creatProxy(Object targetObject) {//将目标对象传入进行代理
        this.targetObject = targetObject;
        return java.lang.reflect.Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);//返回代理对象
    }

    public Object invoke(Object proxy, Method method, Object[] args)//invoke方法
            throws Throwable {
        before();// 方法执行前做增强
        Object ret = null;      // 设置方法的返回值
        ret  = method.invoke(targetObject, args);  //invoke调用需要代理的方法
        after();// 方法执行后做增强
        return ret;
    }

    private void before() {//方法执行前
        System.out.println("方法执行前！");
    }
    private void after() {//方法执行后
        System.out.println("方法执行后！");
    }
}
