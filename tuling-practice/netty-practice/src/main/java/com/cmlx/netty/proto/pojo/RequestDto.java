package com.cmlx.netty.proto.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author CMLX
 * @Date -> 2021/7/15 10:36
 * @Desc ->
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

    private Integer id;
    private String methodName;
    private String serviceName;
    private Integer version;
    private String result;

    public static final RequestDto INSTANCE = new RequestDto();

}
