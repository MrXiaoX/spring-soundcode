package com.cardlan.spring.bean;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Boss {

    private Car car;

    public Car getCar() {
        return car;
    }


    public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("Boss 有参构造器");
    }

    //    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }
}
