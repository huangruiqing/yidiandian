package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName RedHotFarm
 * @Description 红火农场
 * @Author huangrq
 * @Date 2020/1/2 20:01
 */
public class RedHotFarm implements IFarm {
    @Override
    public IAnimal newAnimal() {
        System.out.println("RedHotFarm create Cat......");
        return new Cat();
    }

    @Override
    public IPlant newPlant() {
        System.out.println("RedHotFarm create Orange......");
        return new Orange();
    }
}
