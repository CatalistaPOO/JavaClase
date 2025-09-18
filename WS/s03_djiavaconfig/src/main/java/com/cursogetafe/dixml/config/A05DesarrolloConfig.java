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
@Profile({"desarrollo", "default"})
@PropertySource({"classpath:app.properties"})
public class A05DesarrolloConfig {
	
	@Autowired
	Environment prop;
				
	@Bean("dataSource")
	public DataSource getDsDesarrollo() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(prop.getProperty("test.bbdd.url"));
		bds.setUsername(prop.getProperty("test.bbdd.driver"));
		bds.setUsername(prop.getProperty("test.bbdd.user"));
		bds.setPassword(prop.getProperty("test.bbdd.pass"));
		return bds;
	}
	
	
}
