package j10_excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E02LecturaTeclado {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int edad = 0;//se debe definir fuera de catch
		
		System.out.println("Escribe tu edad: ");
		try {
		edad = tec.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Torpe!!");
		}
		
		System.out.println(edad);
	}
}
