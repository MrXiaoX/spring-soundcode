package com.cardlan.spring.bean;


import lombok.*;

@Data
@ToString(of = {"name","age"})
@RequiredArgsConstructor
public class Person {

    private String name;

    private Integer age;


    ThreadLocal threadLocal=new ThreadLocal();

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
