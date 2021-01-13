package com.gao.spring.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 名称: AppConfig
 * 描述: 自动装配方式实现aop
 *
 * @author gaoshudian
 * @date 2021/1/13 20:54
 */
@EnableAspectJAutoProxy
@Import({LoggingAspect.class,VlidationAspect.class,ArithmeticCalculatorImpl.class})
@Configuration
public class AppConfig {
}
