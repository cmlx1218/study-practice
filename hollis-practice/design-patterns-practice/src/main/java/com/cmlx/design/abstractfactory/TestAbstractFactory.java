package com.cmlx.design.abstractfactory;

import com.cmlx.design.abstractfactory.factory.impl.SportCarFactory;
import com.cmlx.design.abstractfactory.product.BenzCar;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 16:39
 * @Desc ->
 **/
public class TestAbstractFactory {

    public static void main(String[] args) {
        //SportCarFactory sportCarFactory = new SportCarFactory();
        //BenzCar benzCar = sportCarFactory.getBenzCar();
        //benzCar.gasUp();

        String nacos = new BCryptPasswordEncoder().encode("aimy2021#$&!");
        System.out.println(nacos);

    }

}
