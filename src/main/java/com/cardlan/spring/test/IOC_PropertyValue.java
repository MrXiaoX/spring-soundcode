package com.cardlan.spring.test;

import com.cardlan.spring.bean.Person;
import com.cardlan.spring.config.MainConfigOfPeropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_PropertyValue {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfPeropertyValues.class);


        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
