package com.cursogetafe.dixml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cursogetafe.dixml.negocio.Negocio;

public class Test02 {
	public static void main(String[] args) {
		BeanFactory ctx = new AnnotationConfigApplicationContext("A02Config.class");
		
//		Negocio neg = ctx.getBean("negocio", Negocio.class);
//		
//		System.out.println(neg.proceso(78));
	}
}