package com.example.demo.myScheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MyRunnable2
 * @Description
 * @Author huangrq
 * @Date 2019/2/13 11:43
 */
public class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        System.out.println("second DynamicTask，" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
