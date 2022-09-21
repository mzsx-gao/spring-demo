package com.gao.servlet3;

import com.gao.servlet3.other.OrderFilter;
import com.gao.servlet3.other.OrderListener;
import com.gao.servlet3.other.OrderServlet;
import com.gao.servlet3.service.MyService;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

//容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来；
@HandlesTypes(value = {MyService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    //arg0:父类感兴趣的类的子类型
    //ServletContext arg1:....代表当前web应用,注册3组件
    @Override
    public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {

        System.err.println("感兴趣的类型");
        for (Class<?> claz : arg0) {
            System.err.println(claz);// 反射
        }

        //==========编码形式注册三大组件==================
        //注册OrderServlet组件
        javax.servlet.ServletRegistration.Dynamic servlet = sc.addServlet("orderServlet", new OrderServlet());
        servlet.addMapping("/orderTest");

        //注册filter
        javax.servlet.FilterRegistration.Dynamic filter = sc.addFilter("orderFilter", OrderFilter.class);
//		filter.setAsyncSupported(true);//异步支持
        //添加filer的映射信息，可以指定专门来拦截哪个servlet
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

        //注册监听器listener
        sc.addListener(OrderListener.class);
    }
}