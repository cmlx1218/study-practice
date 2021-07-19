package com.cmlx.rpc.registry.zookeeper;

import cn.hutool.core.collection.CollectionUtil;
import com.cmlx.rpc.registry.IServiceDiscovery;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author CMLX
 * @Date -> 2021/7/19 17:26
 * @Desc ->
 **/
@Slf4j
public class ZookeeperServiceDiscovery implements IServiceDiscovery {

    private String zkAddress;

    public ZookeeperServiceDiscovery(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    @Override
    public String discover(String serviceName) {
        // 创建Zookeeper客户端
        ZkClient zkClient = new ZkClient(zkAddress, Constant.ZK_SESSION_TIMEOUT, Constant.ZK_CONNECTION_TIMEOUT);
        log.info("connect zookeeper");

        try {
            // 获取service节点
            String servicePath = Constant.ZK_REGISTRY_PATH + "/" + serviceName;
            if (!zkClient.exists(servicePath)) {
                throw new RuntimeException(String.format("can not find any service node on path: %s", servicePath));
            }
            List<String> addressList = zkClient.getChildren(servicePath);
            if (CollectionUtil.isEmpty(addressList)) {
                throw new RuntimeException(String.format("can not find any address node on path: %s", servicePath));
            }

            // 获取 address 节点
            String address;
            int size = addressList.size();
            if (size == 1) {
                // 若只有一个地址，则获取该地址
                address = addressList.get(0);
                log.info("get only address node: {}", address);
            } else {
                // 若存在多个地址，则随机获取一个
                address = addressList.get(ThreadLocalRandom.current().nextInt(size));
                log.info("get random address node: {}", address);
            }

            // 获取 address 节点的值
            String addressPath = servicePath + "/" + address;
            return zkClient.readData(addressPath);
        } finally {
            zkClient.close();
        }
    }
}
