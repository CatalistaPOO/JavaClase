package com.getafe.tienda.persistencia;

import java.util.HashSet;
import java.util.Set;

import com.getafe.tienda.config.Config;
import com.getafe.tienda.excepciones.PersistenciaException;
import com.getafe.tienda.modelo.Fabricante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class FabricanteDaoImpl implements FabricanteDao {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public FabricanteDaoImpl() {
		emf = Config.getEmf();
	}
	
	
	@Override
	public void save(Fabricante fabricante) {
		EntityManager em = emf.createEntityManager();
		try(em) {
			em.getTransaction().begin();
			em.merge(fabricante);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			//log
			e.printStackTrace();
			throw new PersistenciaException();
		}
	}

	@Override
	public Fabricante findByIdLazy(int idFabricante) {
		em = emf.createEntityManager();
		Fabricante f = em.find(Fabricante.class, idFabricante);
		em.close();
		return f;
	}

	@Override
	public Fabricante findById(int idFabricante) {
		em = emf.createEntityManager();
		String jpql = "select f from Fabricante f left join fetch f.productos where f.idFabricante = :id";
		TypedQuery<Fabricante> q = em.createQuery(jpql, Fabricante.class);
		q.setParameter("id", idFabricante);
		Fabricante resu = q.getSingleResultOrNull();
		em.close();
		return resu;
	}

	@Override
	public Set<Fabricante> findOnlyActive() {
		em = emf.createEntityManager();
		String jpql = "select f from Fabricante f join f.productos";
		TypedQuery<Fabricante> q = em.createQuery(jpql, Fabricante.class);
		Set<Fabricante> resu = new HashSet<Fabricante>(q.getResultList());
		em.close();
		return resu;
	}

	@Override
	public Set<Fabricante> findAll() {
		em = emf.createEntityManager();
		String jpql = "select f from Fabricante f";
		TypedQuery<Fabricante> q = em.createQuery(jpql, Fabricante.class);
		Set<Fabricante> resu = new HashSet<Fabricante>(q.getResultList());
		em.close();
		return resu;
	}

}
