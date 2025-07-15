package jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
//DataSource lee en origen de lacarpeta que contiene los drivers JDBC (DriversJar), carpeta exterior a los projectos Java(WS)
import org.apache.commons.dbcp.BasicDataSource;

public class Prueba01 {

	public static void main(String[] args) {
		
		BasicDataSource bds = new BasicDataSource();//objeto pool, intermedia para gestinar conexiones entre cliente y Servidor de BBDD
		bds.setUrl("jdbc:mysql://localhost:3366/11_agenda");//path base de datos que usamos
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");//Driver que usamos
		bds.setUsername("root");//Usuario que usa la Base de datos
		bds.setPassword("root");//Password del usuario
		
		//BasicDataSource implementa a DataSource(DataSource no tiene los metodos de BasicDataSource)
		DataSource ds = bds;
		
		try (Connection cx = ds.getConnection()){
			PreparedStatement ps = cx.prepareStatement("select nombre, apodo from contactos where idcontactos < 30");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("nombre") + " - " + rs.getString("apodo"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}