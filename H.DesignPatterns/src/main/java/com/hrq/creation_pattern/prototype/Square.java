package com.hrq.creation_pattern.prototype;

/**
 * @ClassName Square
 * @Description 正方形
 * @Author huangrq
 * @Date 2019/12/18 20:17
 */
public class Square implements Shape{

    private double a;

    public  Square(double a){
        this.a = a;
    };
    public  Square(){};

    @Override
    public Object clone() {
        Square circle = null;
        try {
            circle = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("clone square failed");
        }
        return circle;
    }

    @Override
    public void countArea() {
        double area = Math.pow(a,2);
        System.out.println("计算正方形面积"+area);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }
}
