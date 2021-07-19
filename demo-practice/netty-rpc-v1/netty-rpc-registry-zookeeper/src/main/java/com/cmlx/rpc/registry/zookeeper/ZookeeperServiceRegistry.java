package com.cmlx.rpc.registry.zookeeper;

import com.cmlx.rpc.registry.IServiceRegistry;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;

/**
 * @Author CMLX
 * @Date -> 2021/7/19 17:47
 * @Desc -> 基于 Zookeeper 的服务注册接口实现
 **/
@Slf4j
public class ZookeeperServiceRegistry implements IServiceRegistry {

    private final ZkClient zkClient;

    public ZookeeperServiceRegistry(String zkAddress) {
        zkClient = new ZkClient(zkAddress, Constant.ZK_SESSION_TIMEOUT, Constant.ZK_CONNECTION_TIMEOUT);
        log.info("connect zookeeper");
    }

    @Override
    public void registry(String serviceName, String serviceAddress) {
        // 创建 registry 节点(持久)
        String registryPath = Constant.ZK_REGISTRY_PATH;
        if (!zkClient.exists(registryPath)) {
            zkClient.createPersistent(registryPath);
            log.info("create registry node: {}", registryPath);
        }
        // 创建 service 节点(持久)
        String servicePath = registryPath + "/" + serviceName;
        if (!zkClient.exists(servicePath)) {
            zkClient.createPersistent(servicePath);
            log.info("create service node: {}", servicePath);
        }
        // 创建 address 节点(临时)
        String addressPath = servicePath + "address-";
        String addressNode = zkClient.createEphemeralSequential(addressPath, serviceAddress);
        log.info("create address node: {}", addressNode);
    }
}
