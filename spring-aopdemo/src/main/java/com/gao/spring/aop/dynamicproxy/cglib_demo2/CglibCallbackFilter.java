package com.gao.spring.aop.dynamicproxy.cglib_demo2;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class CglibCallbackFilter implements CallbackFilter {

    /**
     * 返回值就是回调数组列表中的下标(new Callback[]{callback1,callback2,callback3,noop,fixdValueCallback})
     * 返回哪个下标，就执行哪个回调
     */
    @Override
    public int accept(Method method) {
        if ("doSomething0".equalsIgnoreCase(method.getName())) {
            return 0;
        } else if ("doSomething1".equalsIgnoreCase(method.getName())) {
            return 1;
        } else if ("doSomething2".equalsIgnoreCase(method.getName())) {
            return 2;
        } else if ("xx".equalsIgnoreCase(method.getName())){
            return 3;
        } else {
            return 4;
        }
    }
}