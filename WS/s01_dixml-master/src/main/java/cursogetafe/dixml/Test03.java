package cursogetafe.dixml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cursogetafe.dixml.negocio.Negocio;

public class Test03 {
	
	public static void main(String[] args) {
		
		
		BeanFactory ctx = new ClassPathXmlApplicationContext("a03_ctx.xml");
		
		Negocio neg = ctx.getBean("negocio", Negocio.class);
		
		System.out.println(neg.proceso(78));
		
	}

}
