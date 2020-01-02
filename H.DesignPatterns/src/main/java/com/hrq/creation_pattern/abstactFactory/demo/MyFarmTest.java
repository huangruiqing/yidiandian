package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName MyFarmTest
 * @Description
 * @Author huangrq
 * @Date 2020/1/2 20:04
 */
public class MyFarmTest {

    public static void main(String[] args) {
        IFarm goodDaIFarm = new GoodDayFarm();
        IFarm redHotFarm = new RedHotFarm();

        IAnimal dog = goodDaIFarm.newAnimal();
        dog.walk();
        dog.voice();
        IPlant apple = goodDaIFarm.newPlant();
        apple.bearFruit();
        System.out.println("##########################");


        IAnimal cat = redHotFarm.newAnimal();
        cat.walk();
        cat.voice();
        IPlant orange = redHotFarm.newPlant();
        orange.bearFruit();

    }

}
