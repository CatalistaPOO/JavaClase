package ejercicios.ejercicios05;

import java.util.Scanner;

public class Ej01 {
	public static void main (String[]args) {
	//Crea un programa que intercambie los valores de dos variables.
	
	int n1;
	int n2;
	int temp;
	
	Scanner teclado = new Scanner(System.in);
	
	System.out.println("Introduce numero 1: ");
	n1 = teclado.nextInt();
	
	System.out.println("Introduce numero 2: ");
	n2 = teclado.nextInt();
	
	
	System.out.println("n1: " + n1 + "\nn2: " + n2);
	temp = n1;
	n1 = n2;
	n2 = temp;
	
	System.out.println("Cambiado: \nn1: " + n1 + "\nn2: " + n2);
	
	}
	
	
	
}
