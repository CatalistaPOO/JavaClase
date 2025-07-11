package tests;

import modelo.Circulo;
import modelo.Dibujable;
import modelo.Punto;
import modelo.Rectangulo;
import modelo.otro.Cliente;

public class Test05Interface {
	public static void main(String[]args) {
		Circulo c = new Circulo(1,3,7);
		Cliente cli =  new Cliente();
		Punto p = new Punto(4,5.5);
		Cliente cli2 =  new Cliente();
		
		Rectangulo r =new Rectangulo(1, 2, 3, 4);//no implementa interface en su clase, dará error
		
		procesaDibs(c,cli, p, cli2);
		
	}
	
	public static void procesaDibs(Dibujable... dibujables) {
		for (int i = 0; i <dibujables.length; i++){
			dibujables[i].dibujar();
		}
	}
	
}