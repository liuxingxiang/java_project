package com.proxy.jdk;

/**
 * @Description jdk动态代理接口类
 * @Author Liu Xing Xiang
 * @Date 2020/5/12 15:25
 **/
public interface TargetService {
    String sayHello(String name);
    String sayGoodBye(String name);
}
