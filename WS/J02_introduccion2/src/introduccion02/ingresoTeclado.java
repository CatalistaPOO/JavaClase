package introduccion02;

import java.util.Scanner;//alias de Scanner que es una clase de Java,apunta al path;


public class ingresoTeclado {
	public static void main(String[]arg) {
		//opcion 1 utilizar el nombre canonico
		//java.util.Scanner tec;
		
		//opcion 2: utilizar un import (crea un alias para decir donde se utiliza
		//Scanner tec;
		
		//opcion 3: que nos ayude Eclipse (primeras letras escritas y ctrl + space (creará tambien el import)
		Scanner tec = new Scanner(System.in); //declaramos la variable con la palabra new (Scanner es una clase y tec es el objeto que contiene esa clase)
	
		
		String nombre;// no es un tipo de dato pero se reconoce al ser de la libreria de java.lang
		
		System.out.print("Ingresa tu nombre: "); //salida del texto
		nombre = tec.nextLine(); //variable que contiene lo que se escribe
		
		System.out.println("Hola " + nombre + " que tal estas?");
		
		//if (nombre == "Pablo") //no compara las cadenas
		if (nombre.equals("Pablo")) //cpara comparar strings usaremos el metodo equals y no ==
			System.out.println("son iguales");
		else
			System.out.println("SON DIFERENTES");
		
	}

}
