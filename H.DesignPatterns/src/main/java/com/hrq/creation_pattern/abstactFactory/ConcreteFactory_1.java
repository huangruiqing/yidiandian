package com.hrq.creation_pattern.abstactFactory;

/**
 * @ClassName ConcreteFactory_1
 * @Description
 * @Author huangrq
 * @Date 2020/1/2 19:46
 */
public class ConcreteFactory_1 implements IAbstractFactory {
    @Override
    public Product_1 newProduct1() {
        System.out.println("factory 1 create product 1");
        return new Product_1();
    }

    @Override
    public Product_2 newProduct2() {
        System.out.println("factory 1 create product 2");
        return new Product_2();
    }
}
