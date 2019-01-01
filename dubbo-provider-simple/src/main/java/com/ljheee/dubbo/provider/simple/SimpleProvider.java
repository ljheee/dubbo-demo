package com.ljheee.dubbo.provider.simple;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.ljheee.dubbo.provider.UserService;
import com.ljheee.dubbo.provider.UserServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 注册中心setRegistry 使用的空
 * Simple 注册中心
 * 基于本身的Dubbo服务实现( SimpleRegistryService)
 * <p>
 * 此方式，服务提供者，直接用代码方式暴露服务，无任何配置文件
 */
public class SimpleProvider {

    public void openServer(int port) {
        //构建应用
        ApplicationConfig config = new ApplicationConfig();
        config.setName("simple-app");

        //通讯协议
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", port);
        protocolConfig.setThreads(20);
        ServiceConfig<UserService> serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(config);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(new RegistryConfig(RegistryConfig.NO_AVAILABLE));//注册中心setRegistry 使用的空
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new UserServiceImpl());

        //开始对外服务
        serviceConfig.export();

        // 暴露服务以后，获取URL
        List<com.alibaba.dubbo.common.URL> list = serviceConfig.getExportedUrls();
//        impl.setPort(list.get(0).getPort());
    }


    public static void main(String[] args) throws IOException {
        new SimpleProvider().openServer(12345);
        System.in.read();
    }
}
