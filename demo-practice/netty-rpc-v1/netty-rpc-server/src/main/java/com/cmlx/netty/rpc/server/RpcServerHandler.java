package com.cmlx.netty.rpc.server;

import com.cmlx.netty.rpc.common.bean.RpcRequest;
import com.cmlx.netty.rpc.common.bean.RpcResponse;
import com.cmlx.netty.rpc.common.util.StringUtil;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author CMLX
 * @Date -> 2021/7/19 18:27
 * @Desc -> RPC 服务端处理器(用于处理 RPC 请求)
 **/
@Slf4j
public class RpcServerHandler extends SimpleChannelInboundHandler<RpcRequest> {

    private Map<String, Object> handlerMap;

    public RpcServerHandler(Map<String, Object> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequest request) throws Exception {
        // 创建并初始化 RPC 响应对象
        RpcResponse response = new RpcResponse();
        response.setRequestId(request.getRequestId());
        try {
            Object result = handle(request);
            response.setResult(result);
        } catch (Exception e) {
            log.info("handle result failure", e);
            response.setException(e);
        }
        // 写入 RPC 响应对象并自动关闭连接
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }

    private Object handle(RpcRequest request) throws Exception {
        // 获取服务对象
        String serviceName = request.getInterfaceName();
        String serviceVersion = request.getServiceVersion();
        if (StringUtil.isNotEmpty(serviceVersion)) {
            serviceName += "-" + serviceVersion;
        }
        Object serviceBean = handlerMap.get(serviceName);
        if (serviceBean == null) {
            throw new RuntimeException(String.format("can not find service bean by key: %s", serviceName));
        }
        // 获取反射调用所需的参数
        Class<?> serviceClass = serviceBean.getClass();
        String methodName = request.getMethodName();
        Class<?>[] parameterTypes = request.getParameterTypes();
        Object[] parameters = request.getParameters();
        // 执行反射调用
        //Method method = serviceClass.getMethod(methodName, parameterTypes);
        //method.setAccessible(true);
        //return method.invoke(serviceBean,parameters);
        // CGlib 执行反射调用
        FastClass serviceFastClass = FastClass.create(serviceClass);
        FastMethod serviceFastClassMethod = serviceFastClass.getMethod(methodName, parameterTypes);
        return serviceFastClassMethod.invoke(serviceBean, parameters);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("server caught exception", cause);
        ctx.close();
    }
}
