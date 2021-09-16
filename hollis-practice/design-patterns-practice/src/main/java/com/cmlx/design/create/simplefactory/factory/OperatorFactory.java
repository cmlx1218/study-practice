package com.cmlx.design.create.simplefactory.factory;

import com.cmlx.design.create.simplefactory.product.Operator;

/**
 * @Author CMLX
 * @Date -> 2021/5/19 14:50
 * @Desc ->
 **/
public class OperatorFactory {

    public static Operator createOperator(String operatorStr) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Operator operator = null;
        //switch (operatorStr) {
        //    case "+":
        //        operator = new OperatorAdd();
        //        break;
        //    case "-":
        //        operator = new OperatorSub();
        //        break;
        //    case "*":
        //        operator = new OperatorMul();
        //        break;
        //    case "/":
        //        operator = new OperatorDiv();
        //        break;
        //    default:
        //        throw new UnsupportedOperationException("不支持该操作");
        //}
        return (Operator) Class.forName("com.cmlx.design.create.simplefactory.product."+operatorStr).newInstance();
    }
}
