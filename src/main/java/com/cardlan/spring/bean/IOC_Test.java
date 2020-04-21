package com.cardlan.spring.bean;

import com.cardlan.spring.config.MainConfigOfLifeCycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

        applicationContext.getBean("car");

        //关闭容器
        applicationContext.close();
    }
}
