package com.cardlan.spring.test;

import com.cardlan.spring.aop.MathCalculator;
import com.cardlan.spring.config.MainConfigOfAOP;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_Aop {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        System.out.println(bean.div(1,0));

        applicationContext.close();
    }
}
