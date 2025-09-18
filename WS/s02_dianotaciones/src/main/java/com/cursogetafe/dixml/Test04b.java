package com.cursogetafe.dixml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("test")
public class Test04b {
	
	private DataSource dataSource;
	
	public Test04b(){
		
	}
	
	@Autowired
	//si hay un solo bin compatible con dataSource, lo inyecta
	//si hay más de uno, se debe indicar cual inyectar con @Qualifier
	public Test04b(@Qualifier("datasourceProduccion")DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public void consulta() throws SQLException {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from productos");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + ": " + rs.getString(2));
		}
		
		con.close();
	}
	
	
	public static void main(String[] args) throws SQLException {

		BeanFactory ctx = new ClassPathXmlApplicationContext("a04_ctx.xml");

		Test04b test = ctx.getBean(Test04b.class);
		
		test.consulta();
		
	}
}
