package com.gao.spring.aop.dynamicproxy.cglib_demo2.service;

public class UserServiceImpl2 implements UserService2 {
    @Override
    public String doSomething0(String param) {
        System.out.println("==============doSomething0");
        return "doSomething0";
    }

    @Override
    public String doSomething1(String param) {
        System.out.println("==============doSomething1");
        return "doSomething1";
    }

    @Override
    public String doSomething2(String param) {
        System.out.println("==============doSomething2");
        return "doSomething2";
    }

    @Override
    public String myMethod(String param) {
        System.out.println("==============myMethod");
        return "myMethod";
    }
}