package com.ljheee.dubbo.customer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.ljheee.dubbo.provider.UserService;

/**
 * 消费者-本地注册方式
 */
public class SimpleClient {
    UserService service;

    // URL 调用远程服务
    public UserService buildService(String url) {
        ApplicationConfig config = new ApplicationConfig("young-app");

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
        SimpleClient client = new SimpleClient();
        UserService userService = client.buildService("dubbo://127.0.0.1:12345/com.ljheee.dubbo.provider.UserService");
        System.out.println(userService.getUser("ljh"));
    }
}
