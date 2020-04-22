package com.cardlan.spring.test;

import com.cardlan.spring.bean.Person;
import com.cardlan.spring.config.MainConfigOfPeropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOC_Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfPeropertyValues.class);

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

       Person person= (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String phone = environment.getProperty("phone");
        System.out.println(phone);


        //关闭容器
        applicationContext.close();
    }
}
