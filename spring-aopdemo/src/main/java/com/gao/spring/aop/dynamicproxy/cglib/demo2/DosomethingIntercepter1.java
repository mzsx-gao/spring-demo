package com.gao.spring.aop.dynamicproxy.cglib.demo2;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DosomethingIntercepter1 implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("DosomethingIntercepter1..."+method.getName() + "执行前...");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("DosomethingIntercepter1..."+method.getName() + "执行后...");
        return object;
    }
}
