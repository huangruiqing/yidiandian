package com.hrq.creation_pattern.factoryMethod.sample_1;

/**
 * @ClassName IFactory
 * @Description 抽象工厂 抽象工厂：提供了厂品的生成方法
 * @Author huangrq
 * @Date 2019/12/23 16:53
 */
public interface IFactory {

    public IProduct newProduct();

}
