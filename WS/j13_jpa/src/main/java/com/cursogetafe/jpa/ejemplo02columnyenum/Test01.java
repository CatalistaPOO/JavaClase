package com.cursogetafe.jpa.ejemplo02columnyenum;

import com.cursogetafe.jpa.config.Config;
import jakarta.persistence.EntityManager;

public class Test01 {

    public static void main(String[] args) {
    	
        EntityManager em = null; // Declara fuera del try para que sea accesible en finally
        
        try {
            em = Config.getEmf().createEntityManager();

            // comprobamos mapeo creando Objeto y mostrando en consola
            Persona02 p = em.find(Persona02.class, 7);
            System.out.println(p);

            // insertamos nueva fila (modo transaccional)
            Persona02 nuevo = new Persona02(0, "Federico", "García Lorca");
            nuevo.setGenero(Genero.MASC);

            em.getTransaction().begin();
            em.persist(nuevo);
            em.getTransaction().commit(); // Se ejecuta si no hay excepción antes
            System.out.println("Persona insertada con éxito!");

        } catch (Exception e) {
            // Si hay un error, intenta hacer rollback
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al realizar la operación: " + e.getMessage());
            e.printStackTrace(); // Para ver la traza completa del error
        } finally {
            // Asegúrarse de cerrar el EntityManager siempre
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}