package com.gao.spring.coretest.resolvableTest;

import java.lang.reflect.*;
import java.util.List;

/**
 * 名称: TestType.java
 * 描述: JAVA语法中的类型可以分为五大类
 * 1.组件类型为参数化类型或类型变量的数组
 * 2.参数化类型
 * 3.通配符表达式类型
 * 4.类型变量
 * 5.所有定义的Class（每个类都是一个具体的类型）
 *
 * @author gaoshudian
 * @date 2018/12/13 6:39 PM
 */
public class TestType<T> {

	public T[] a;	//组件类型为类型变量的数据-GenericArrayType

	public List<?>[] b;	//组件类型为参数化类型的数组-GenericArrayType

	/*
	ParameterizedType:参数化类型
	List<? extends Object>携带的"? extends Object"即通配符表达式,也就是WildcardType
	 */
	public List<? extends Object> c;

	public List d;	//Class: 普通类型

	public T e;		//类型变量

	public static void typeDemoTest(String fieldName) throws Exception{
		Field field = TestType.class.getDeclaredField(fieldName);
		Type type = field.getGenericType();
		if(type instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType)type;
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			for (Type actualTypeArg : actualTypeArguments){
				System.out.println(actualTypeArg.getClass());
			}
		}else if(type instanceof GenericArrayType){
            GenericArrayType genericArrayType = (GenericArrayType)type;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            System.out.println(genericComponentType.getClass());
        }else if(type instanceof Class){

        }else if(type instanceof TypeVariable){
		    TypeVariable typeVariable = (TypeVariable)type;
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            System.out.println(genericDeclaration.getClass());
        }
	}

	public static void main(String[] args) throws Exception{
		TestType.typeDemoTest("a");
		TestType.typeDemoTest("b");
		TestType.typeDemoTest("c");
		TestType.typeDemoTest("d");
		TestType.typeDemoTest("e");
	}


}
