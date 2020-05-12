package com.proxy.jdk;

/**
 * @Description jdk动态代理接口实现类
 * @Author Liu Xing Xiang
 * @Date 2020/5/12 15:27
 **/
public class TargetServiceImpl implements TargetService {
    @Override
    public String sayHello(String name) {
        System.out.println(name+"--sayHello...");
        return name+" sayHello...";
    }

    @Override
    public String sayGoodBye(String name) {
        System.out.println(name+"--sayGoodBye...");
        return name+" sayGoodBye...";
    }
}
