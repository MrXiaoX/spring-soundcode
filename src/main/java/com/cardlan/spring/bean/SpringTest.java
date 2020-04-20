package com.cardlan.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class SpringTest {
    public static void main(String[] args) {
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("/spring/bean.xml");
//        Person person= (Person) applicationContext.getBean("person");
//        System.out.println(person);

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PersonConfig2.class);

        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
//        Person bean = applicationContext.getBean(Person.class);
//        System.out.println(bean);
//
//        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
//        System.out.println( Arrays.toString(beanNamesForType));

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames)
        {
            System.out.println(beanDefinitionName);
        }

//        Object bean1 = applicationContext.getBean("person");
//        Object bean2 = applicationContext.getBean("person");
//        System.out.println(bean1==bean2);
    }
}
