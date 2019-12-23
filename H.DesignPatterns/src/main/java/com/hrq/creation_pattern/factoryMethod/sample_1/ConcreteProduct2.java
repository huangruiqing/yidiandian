package com.hrq.creation_pattern.factoryMethod.sample_1;

/**
 * @ClassName ConcreteProduct1
 * @Description //具体产品1：实现抽象产品中的抽象方法
 * @Author huangrq
 * @Date 2019/12/23 17:02
 */
public class ConcreteProduct2 implements IProduct {
    @Override
    public void show() {
        System.out.println("具体产品_2 功能");
    }
}
