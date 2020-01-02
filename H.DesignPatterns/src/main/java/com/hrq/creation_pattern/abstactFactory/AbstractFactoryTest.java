package com.hrq.creation_pattern.abstactFactory;

/**
 * @ClassName AbstractFactoryTest
 * @Description 抽象工厂模式
 * @Author huangrq
 * @Date 2020/1/2 19:40
 */
public class AbstractFactoryTest {


    public static void main(String[] args) {

        IAbstractFactory abstractFactory = new ConcreteFactory_1();
        Product_1 product_1 = abstractFactory.newProduct1();
        product_1.show();

        Product_2 product_2 = abstractFactory.newProduct2();
        product_2.show();

    }

}
