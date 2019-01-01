package com.ljheee.dubbo.customer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.ljheee.dubbo.provider.UserService;

/**
 * 组播-注册方式 消费者
 */
public class MultcastClient {

    UserService service;

    // URL 调用远程服务
    public UserService buildService(String url) {
        ApplicationConfig config = new ApplicationConfig("multicast-app");

        //构建引用
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(config);
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setUrl(url);

        //透明化
        this.service = referenceConfig.get();
        return service;
    }

    //
    public static void main(String[] args) {
        MultcastClient client = new MultcastClient();
        UserService userService = client.buildService("multicast://224.1.1.1:22222");
        System.out.println(userService.getUser("ljh"));
    }
}
