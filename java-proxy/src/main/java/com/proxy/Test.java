package com.proxy;

import com.proxy.cglib.CglibProxy;
import com.proxy.jdk.JdkProxy;
import com.proxy.jdk.TargetService;
import com.proxy.jdk.TargetServiceImpl;
import com.proxy.proxypattern.StaticProxy;

/**
 * @Description 测试类
 * @Author Liu Xing Xiang
 * @Date 2020/5/12 15:17
 **/
public class Test {

    public static void main(String[] args) {
        /************测试jdk动态代理*************/
        /*
         jdk动态代理需要实现接口，通过重写接口里的方法实现增项
         */
        System.out.println("/************测试jdk动态代理*************/");
        JdkProxy jdkProxy = new JdkProxy();
        TargetService jdkProxyService = (TargetService)jdkProxy.creatProxy(new TargetServiceImpl());
        String sayHello = jdkProxyService.sayHello("张三");
        System.out.println("调用--sayHello返回值："+sayHello);
        String sayGoodBye = jdkProxyService.sayGoodBye("李四");
        System.out.println("调用--sayGoodBye返回值："+sayGoodBye);


        /************测试cglib动态代理*************/
        /*cglib动态代理实现机制：通过生成目标类的子类，在子类里重写方法做增强*/
        System.out.println("/************测试cglib动态代理*************/");
        CglibProxy cglibProxy = new CglibProxy();
        TargetService cglibProxyService = (TargetService)cglibProxy.creatProxy(TargetServiceImpl.class);
        String sayHello1 = cglibProxyService.sayHello("张三");
        System.out.println("调用--sayHello返回值："+sayHello1);
        String sayGoodBye1 = cglibProxyService.sayGoodBye("李四");
        System.out.println("调用--sayGoodBye返回值："+sayGoodBye1);

        /************测试代理模式-静态代理*************/
        System.out.println("/************测试代理模式-静态代理*************/");
        com.proxy.proxypattern.TargetService staticProxyService = new StaticProxy(new com.proxy.proxypattern.TargetServiceImpl());
        String sayHello2 = staticProxyService.sayHello("张三");
        System.out.println("调用--sayHello返回值："+sayHello2);
        String sayGoodBye2 = staticProxyService.sayGoodBye("李四");
        System.out.println("调用--sayGoodBye返回值："+sayGoodBye2);
    }
}
