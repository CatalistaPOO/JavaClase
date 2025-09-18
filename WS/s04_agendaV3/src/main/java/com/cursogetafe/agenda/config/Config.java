package com.cursogetafe.agenda.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import jakarta.persistence.EntityManagerFactory;//pertenece a hibernate
import jakarta.persistence.Persistence;

@Configuration
@PropertySource({"app.properties"})
@ComponentScan({"com.cursogetafe.agenda"})
public class Config {
	
	@Autowired
	Environment prop;
	
	@Bean("dataSource")
	@Profile({"jpa","default"})
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("agenda");
	}
	 
	 @Bean("dataSource")
	 @Profile("jdbc")
	 public  DataSource getDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(prop.getProperty("bbdd.url"));
		bds.setDriverClassName(prop.getProperty("bbdd.driver"));
		bds.setUsername(prop.getProperty("bbdd.user"));
		bds.setPassword(prop.getProperty("bbdd.password"));
		return bds;
	}
		
}