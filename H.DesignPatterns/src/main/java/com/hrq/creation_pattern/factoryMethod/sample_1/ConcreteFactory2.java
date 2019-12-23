package com.hrq.creation_pattern.factoryMethod.sample_1;

/**
 * @ClassName ConcreteFactory1
 * @Description /具体工厂1：实现了厂品的生成方法
 * @Author huangrq
 * @Date 2019/12/23 17:01
 */
public class ConcreteFactory2 implements IFactory {

    @Override
    public IProduct newProduct() {
        System.out.println("具体工厂2 生产具体产品2");
        return new ConcreteProduct2();
    }
}
