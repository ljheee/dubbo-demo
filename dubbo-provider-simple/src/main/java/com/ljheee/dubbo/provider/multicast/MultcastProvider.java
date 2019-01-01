package com.ljheee.dubbo.provider.multicast;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.ljheee.dubbo.provider.UserService;
import com.ljheee.dubbo.provider.UserServiceImpl;

import java.io.IOException;

/**
 * Can't assign requested address
 * 在运行Java类时加入VM参数-Djava.net.preferIPv4Stack=true，
 */
public class MultcastProvider {
    public void openServer(int port) {
        //构建应用
        ApplicationConfig config = new ApplicationConfig();
        config.setName("multicast-app");
        config.setQosEnable(Boolean.TRUE);// 开启QoS
        config.setQosPort(33333);// QoS端口

        //通讯协议
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", port);
        protocolConfig.setThreads(20);
        ServiceConfig<UserService> serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(config);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(new RegistryConfig("multicast://224.1.1.1:22222"));// 组播注册中心
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new UserServiceImpl());

        //开始对外服务
        serviceConfig.export();
    }


    public static void main(String[] args) throws IOException {
        new MultcastProvider().openServer(12348);
        System.in.read();
    }
}
