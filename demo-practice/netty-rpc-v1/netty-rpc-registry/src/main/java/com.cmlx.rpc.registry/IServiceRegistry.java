package com.cmlx.rpc.registry;

/**
 * @Author CMLX
 * @Date -> 2021/7/19 17:23
 * @Desc -> 服务注册接口
 **/
public interface IServiceRegistry {

    /**
     * 注册服务名称与服务地址
     * @param serviceName 服务名称
     * @param serviceAddress 服务地址
     */
    void registry(String serviceName,String serviceAddress);

}
