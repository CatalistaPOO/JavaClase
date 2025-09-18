package com.cursogetafe.dixml.test5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;



@Component("test5")
public class Test05 {
	private DataSource dataSource;
	
	
	public Test05(){
		
	}
	
	@Autowired
	public Test05(DataSource dataSource) {
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

		BeanFactory ctx = new ClassPathXmlApplicationContext("a05_ctx.xml");

		Test05 test = ctx.getBean(Test05.class);
		
		test.consulta();
		
	}
}
