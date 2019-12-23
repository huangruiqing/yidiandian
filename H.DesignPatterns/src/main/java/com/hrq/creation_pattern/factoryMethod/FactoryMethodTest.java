package com.hrq.creation_pattern.factoryMethod;

import com.hrq.creation_pattern.factoryMethod.sample_1.ConcreteFactory1;
import com.hrq.creation_pattern.factoryMethod.sample_1.ConcreteFactory2;
import com.hrq.creation_pattern.factoryMethod.sample_1.ConcreteProduct1;
import com.hrq.creation_pattern.factoryMethod.sample_1.ConcreteProduct2;
import com.hrq.creation_pattern.factoryMethod.sample_1.IFactory;
import com.hrq.creation_pattern.factoryMethod.sample_1.IProduct;

/**
 * @ClassName FactoryMethodTest
 * @Description 工厂方法
 * @Author huangrq
 * @Date 2019/12/20 19:19
 */
public class FactoryMethodTest {
          /*  new ConcreteFactory1();
            new ConcreteFactory2();*/

    public static void main(String[] args) {

        try {

            IProduct a;
            IFactory af ;
            // 配置xml 获取到
            Class<?> clazz= Class.forName("com.hrq.creation_pattern.factoryMethod.sample_1.ConcreteFactory2");
            af = (IFactory)clazz.newInstance();
            a = af.newProduct();
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
