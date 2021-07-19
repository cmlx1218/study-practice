package com.cmlx.netty.rpc.common.bean;

/**
 * @Author CMLX
 * @Date -> 2021/7/19 18:23
 * @Desc -> 封装 RPC 响应
 **/
public class RpcResponse {

    private String requestId;
    private Exception exception;
    private Object result;

    public boolean hasException() {
        return exception != null;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
