package com.cardlan.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat 构造");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat 销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat  属性设置之后");
    }
}
