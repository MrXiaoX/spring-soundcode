package com.cardlan.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog() {
        System.out.println("dog 构造创建");
    }

    //对象创建并赋值之后
    @PostConstruct
    public void init(){
        System.out.println("dog init() 初始化");
    }


    //容器移除对象之前
    @PreDestroy
    public void destroy(){
        System.out.println("dog destroy()销毁");
    }
}
