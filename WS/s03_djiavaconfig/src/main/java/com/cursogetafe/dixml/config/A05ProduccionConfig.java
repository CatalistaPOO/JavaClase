package com.cursogetafe.dixml.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile("produccion")
@PropertySource({"classpath:app.properties"})
public class A05ProduccionConfig {
	
	@Autowired
	Environment prop;
	
	@Bean("dataSource")
	public DataSource getDsProduccion() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(prop.getProperty("bbdd.url"));
		bds.setUsername(prop.getProperty("bbdd.driver"));
		bds.setUsername(prop.getProperty("bbdd.user"));
		bds.setPassword(prop.getProperty("bbdd.pass"));
		return bds;		
	}
	
	
}
