package com.gao.spring.aop.dynamicproxy.cglib.demo2;

import org.springframework.cglib.proxy.FixedValue;

/**
 * 希望某个被代理的方法返回一个固定值,其实就相当于是loadObject()方法完全替代了目标方法
 */
public class FixedValueIntercepter implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("==================loadObject value");
        return "my value 111";
    }
}
