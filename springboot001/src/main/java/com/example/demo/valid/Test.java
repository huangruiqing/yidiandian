package com.example.demo.valid;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName Test
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/1/16 19:07
 */
public class Test {

    public static void main(String[] args) {
        try{
            Order o_110=new Order();
            o_110.setPhoneNum("");
            o_110.setPayMent("12312");
            checkMyRule(o_110);
            //通过校验后开始业务逻辑
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            Order o_1=new Order();
            o_1.setPayMent("1亿");
            o_1.setPhoneNum("15088888888");
            checkMyRule(o_1);
        }catch(Exception e){
            e.printStackTrace();
        }
        /*try{
            Order o_1=new Order();
            o_1.setPhoneNum("15088888888");
            o_1.setPayMent("12312");
            o_1.setCreate_time("2017/11/7 10:41:44");
            checkMyRule(o_1);

            System.out.println(o_1.toString()+" 【校验通过】");
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }

    public static void checkMyRule(Order o) throws Exception{
        if(o!=null){
            Field[] fields=o.getClass().getDeclaredFields();
            for(Field field: fields){
                if(field.isAnnotationPresent(PxxRequiredRule.class)){
                    PxxRequiredRule pxxRequiredRule=field.getAnnotation(PxxRequiredRule.class);
                    if(!pxxRequiredRule.required()){
                        System.out.println("不参加校验");
                        continue;
                    }
                    String strV=getFieldVaule(o, field);
                    if(strV==null||strV.trim().length()<=0){

                        throw new Exception ("校验失败，字段【"+field.getName()+"】："+pxxRequiredRule.exceptionMsg()+"，当前值："+strV);
                    }
                }
                if(field.isAnnotationPresent(PxxFixLengthRule.class)){
                    String strV=getFieldVaule(o, field);
                    PxxFixLengthRule pxxFixLengthRule=field.getAnnotation(PxxFixLengthRule.class);
                    if(strV==null||strV.trim().length()!=pxxFixLengthRule.fixLength()){
                        throw new Exception ("校验失败，字段【"+field.getName()+"】："+pxxFixLengthRule.exceptionMsg()+"，当前值："+strV);
                    }
                }
                if(field.isAnnotationPresent(PxxMustNumber.class)){
                    String strV=getFieldVaule(o, field);
                    PxxMustNumber pxxMustNumber=field.getAnnotation(PxxMustNumber.class);
                    try{
                        Double d =Double.valueOf(strV);
                    }catch(Exception e){
                        throw new Exception ("校验失败，字段【"+field.getName()+"】："+pxxMustNumber.exceptionMsg()+"，当前值："+strV);
                    }
                }
            }
        }

    }
    /**
     * 获取 字段对应的值
     * @param o
     * @param field
     */
    public static String getFieldVaule(Order o, Field field)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        try{
            String field_methoe_name="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            Method field_methoe=o.getClass().getMethod(field_methoe_name, null);
            return (String) field_methoe.invoke(o, null);
        }catch(Exception e){
            return null;
        }

    }



}
