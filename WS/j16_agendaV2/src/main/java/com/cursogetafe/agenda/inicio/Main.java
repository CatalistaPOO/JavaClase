package com.cursogetafe.agenda.inicio;

import com.cursogetafe.agenda.vista.MenuPrincipal;
import com.cursogetafe.agenda.vista.swing.VInicial;

//Esta clase ejecuta nuestra agenda o bien por consola o bien por vista
public class Main {
	public static void main(String[] args) {
		
		if (args.length !=1) {
			System.err.println("Debe ejecutar Main consola o Main gráfico");
			return;
		}
		if(args[0].equals("grafico")){
				new VInicial();
		}
		else {
			new MenuPrincipal();//Menu por consola
		}
		
	
	}
}