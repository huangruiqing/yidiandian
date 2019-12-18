package com.hrq.creation_pattern.prototype;

/**
 * @ClassName PrototypeTest
 * @Description 原型模式test
 * @Author huangrq
 * @Date 2019/12/18 19:11
 */
public class PrototypeTest {

    public static void main(String[] args) {
        //实例1
        Realizetype realizetype_1 = new Realizetype();//具体实现类
        Realizetype realizetype_2 = (Realizetype) realizetype_1.clone();
        System.out.println(realizetype_1 == realizetype_2);
        //实例2
        String studentName  = "张三";
        String info = "同学：在本学年第一学期中表现优秀，被评为三好学生。";
        String college = "Hello-World College";
        Citation citation = new Citation(studentName,info,college);
        citation.display();
        Citation citation2  = (Citation) citation.clone();
        citation2.setStudentName("李四");
        citation2.display();

        //实例3
        PrototypeShapeManger shapeManger = new PrototypeShapeManger();
        Circle circle = (Circle) shapeManger.get("circle");
        circle.setR(2D);
        circle.countArea();
        Circle circle2 = (Circle) shapeManger.get("circle");
        circle2.setR(3D);
        circle2.countArea();

        Square square= (Square) shapeManger.get("square");
        square.setA(2D);
        square.countArea();





    }

}
