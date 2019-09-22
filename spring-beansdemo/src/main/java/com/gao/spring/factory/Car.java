package com.gao.spring.factory;

/**
 * Created by gao on 2018/6/11.
 */
public class Car {

    public Car() {
        System.out.println("构造方法");
    }

    public Car(String brand,int price){
        this.brand = brand;
        this.price = price;
    }

    private String brand;

    private int price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
