package com.gao.spring.aop.dynamicproxy.cglib_demo2;

import com.gao.spring.aop.dynamicproxy.cglib_demo2.callback.DosomethingIntercepter1;
import com.gao.spring.aop.dynamicproxy.cglib_demo2.callback.DosomethingIntercepter2;
import com.gao.spring.aop.dynamicproxy.cglib_demo2.callback.DosomethingIntercepter3;
import com.gao.spring.aop.dynamicproxy.cglib_demo2.callback.FixedValueIntercepter;
import com.gao.spring.aop.dynamicproxy.cglib_demo2.service.UserServiceImpl2;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class CglibBeanFactory {

    public static Object getInstance() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl2.class);
        CallbackFilter callbackFilter = new CglibCallbackFilter();
        enhancer.setCallbackFilter(callbackFilter);

        Callback callback1 = new DosomethingIntercepter1();
        Callback callback2 = new DosomethingIntercepter2();
        Callback callback3 = new DosomethingIntercepter3();
        //这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
        Callback noop = NoOp.INSTANCE;
        //希望某个被代理的方法返回一个固定值
        Callback fixdValueCallback = new FixedValueIntercepter();

        enhancer.setCallbacks(new Callback[]{callback1,callback2,callback3,noop,fixdValueCallback});

        return enhancer.create();
    }
}
