package com.gao.spring.factory;

import java.util.ArrayList;
import java.util.List;

import com.gao.spring.helloworld.Car;
import com.gao.spring.helloworld.User;
import org.springframework.beans.factory.FactoryBean;


public class UserBean implements FactoryBean<User>{

	@Override
	public User getObject() throws Exception {
		User user = new User();
		user.setUserName("abc");

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("ShangHai", "BuiKe", 180, 300000));
		cars.add(new Car("ShangHai", "CRUZE", 130, 150000));
		
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
