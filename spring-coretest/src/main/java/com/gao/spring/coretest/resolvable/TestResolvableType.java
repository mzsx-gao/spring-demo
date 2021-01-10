package com.gao.spring.coretest.resolvable;

import org.junit.Test;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 名称: TestResolvableType.java
 *
 * 描述:ResolvableType为所有的java类型提供了统一的数据结构以及API，换句话说，一个ResolvableType对象就对应着一种java类型
 * ResolvableType封装了Java的Type，提供了getSuperType()方法访问父类型，getInterfaces()返回实现的接口，
 * getGeneric()获取泛型参数，resolve()转化为Class对象
 *
 * ResolvableType的构造函数都是私有的，提供了四类实例化对象的静态方法:
 *
 * forField(Field)：获取指定字段的类型
 * forMethodParameter(Method, int)：获取指定方法的指定形参的类型
 * forMethodReturnType(Method)：获取指定方法的返回值的类型
 * forClass(Class)：直接封装指定的类型
 *
 * 参考文献:https://blog.csdn.net/shenchaohao12321/article/details/80282833
 *
 * @author gaoshudian
 * @date 2018/12/13 8:21 PM
 */
public class TestResolvableType {

    @Test
    public void test1(){
        // 对于继承的父类是泛型的情况
        ParameterizedType genericSuperclass = (ParameterizedType) Student.class.getGenericSuperclass();
        System.out.println(genericSuperclass);
        Type type = genericSuperclass.getActualTypeArguments()[0];
        System.out.println(type);
    }

    @Test
    public void test02() {
        // 对于实现的接口是泛型的处理情况
        ParameterizedType parameterizedType = (ParameterizedType) StringDao.class.getGenericInterfaces()[0];
        System.out.println(parameterizedType);
        Type genericType = parameterizedType.getActualTypeArguments()[0];
        System.out.println(genericType);
    }

    @Test
    public void test03() {
        // Spring的提供工具类,用于获取继承的父类是泛型的信息
        ResolvableType resolvableType = ResolvableType.forClass(Student.class);
        System.out.println(resolvableType);
        Class<?> resolve = resolvableType.getSuperType().getGeneric(0).resolve();
        System.out.println(resolve);
    }

    @Test
    public void test04() {
        // Spring的提供工具类,用于获取实现的接口是泛型的信息
        ResolvableType resolvableType = ResolvableType.forClass(StringDao.class);
        System.out.println(resolvableType);
        Class<?> resolve = resolvableType.getInterfaces()[0].getGeneric(0).resolve();
        System.out.println(resolve);
    }

    @Test
    public void test05() {

        // Spring的提供工具类,用于字段的泛型信息,Person<String>
        ResolvableType resolvableType = ResolvableType.forField(ReflectionUtils.findField(GenericClass.class, "persons"));
        System.out.println(resolvableType);
        // 然后通过如下API得到Person<String>的第0个位置上的泛型实参类型，即String
        Class<?> resolve = resolvableType.getGeneric(0).resolve();
        System.out.println(resolve);
    }

    @Test
    public void test06() {
        ResolvableType resolvableType = ResolvableType.forField(ReflectionUtils.findField(GenericClass.class, "listString"));
        System.out.println(resolvableType);
        // 然后通过如下API得到Person<String>的第0个位置上的泛型实参类型，即String
        Class<?> resolve = resolvableType.getGeneric(0).resolve();
        System.out.println(resolve);
    }

    @Test
    public void test07() {
        // Spring的提供工具类,用于字段的泛型信息,List<List<String>>
        ResolvableType resolvableType = ResolvableType.forField(ReflectionUtils.findField(GenericClass.class, "listLists"));
        System.out.println(resolvableType);
        // 然后通过如下API得到Person<String>的第0个位置上的泛型实参类型，即String
        // Class<?> resolve = resolvableType.getGeneric(0).getGeneric(0).resolve();
        Class<?> resolve = resolvableType.getGeneric(0, 0).resolve();
        System.out.println(resolve);
    }

    @Test
    public void test08() {
        // Spring的提供工具类,用于字段的泛型信息,Map<String, Long>
        ResolvableType resolvableType = ResolvableType.forField(ReflectionUtils.findField(GenericClass.class, "maps"));
        System.out.println(resolvableType);
        // 然后通过如下API得到Person<String>的第0个位置上的泛型实参类型，即String
        Class<?> resolve = resolvableType.getGeneric(0).resolve();
        System.out.println(resolve);
    }

    @Test
    public void test09() {
        // Spring的提供工具类,用于方法的返回值的泛型信息,Map<String, Long>
        ResolvableType resolvableType = ResolvableType.forMethodReturnType(ReflectionUtils.findMethod(GenericClass.class, "getMaps"));
        Class<?> resolve = resolvableType.getGeneric(1).resolve();
        System.out.println(resolve);
    }
}
