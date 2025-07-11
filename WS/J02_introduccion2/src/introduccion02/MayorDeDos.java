package introduccion02;

import java.util.Scanner;

//ingresar por teclado dos enteros y mostrar el de mayor valor
public class MayorDeDos {
	public static void main(String[]args) {
		Scanner tec = new Scanner(System.in);
		
		int n1, n2, mayor;
		
		System.out.print("Ingresa valor: ");
		n1 = tec.nextInt();//next int especifica que recibe un int como tipo de dato
		
		System.out.print("Ingresa valor: ");
		n2 = tec.nextInt(); //next int especifica que recibe un int como tipo de dato
		
		if (n1 > n2)
			mayor = n1;
		else
			mayor = n2;
		
		// if else se puede sustituir por el uso de condicional 
		//mayor = n1 >n2 ? n1 : n2;
		
		System.out.println("El valor mayor es " + mayor);
	}
}