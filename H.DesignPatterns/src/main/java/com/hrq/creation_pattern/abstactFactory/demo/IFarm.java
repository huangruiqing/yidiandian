package com.hrq.creation_pattern.abstactFactory.demo;

/**
 * @ClassName Ifarm
 * @Description
 * @Author huangrq
 * @Date 2020/1/2 19:51
 */
public interface IFarm {

    IAnimal newAnimal();
    IPlant newPlant();


}
