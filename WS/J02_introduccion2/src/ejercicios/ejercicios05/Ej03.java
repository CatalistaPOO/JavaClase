package ejercicios.ejercicios05;

import java.util.Scanner;

public class Ej03 {
	public static void main(String[] args) {
		//Escribe un método que retorne la suma de los dígitos de un número entero (ejemplo: 1234 -> 1+2+3+4 = 10).
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce numero entero para sumar sus digitos: ");
		String n = teclado.nextLine();
		int suma = 0;
		
		for (int i = 0; i < n.length(); i++) {
			suma += Integer.valueOf(n.charAt(i));
		}
		
		System.out.println("La suma de " + n + " es: " + suma);
	}
}