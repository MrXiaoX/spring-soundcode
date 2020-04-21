package com.cardlan.spring.bean;


import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Data
@ToString(of = {"name","age","phone"})
public class Person {

    @Value("张凯旋")
    private String name;

    @Value("${phone}")
    private String phone;

    @Value("#{29-6}")
    private Integer age;


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
