package com.cursogetafe.agenda.persistencia;

import java.util.Set;

import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.jpa.config.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ContactoDaoJPA implements ContactoDao{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ContactoDaoJPA() {
		emf = Config.getEmf();
	}

	@Override
	public void insertar(Contacto c) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
	}

	@Override
	public void actualizar(Contacto c) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		
	}

	@Override
	public boolean eliminar(int idContacto) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			
			em.remove(em.find(Contacto.class, idContacto));
			em.getTransaction().commit();
			emf.close();
			return true;
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			emf.close();
			return false;
		}
	
	}

	@Override
	public boolean eliminar(Contacto c) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
			emf.close();
			return true;
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			emf.close();
			return false;
		}
	}

	@Override
	public Contacto buscar(int idContacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscar(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
