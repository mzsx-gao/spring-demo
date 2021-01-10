package com.gao.spring.aop.dynamicproxy.cglib.demo2;

/**
 * cglib动态代理测试
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        UserService userService = (UserService) CglibBeanFactory.getInstance();
        System.out.println(userService.doSomething0("Jack"));
    }

}
