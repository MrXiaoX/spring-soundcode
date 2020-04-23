package com.cardlan.spring.config;


import com.cardlan.spring.aop.LogAspects;
import com.cardlan.spring.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *  AOP:动态代理
 *      指程序运行期间动态讲某段代码切入到指定方法指定位置进行运行编译方式
 *
 *
 * 1.导入AOP模块:SpringAOP
 * 2.定义业务逻辑类(MathCalculator)：在业务逻辑运行的时候将日志进行打印（方法之前，方法结束，方法出现异常）
 * 3.定义日志切面类(LogAspects) 切面类方法需要动态代理感知MathCalculator.div运行到哪里进行执行
 *     通知方法:
 *          前置通知@Before:logStart，在目标方法执行前运行
 *          后置通知@After():logEnd，在目标方法执行后运行
 *          返回通知@AfterReturning:logReturn，在目标方法执行正常结束后运行
 *          异常通知@AfterThrowing:logException，在目标方法执行异常后运行
 *          环绕通知@Around:动态代理，手动推进目标方法运行@Pointcut
 *  4.给切面类的目标方法标注何时何地运行（通知注解）
 *  5.将切面类和业务逻辑类（目标方法所在类）都加入容器中
 *  6.必须告诉Spring 哪个类是切面类(给切面类加上一个注解 @Aspect)
 *  7.给配置类加@EnableAspectJAutoProxy 开启基于注解类的aop模式
 *       在spring配置EnableXXX
 *
 *  三步:
 *   1)、将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类(@Aspect)
 *   2)、在切面类上的每一个通知方法上标通知注解:告诉Spring何时何地运行切入点表达式()
 *   3)、开启基于注解AOP模块式：@EnableAspectJAutoProxy
 *
 *  AOP原理:
 *        @EnableAspectJAutoProxy
 *  1、@EnableAspectJAutoProxy
 *      @Import(AspectJAutoProxyRegistrar.class) 给容器导入AspectJAutoProxyRegistrar.class组件
 *      利用
 *      internalConfigurationAnnotationProcessor
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP
{
    //业务逻辑加入容器
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    //切面类加入容器
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }


}
