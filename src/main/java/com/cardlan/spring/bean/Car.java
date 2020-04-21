package com.cardlan.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("car 构造创建");
    }

    public void init(){
        System.out.println("car init() 初始化");
    }


    public void destroy(){
        System.out.println("car destroy()销毁");
    }

}
