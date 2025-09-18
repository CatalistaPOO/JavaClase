package com.cursogetafe.dixml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cursogetafe.dixml.persistencia.ClienteDao;

public class Test01 {

	public static void main(String[] args) {
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a01_ctx.xml");
		
		ClienteDao cDao = ctx.getBean("clienteDao", ClienteDao.class);
		
		System.out.println(cDao.findById(75));
		System.out.println(cDao);
		
		
		ClienteDao otro = ctx.getBean("cliente_Dao", ClienteDao.class);//usamos las anotaciones @Component("clienteDao")
		System.out.println(otro);
	}
}
