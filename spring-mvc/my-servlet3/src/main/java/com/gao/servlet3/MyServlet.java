package com.gao.servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//注解方式的sevlet
@WebServlet("/order")
public class MyServlet extends HttpServlet {

    //重写doget方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread()+"start.....");

        try {
            buyCards();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resp.getWriter().write("order sucesful....");
        System.out.println(Thread.currentThread()+" end..........");
    }

    public void buyCards() throws InterruptedException{
        System.out.println(Thread.currentThread()+".............");
        Thread.sleep(5000);//模拟业务操作
    }
}
