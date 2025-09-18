package com.cursogetafe.dixml.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.cursogetafe.dixml.test5"})
@Import({A05DesarrolloConfig.class, A05ProduccionConfig.class})
public class A05Config {

	
}
