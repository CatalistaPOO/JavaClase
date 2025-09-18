package com.cursogetafe.dixml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.cursogetafe.dixml.persistencia.ClienteDao;
import com.cursogetafe.dixml.config.A01Config;


public class Test01 {

	public static void main(String[] args) {
		
		BeanFactory ctx = new AnnotationConfigApplicationContext(A01Config.class);
		
		ClienteDao cDao = ctx.getBean("clienteDao", ClienteDao.class);
		
		System.out.println(cDao.findById(75));
		System.out.println(cDao);
		
		
		ClienteDao otro = ctx.getBean("cliente_Dao", ClienteDao.class);
		System.out.println(otro);
	}
}
