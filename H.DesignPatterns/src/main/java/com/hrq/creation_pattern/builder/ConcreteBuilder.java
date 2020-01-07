package com.hrq.creation_pattern.builder;

/**
 * ClassName ConcreteBuilder
 * @Description
 * @Author huangrq
 * @Date 2020/1/7 20:06
 */
public class ConcreteBuilder extends MyBuilder {

    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    public void buildPartB() {
        product.setPartB("建造 PartB");
    }

    public void buildPartC() {
        product.setPartC("建造 PartC");
    }


}
