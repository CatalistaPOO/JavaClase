package com.getafe.tienda.persistencia;


import java.util.List;

import com.getafe.tienda.config.Config;
import com.getafe.tienda.excepciones.PersistenciaException;
import com.getafe.tienda.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ProductoDaoImpl implements ProductoDao {
	private EntityManagerFactory emf;
	
	public ProductoDaoImpl() {
		emf = Config.getEmf();
	}
	

	@Override
	public Producto findById(int idProducto) {
		EntityManager em= emf.createEntityManager();
		Producto p = em.find(Producto.class, idProducto);
		return p;
	}

	@Override
	public List<Producto> findByDescripcion(String descripcion) {
		EntityManager em = emf.createEntityManager();	
		String jpql = "select p from Producto p where p.producto like :descript ";
		TypedQuery<Producto> q = em.createQuery(jpql, Producto.class);
		q.setParameter("descript", "%" + descripcion + "%");
		List<Producto> resu = q.getResultList();
		em.close();	
		return resu;
	}
	

	@Override
	public List<Producto> findAll() {
		EntityManager em = emf.createEntityManager();	
		String jpql = "select p from Producto p ";
		TypedQuery<Producto> q = em.createQuery(jpql, Producto.class);
		List<Producto> resu = q.getResultList();
		em.close();
		return resu;
	}

	@Override
	public void save(Producto p) {
		final EntityManager em = emf.createEntityManager();
		try (em){
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
		}catch (Exception e){
			em.getTransaction().rollback();
			//log
			e.printStackTrace();
			throw new PersistenciaException();
		}finally {
			em.close();
		}
	}

}
