package com.hrq.creation_pattern.prototype;

/**
 * @ClassName PrototypeTest
 * @Description 原型模式test
 * @Author huangrq
 * @Date 2019/12/18 19:11
 */
public class PrototypeTest {

    public static void main(String[] args) {

        Realizetype realizetype_1 = new Realizetype();
        Realizetype realizetype_2 = (Realizetype) realizetype_1.clone();
        System.out.println(realizetype_1 == realizetype_2);


    }

}
