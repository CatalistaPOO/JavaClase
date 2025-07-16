package com.cursogetafe.jpa.ejemplo01;

import java.sql.PreparedStatement;

import com.cursogetafe.jpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Test01 {
	public static void main(String[] args) {
		//unidad de persistencia para conexión (pool o DataSource)
		EntityManagerFactory emf = Config.getEmf();
		//Interactua con la persistencia
		EntityManager em = emf.createEntityManager();
		
		//Tendríamos que hacer el proceso de crear la conexion, leer el driver, hacer la consulta y recogerla
		//String sql = "select idpersona,apellidos, nombre, apodo, dni from persona where idpersona = ?";
		//PreparedStatement ps = cx.prepareStatement(sql);
		//ps.setInt(1,12);
		//ResultSet rs = ps.executeQuery();
		//if (rs.next()) {
		//	Personap p = new Persona();...	todo este proceso se sustituye por las lineas de abajo
		
		//Lo sustituimos por este proceso con Maven(librerias jakarta) que simplifica todo
		Persona p = em.find(Persona.class, 12);
		if (p != null)
			System.out.println(p);
		else
			System.out.println("Esta Persona no existe!!");
		}
}