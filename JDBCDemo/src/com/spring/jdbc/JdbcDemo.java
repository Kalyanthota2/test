package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbcdemo.dao.JdbcDaoImpl;
import com.spring.jdbcdemo.model.Circle;

public class JdbcDemo {
	
public static void main(String[] args)
{

//Circle circle=new JdbcDaoImpl().getCircle(1);
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Spring.xml");
	JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
	//Circle circle=dao.getCircle(1);
	//System.out.println(circle.getName()+"    "+circle.getId());
    dao.inserCircle(new Circle(5,"fifth Circle"));
	System.out.println(dao.getAllCircles().size());
}

}
