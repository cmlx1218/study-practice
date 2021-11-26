package com.cmlx.awaken.object;

import java.util.Map;

/**
 * @Author CMLX
 * @Data -> 2021/11/25/17:46
 * @Desc ->
 */
public class Test {

    public static void main(String[] args) throws Exception {
        MachineSettingModel model = new MachineSettingModel();
        model.setName("xxx");
        Map<String, Object> notNullProperties = ObjectUtils.getNotNullProperties(model);
        System.out.println(notNullProperties);
    }

}
