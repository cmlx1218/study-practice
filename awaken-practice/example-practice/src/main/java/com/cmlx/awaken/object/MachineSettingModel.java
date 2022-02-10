package com.cmlx.awaken.object;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author CMLX
 * @Data -> 2021/11/25/11:05
 * @Desc ->
 */
@Data
public class MachineSettingModel {

    @NotNull
    private Long machineId;         // 机器id
    private Integer luminance;      // 亮度
    private Integer volume;         // 音量
    private Integer ktModel;        // 空调模式 0-制冷 1-制热
    private Integer temperature;    // 温度
    private Integer lightModel;     // 灯光模式 0-柔光 1-标准 2-强光
    private String name;

}
