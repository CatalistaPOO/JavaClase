package com.cursogetafe.agenda.vista;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.cursogetafe.agenda.negocio.Agenda;
import com.cursogetafe.agenda.negocio.AgendaImpl;
import com.cursogetafe.agenda.util.Util;

@Component
@Profile("consola")
public class MenuPrincipal {
	
	private Agenda agenda;
	
	public MenuPrincipal() {
		
	}
	
	@Autowired
	public MenuPrincipal(Agenda agenda) {
		this.agenda = agenda;
		menu();
	}
	
	public void menu() {
		System.out.println("SUPER AGENDA XX 7 PLUS");
		System.out.println("----------------------");
		boolean salir = false;
		int opcion;
		
		do {
			System.out.println("\nMenu Principal");
			System.out.println("1 - Nuevo Contacto");
			System.out.println("2 - Buscar contactos");
			System.out.println("3 - Listar todos");
			System.out.println("4 - Eliminar Contacto");
			System.out.println("5 - Importar contactos");
			System.out.println("9 - Salir");
			System.out.println("Opción: ");
			opcion = Util.leerInt();
			
			switch (opcion) {
			case 1:
				new NuevoContacto(agenda);
				break;
			case 2:
				new BuscarContacto(agenda);
				break;
			case 3:
				new ConsultarTodos(agenda);
				break;
			case 9:
				salir = true;
			}
		} while(!salir);
	}
}
