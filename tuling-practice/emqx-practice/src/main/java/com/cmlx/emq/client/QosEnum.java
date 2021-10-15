package com.cmlx.emq.client;

/**
 * @Author CMLX
 * @Date -> 2021/10/15 14:44
 * @Desc -> Qos服务枚举类
 **/
public enum QosEnum {

    /**
     * QoS0：“至多一次”，消息基于TCP/IP网络传输，没有回应，消息可能到达服务器一次，也可能根本不会到达
     * QoS1：“至少一次”，服务器接收到消息会被确认，通过传输一个PUBACK消息。如果有一个可以辨认的传输失败，无论是通讯连接还是发送设备，
     * 还是过了一段时间确认信息没有收到，发送方都会将消息头的DUP位置1，然后再次发送消息。消息最少一次到达服务器。可能会出现重复消息
     * QoS2：“只有一次”，确保消息到达一次，在QoS level 1上附加的协议流保证了重复的消息不会传送到接收的应用
     */
    QoS0(0), QoS1(1), QoS2(2);

    QosEnum(int qos) {
        this.value = qos;
    }

    private final int value;

    public int value() {
        return this.value;
    }
}
