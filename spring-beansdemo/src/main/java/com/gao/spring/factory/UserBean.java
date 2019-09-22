package com.gao.spring.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;


public class UserBean implements FactoryBean<User>{

	@Override
	public User getObject(){
		User user = new User();
		user.setUserName("abc");

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("ShangHai", 180));
		cars.add(new Car("ShangHai", 130));
		
		user.setCars(cars);
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
