package com.gao.spring.coretest.metadataReader;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * metaDataReader示例
 */
public class MetaDataReaderTest {

    @Test
    public void test1() throws Exception {
        CachingMetadataReaderFactory cachingMetadataReaderFactory = new CachingMetadataReaderFactory();
//        FileSystemResource fileSystemResource = new FileSystemResource("demo.class");
//        MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(fileSystemResource);

        String className = "com.gao.spring.coretest.metadataReader.AppConfig";
        MetadataReader metadataReader = cachingMetadataReaderFactory.getMetadataReader(className);
        System.out.println(metadataReader);

        //找出所有被@Bean注解的方法
        Set<MethodMetadata> annotatedMethods =
                metadataReader.getAnnotationMetadata().getAnnotatedMethods(Bean.class.getName());
        for (MethodMetadata annotatedMethod : annotatedMethods) {
            System.out.println(annotatedMethod.getMethodName() + "--" + annotatedMethod.getReturnTypeName());
        }

        //找出类上面的@Configuration注解的属性
        Map<String, Object> annotationAttributes =
                metadataReader.getAnnotationMetadata().getAnnotationAttributes(Configuration.class.getName(), false);
        System.out.println("@Configuration注解的属性:" + annotationAttributes);

        //找出类上面的所有的注解
        MergedAnnotations annotations = metadataReader.getAnnotationMetadata().getAnnotations();
        System.out.println(annotations);

        //获取@Compenent注解
        MergedAnnotation<Component> componentMergedAnnotation = annotations.get(Component.class);
        System.out.println(componentMergedAnnotation);

        //获取@Compenent注解属性
        AnnotationAttributes annotationAttributes1 =
                componentMergedAnnotation.asAnnotationAttributes(MergedAnnotation.Adapt.ANNOTATION_TO_MAP);
        System.out.println(annotationAttributes1);
    }
}
