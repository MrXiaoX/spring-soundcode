package com.cardlan.spring.config;


import com.cardlan.spring.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile：
 *    Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 *   开发环境、测试环境、生产环境
 *
 *   @Profile: 指定组件在哪个环境下才能注册到容器中,不指定默认都能注册
 *  1) 加了环境标识的bean，只有指定被激活的时候 才能注册到容器中， 默认是default环境
 *  2) 写在配置类上，只有是指定环境时候，整个配置类里面所有配置才生效
 *  3) 没有标注环境标识的bean在任何环境都是加载的
 */
@Configuration
@PropertySource("classpath:/spring/jdbc.properties")
//@Profile("test")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    @Value("${url}")
    private String url;

    private StringValueResolver resolver;

    private String driver;


//    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource testDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource devDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource prodDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {

        this.resolver=resolver;
        driver= resolver.resolveStringValue( "${driver}");
    }
}
