package com.cardlan.spring.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param annotationMetadata 当前类的信息
     * @param beanDefinitionRegistry :BeanDefinition 注册类
     *       把所以需要添加到容器的bean调用beanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.cardlan.spring.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.cardlan.spring.bean.Blue");
        if(red&&blue)
        {
            //定义bean信息，bean类型
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //指定bean名称
            beanDefinitionRegistry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
