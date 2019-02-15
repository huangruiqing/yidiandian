package com.example.demo.myScheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MyRunnable1
 * @Description
 * @Author huangrq
 * @Date 2019/2/13 11:43
 */
public class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        System.out.println("first DynamicTask，" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
