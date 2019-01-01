package com.ljheee.dubbo.provider.zk;

import com.ljheee.dubbo.provider.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 */
public class ZkClient {
    public static void main(String[] args) {
        //测试常规服务
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        UserService demoService = context.getBean(UserService.class);
        System.out.println("consumer");
        System.out.println(demoService.getUser("2018-"));
    }

}
