package com.proxy.proxypattern;

import com.proxy.jdk.TargetServiceImpl;

/**
 * @Description 代理模式-代理类
 * @Author Liu Xing Xiang
 * @Date 2020/5/12 17:23
 **/
public class StaticProxy implements TargetService {
    TargetService targetService;

    public StaticProxy(TargetService targetService){
        this.targetService = targetService;
    }

    @Override
    public String sayHello(String name) {
        before();
        String sayHello = targetService.sayHello(name);
        after();
        return sayHello;
    }

    @Override
    public String sayGoodBye(String name) {
        before();
        String sayGoodBye = targetService.sayGoodBye(name);
        after();
        return sayGoodBye;
    }

    private void before() {//方法执行前
        System.out.println("方法执行前-增强！");
    }
    private void after() {//方法执行后
        System.out.println("方法执行后-增强！");
    }
}
