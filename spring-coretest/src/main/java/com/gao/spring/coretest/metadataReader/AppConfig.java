package com.gao.spring.coretest.metadataReader;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;


@Configuration
@Component(value = "hello")
public class AppConfig {

    @Bean
    public String test(){
        return "";
    }
}
