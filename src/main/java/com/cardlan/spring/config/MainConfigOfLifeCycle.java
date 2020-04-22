package com.cardlan.spring.config;

import com.cardlan.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Bean生命周期:
 *     bean创建--初始化--销毁过程
 * 容器管理bean生命周期：
 * 我们可以自定义初始化和销毁方法，
 *
 * 构造(对象创建)
 *    单实例:在容器启动的时候创建对象
 *    多实例:在容器获取的时候创建对象
 *
 *    BeanPostProcessor.postProcessBeforeInitialization
 *
 *  初始化:
 *      对象创建完成，并赋值好，调用初始化方法
 *      BeanPostProcessor.postProcessAfterInitialization
 *  销毁:
 *      单实例:容器关闭，调用销毁方法
 *      多实例:容器不会管理bean对象，不会调用销毁方法
 *
 * 1)、指定初始化和销毁方法
 *    指定init-method和destry-method
 * 2)、通过Bean实现 InitializingBean(定义初始化逻辑)
 *                 DisposableBean(定义销毁逻辑)
 * 3)、可以使用JSR250
 *        @PostConstruct 在Bean创建完成之后并属性赋值完成，来执行初始化方法
 *         @PreDestroy 在容器销毁bean之前，通知程序进行清理工作
 * 4)、 bean后置处理器：
 *       BeanPostProcessor 在bean初始化前后进行一些处理工作:
 *       postProcessBeforeInitialization:在初始化之前工作
 *      postProcessAfterInitialization :在初始化之后工作
 *
 *  Spring底层对BeanPostProcessor的使用
 *      bean赋值，注入其他组件，@Autowired 生命周期注解功能
 *
 */

@Configuration
@ComponentScan("com.cardlan.spring.bean")
public class MainConfigOfLifeCycle
{

//    @Scope("prototype")
    @Bean(initMethod ="init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
