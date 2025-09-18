package com.cursogetafe.agenda.inicio;

import java.text.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cursogetafe.agenda.config.Config;


//Esta clase ejecuta nuestra agenda o bien por consola o bien por vista
public class Main {
	
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Config.class);
	}
	
}