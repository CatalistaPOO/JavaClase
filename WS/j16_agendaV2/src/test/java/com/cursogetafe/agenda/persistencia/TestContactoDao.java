package com.cursogetafe.agenda.persistencia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.modelo.Domicilio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

class TestContactoDao {
	//para uso de los test
	private static EntityManagerFactory emf;
	private static ContactoDao cDao;

	@BeforeAll //se ejecuta antes de empezar los test
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("agenda_test");
		cDao = new ContactoDaoJPA(emf);//usamos constructor que envía su propio EntityManagerFactory
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach //se ejecuta tras finalizar cada test vaciando la base de datos
	void tearDown() throws Exception {
		String jpql = "delete from Contacto";
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery(jpql);
		q.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
	
	//este metodo es el constructor, no se usa.
//	@Test
//	void testContactoDaoJPA() {
//		fail("Not yet implemented");
//	}

	//este metodo esta usado en el resto de metodos
//	@Test
//	void testInsertar() {
//		fail("Not yet implemented");
//	}

	@Test
	void testActualizar() {
		Contacto nuevo = crearContacto(1); 
		cDao.insertar(nuevo);
		
		nuevo.setApellidos("nuevoApellido");
		nuevo.addCorreos("nuevoCorreo");
		nuevo.addTelefonos("nuevoTelefono");
		
		cDao.actualizar(nuevo);
		
		Contacto otro = cDao.buscar(nuevo.getIdContacto());
		assertNotNull(otro);
		assertEquals(2, otro.getCorreos().size());
		assertEquals(2, otro.getTelefonos().size());
	}

	@Test
	void testEliminarInt() {
		Contacto nuevo = crearContacto(1); 
		cDao.insertar(nuevo);
		
		assertTrue(cDao.eliminar(nuevo.getIdContacto()));
		
		assertEquals(0, cDao.buscarTodos().size());
		
		//intentar eliminar uno que no existe
		Contacto noExiste = crearContacto(1);
		noExiste.setIdContacto(894);
		assertFalse(cDao.eliminar(noExiste));
	}

	@Test
	void testEliminarContacto() {
		Contacto nuevo = crearContacto(1); 
		cDao.insertar(nuevo);
		
		assertTrue(cDao.eliminar(nuevo));
		
		assertEquals(0, cDao.buscarTodos().size());
		
		//intentar eliminar uno que no existe
		Contacto noExiste = crearContacto(1);
		noExiste.setIdContacto(894);
		assertFalse(cDao.eliminar(noExiste));
	}

	@Test
	void testBuscarInt() {
		//para buscar debemos crear el contacto e insertarlo
		Contacto nuevo = crearContacto(14); 
		cDao.insertar(nuevo);
		
		int id = nuevo.getIdContacto();
		//comprobamos si existe
		Contacto otro = cDao.buscar(id);
		assertNotNull(otro);
		//vemos si encuentra el que hemos creado
		assertEquals(id, otro.getIdContacto());
		assertEquals(14, otro.getCorreos().size());
		assertEquals(14, otro.getTelefonos().size());
	}
	
	@Test
	void testBuscarIntnoexiste() {
		assertNull(cDao.buscar(666));
	}

	@Test
	void testBuscarString() {
		for(int i = 1; i <=100; i++) {
			cDao.insertar(crearContacto(i));
		}
		Set<Contacto> resu = cDao.buscar("nombre75");
		assertEquals(1, resu.size());
		
		resu = cDao.buscar("5");
		assertEquals(19, resu.size());
		
		resu = cDao.buscar("nom");
		assertEquals(100, resu.size());
		
		resu = cDao.buscar("ape");
		assertEquals(100, resu.size());
		
		resu = cDao.buscar("apo");
		assertEquals(100, resu.size());
		
	}

	@Test
	void testBuscarTodosVacio() {
		Set<Contacto> resu = cDao.buscarTodos();//guardamos lo que devuelve buscar todos desde ContactoJdao
		assertEquals(0, resu.size());//comprueba si es igual a 0(nuestra BBDD lo está(11_agenda_test))
	}
	@Test
	void testBuscarTodos() {
		for(int i = 1; i <=100; i++) {
		cDao.insertar(crearContacto(i));
		}
		Set<Contacto> resu = cDao.buscarTodos();
		assertEquals(100,resu.size()); 
		
		for (Contacto contacto :resu) {
		assertEquals("ciudad", contacto.getDom().getCiudad());
		//si esta en modo lazy debe saltar el assert, y ejecuta del contacto, el tamaño de getcorreo y getTelefonos
		assertThrows(LazyInitializationException.class, () -> contacto.getCorreos().size());// ()-> esto convierte en ejecutable(en este caso hace algo y no devuelve nada)
		assertThrows(LazyInitializationException.class, () -> contacto.getTelefonos().size());// ()-> esto convierte en ejecutable(en este caso hace algo y no devuelve nada)
		
		
		}
	}
	
	private Contacto crearContacto(int nroContacto) {
		Domicilio dom = new Domicilio("tv", "via", nroContacto, nroContacto, "puerta", "cp", "ciudad", "prov");
		Contacto nuevo = new Contacto(0, "nombre" + nroContacto, "apellidos"+nroContacto, "apodo"+nroContacto, dom);
		for (int i= 1; i<= nroContacto; i++) {
			nuevo.addCorreos("correo"+i+"@test.test");
			nuevo.addTelefonos("666"+i);
		}
		return nuevo;
		
	}

}
