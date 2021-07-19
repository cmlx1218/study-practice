package com.cmlx.rpc.registry;

/**
 * @Author CMLX
 * @Date -> 2021/7/19 17:22
 * @Desc -> 服务发现接口
 **/
public interface IServiceDiscovery {

    /**
     * 根据服务名称查找服务地址
     *
     * @param serviceName 服务名称
     * @return 服务地址
     */
    String discover(String serviceName);

}
