package com.cardlan.spring.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImporSelector implements ImportSelector {


    //AnnotationMetadata：当前标注@Import注解类的所以注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata)
    {
//        annotationMetadata
        return new String[]{"com.cardlan.spring.bean.Blue","com.cardlan.spring.bean.Color","com.cardlan.spring.bean.Red"};
    }
}
