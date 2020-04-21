package com.cardlan.spring.config;

import com.cardlan.spring.bean.Boss;
import com.cardlan.spring.bean.Car;
import com.cardlan.spring.dao.HelloDao;
import com.cardlan.spring.service.HelloService;
import org.springframework.context.annotation.*;

/**
 * 自动装配 :
 *      Spring利用依赖注入(DI),完成对IOC容器中各个组件依赖关系赋值
 * 1)、@Autowired 自动注入
 *     1.默认优先按照类型去找对应的组件:applicationContext.getBean(HelloService.class);
 *     2.如果找到多个相同类型的组件:applicationContext.getBean("helloDao");
 *     3.@Qualifier("helloDao2"):使用@Qualifier指定需要装配组件的id，而不是使用属性名
 *     4.自动装配默认一定要配置好，没有就会报错
 *     5. @Primary:让Spring进行自动装配的时候，默认首选的bean
 *        也可以继续配合@Qualifier指定需要装配的bean名称
 *
 * 2)、Spring还支持@Resource(JSR250)和@Inject(JSR330) java规范
 *   @Resource:
 *      可以和@Autowired一样实现自动装配，默认是按照组件名来装配的
 *  @Inject
 *
 * 3).@Autowired:构造器，参数，方法，属性：都是从容器中获取参数组件的值
 *    1.放在方法上
 *    2.标在构造器上，如果组件只有一个有参构造器，可以省略@Autowired
 *    3.放在参数上:
 * 4) 自定义组件想要使用Spring底层一些组件，（ApplicationContext，BeanFactory）
 *    自定义组件实现xxAware，创建对象时候，会调用接口规定的方法注入项目组件，xxAware
 *
 */
@Configuration
@ComponentScan({"com.cardlan.spring.controller","com.cardlan.spring.bean","com.cardlan.spring.dao","com.cardlan.spring.service"})
public class MainConfigOfAutowired
{

    @Primary
    @Bean("helloDao2")
    public HelloDao helloDao(){
        HelloDao helloDao = new HelloDao();
        helloDao.setAble(2);
        return helloDao;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        HelloService helloService = annotationConfigApplicationContext.getBean(HelloService.class);
        helloService.print();

        Boss boss = (Boss) annotationConfigApplicationContext.getBean("boss");
        System.out.println(boss);

        Car car = (Car) annotationConfigApplicationContext.getBean("car");
        System.out.println(car);
    }

}
