package com.cardlan.spring.test;

import com.cardlan.spring.bean.Yellow;
import com.cardlan.spring.config.MainConfigOfProfile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {


    //1.使用命令行动态参数  -VM Option：  -Dspring.profiles.active=test
    //2.代码激活环境
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();

        //1.创建一个applicationContext
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");//,"dev","prod"
        //3.注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String beans : beanNamesForType) {
            System.out.println(beans);
        }

        Yellow yellow = (Yellow) applicationContext.getBean("yellow");
        System.out.println(yellow);

    }
}
