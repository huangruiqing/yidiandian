package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName GoodDayFarm
 * @Description 好日子农场
 * @Author huangrq
 * @Date 2020/1/2 20:01
 */
public class GoodDayFarm implements IFarm {
    @Override
    public IAnimal newAnimal() {
        System.out.println("GoodDayFarm create Dog......");
        return new Dog();
    }

    @Override
    public IPlant newPlant() {
        System.out.println("GoodDayFarm create Apple......");
        return new Apple();
    }
}
