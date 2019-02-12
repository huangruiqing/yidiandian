package com.example.demo.valid;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @ClassName TestLength
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/1/16 20:17
 */
public class TestLength {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        TestLength o = new TestLength();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {

            System.out.println(getFieldVaule(o, field).length());
           /* String field_methoe_name="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            Method field_methoe=o.getClass().getMethod(field_methoe_name, null);
            System.out.println(field_methoe_name+"--->"+field_methoe.invoke(o, null).toString());*/

            //   String ss = (String)field_methoe.invoke(o, null);
            //      System.out.println(field_methoe_name+":"+field_methoe.invoke(o, null));
            //System.out.println(field_methoe_name+":"+ss);
            //    System.out.println(field_methoe_name + ":" + field_methoe.invoke(o, null) + "_" + field_methoe.invoke(o, null).toString().length());
        }
    }

    public static String getFieldVaule(Object o, Field field)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        try {
            String field_methoe_name = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            Method field_methoe = o.getClass().getMethod(field_methoe_name, null);
            System.out.println(field_methoe_name + "--->" + field_methoe.invoke(o, null));
            Object ob = field_methoe.invoke(o, null);
            return ob == null ? null : ob.toString();
        } catch (Exception e) {
            return null;
        }

    }


    private Integer ii = 1112;
    private double d = 0.12;
    private String str = "12345657";
    private BigDecimal big = new BigDecimal(str).setScale(2);

    public Integer getIi() {
        return ii;
    }

    public void setIi(Integer ii) {
        this.ii = ii;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public BigDecimal getBig() {
        return big;
    }

    public void setBig(BigDecimal big) {
        this.big = big;
    }

}
