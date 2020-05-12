package com.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description Jdk代理类的一部分（不全是代理类）
 * @Author Liu Xing Xiang
 * @Date 2020/5/12 15:30
 **/
public class CglibProxy implements MethodInterceptor {

    // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
    public Object creatProxy(Class<?> clazz)
    {
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(clazz);
        // 设置回调
        enhancer.setCallback(this);
        // 返回代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object ret = null;
        ret = methodProxy.invokeSuper(object,objects);
        after();
        return ret;
    }

    private void before() {//方法执行前
        System.out.println("方法执行前！");
    }
    private void after() {//方法执行后
        System.out.println("方法执行后！");
    }
}
