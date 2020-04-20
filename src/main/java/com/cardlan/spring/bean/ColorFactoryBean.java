package com.cardlan.spring.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean 实例创建");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否单例
    //true:这个bean为单例，在容器只会保存一份
    //false:bean为多例，每次都创建一个新bean
    @Override
    public boolean isSingleton() {
        return false;
    }
}
