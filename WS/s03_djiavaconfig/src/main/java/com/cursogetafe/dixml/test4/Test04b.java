package com.cursogetafe.dixml.test4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.cursogetafe.dixml.config.A04Config;

@Component("test")
public class Test04b {
	
	private DataSource dataSource;
	
	public Test04b(){
	
	}
	
	@Autowired
	//si hay un solo bin compatible con dataSource, lo inyecta
	//si hay más de uno, se debe indicar cual inyectar con @Qualifier
	public Test04b(@Qualifier("dataSourceProduccion")DataSource dataSource) {
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

		BeanFactory ctx = new AnnotationConfigApplicationContext(A04Config.class);

		Test04b test = ctx.getBean("test", Test04b.class);
		
		test.consulta();
		
	}
}
