package com.cardlan.spring.config;

import com.cardlan.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:/spring/person.properties")
@Configuration
public class MainConfigOfPeropertyValues
{

    @Bean
    public Person person(){
        return new Person();
    }

}
