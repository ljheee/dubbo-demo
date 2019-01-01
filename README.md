Dubbo所支持的注册中心
1. Multicast 注册中心
基于组网广播技术，只能用在局域网内，一般用于简单的测试服务
2. Zookeeper 注册中心(推荐)
Zookeeper是Apacahe Hadoop的子项目，是一个 树型的目录服务，支持变更推送，适合作为Dubbo服务的注册中心，工业强度较高，可用于生产环境，并推荐使用
3. Redis 注册中心
基于Redis的注册中心
4. Simple 注册中心
基于本身的Dubbo服务实现( SimpleRegistryService) ，不支持集群可作为自定义注册中心的参考，但不适合直接用于生产环境。


dubbo-provider-simple 实现simple/Multicast注册中心

dubbo-provider-zk   使用zk注册中心，服务启动时 自动注册与发现。
