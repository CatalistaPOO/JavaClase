package introduccion02;

import java.util.Scanner;

public class MayorDeTres {
	public static void main(String[]args) {
		Scanner textconsola = new Scanner(System.in);
		
		int n1, n2, n3, mayor;
		
		System.out.print("Escribe primer valor: ");
		n1 = textconsola.nextInt();
		
		System.out.print("Escribe segundo valor");
		n2 = textconsola.nextInt();
		
		System.out.print("Escribe tercer valor: ");
		n3 = textconsola.nextInt();
		
		//logica: es n1 el mayor, lo es n2, entonces sera n3
		
		if (n1 >= n2 && n1 >= n3)
			mayor = n1;
		
		else if (n2 >= n3)
			mayor = n2;
		
		else 
			mayor= n3;

		System.out.println("El numero mayor es: " + mayor);
	}

}