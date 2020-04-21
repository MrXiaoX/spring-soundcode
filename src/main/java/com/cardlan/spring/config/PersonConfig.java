package com.cardlan.spring.config;

import com.cardlan.spring.bean.MyTypeFilter;
import com.cardlan.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.cardlan.spring.bean"
        ,excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
                Controller.class, Service.class
        }),@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {
        PersonConfig.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {
                MyTypeFilter.class}),

}
//,includeFilters = {
//       @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {
//               Controller.class}),
//},useDefaultFilters = false)
)
/**
 * ComponentScan value = 指定要扫描的包范围
 * excludeFilters=Filter[] 指定扫描组件排查哪些组件
 * includeFilters=Filter[] 指定扫描组件只包含哪些组件
 * FilterType.ANNOTATION 按照注解扫描
 * FilterType.ASSIGNABLE_TYPE 按照给定的类型扫描
 * FilterType.ASPECTJ 使用ASPECTJ表达式
 *FilterType.REGEX 使用正则表达式
 *FilterType.CUSTOM 使用自定义规则
 */
public class PersonConfig {

    @Bean("person")
    public Person personInfo(){
        return new Person("谢娜",20);
    }
}
