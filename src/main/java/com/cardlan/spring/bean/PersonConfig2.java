package com.cardlan.spring.bean;

import com.cardlan.spring.condition.LinuxCondition;
import com.cardlan.spring.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//当满足这个条件，这类中所有的bean才生效
//@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,MyImporSelector.class,MyImportBeanDefinitionRegistrar.class})//导入组件，id为全类名称
public class PersonConfig2 {


    /**
     * prototype:多实例,ioc容器启动不会调用方法创建对象放在容器中，每次获取的时候才调用方法
     * singleton:单实例(默认值) ioc容器启动会调用方法创建对象到ioc容器中，以后每次获取就是从容器中拿(map.get())
     *
     * 懒加载:
     *      单实例bean:默认会容器启动时创建对象
     *      懒加载:容器默认不启动，当前使用(获取)bean对象时，才初始化
     * @return
     */
//    @Scope("prototype")
    @Bean("person")
    @Lazy
    public Person personInfo(){
        System.out.println("给容器添加 Bean");
        return new Person("谢娜",25);
    }

    //在方法上 当满足这个条件，这bean才生效
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",65);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linux")
    public Person person02(){
        return new Person("Linux",63);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

    /**
     *
     * 给容器中添加注解
     * 1)包扫描+组件标注解
     * 2)@Bean[导入第三方包组件]
     * 3)@Import[快速给容器导入组件]
     *   1.@Import 导入组件，id为全类名称
     *   2.@ImportSelector:返回需要导入的组件和全类名数组
     *   3.@ImportBeanDefinitionRegistrar:手动注册到bean容器中
     * 4)使用Spring提供FactoryBean(工厂bean)
     */
}

