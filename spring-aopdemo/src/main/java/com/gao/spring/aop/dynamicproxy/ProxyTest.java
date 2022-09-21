package com.gao.spring.aop.dynamicproxy;

import com.gao.spring.aop.dynamicproxy.cglib_demo1.CglibProxy;
import com.gao.spring.aop.dynamicproxy.cglib_demo1.SayHello;
import com.gao.spring.aop.dynamicproxy.cglib_demo2.CglibBeanFactory;
import com.gao.spring.aop.dynamicproxy.cglib_demo2.service.UserService2;
import com.gao.spring.aop.dynamicproxy.jdk.MyInvocationHandler;
import com.gao.spring.aop.dynamicproxy.jdk.UserService;
import com.gao.spring.aop.dynamicproxy.jdk.UserServiceImpl;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
  jdk和cglib动态代理实现的区别:
  1、jdk动态代理生成的代理类和委托类实现了相同的接口；
  2、cglib动态代理中生成的字节码更加复杂，生成的代理类是委托类的子类，且不能处理被final关键字修饰的方法；
  3、JDK调用代理方法，是通过反射机制调用，Cglib是通过FastClass机制直接调用方法，Cglib执行效率更高
 */
public class ProxyTest {

    //将jdk生成的代理类写入到文件中
    @Test
    public void createProxyClassFile() throws Exception{
        byte[] data = ProxyGenerator.generateProxyClass("$proxy0",new Class[]{UserService.class});
        FileOutputStream out = new FileOutputStream("$proxy0.class");
        out.write(data);
        out.close();

    }
    @Test
    public void testJdkProxy(){
        // 实例化目标对象
        UserService userService = new UserServiceImpl();
        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();
        // 调用代理对象的方法
        proxy.add();
    }

    @Test
    public void testCglibProxy(){
        CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        SayHello proxyImp = (SayHello)proxy.getProxy(SayHello.class);

        proxyImp.say();
    }

    @Test
    public void testCglibProxy2(){
        UserService2 userService = (UserService2) CglibBeanFactory.getInstance();
        System.out.println("返回值："+userService.doSomething0("Jack"));
    }
}