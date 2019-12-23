package com.hrq.creation_pattern.factoryMethod.sample_1;

/**
 * @ClassName ConcreteFactory1
 * @Description /具体工厂1：实现了厂品的生成方法
 * @Author huangrq
 * @Date 2019/12/23 17:01
 */
public class ConcreteFactory1 implements IFactory {

    @Override
    public IProduct newProduct() {
        System.out.println("具体工厂1 生产具体产品1");
        return new ConcreteProduct1();
    }
}
