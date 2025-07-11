package tests;

import modelo.Rectangulo;
import modelo.Circulo;
import modelo.Figura;
import modelo.Punto;

public class Test04CentroMasas {

	public static void main(String[] args) {
		Rectangulo r1  =  new Rectangulo (1, 1, 2, 5);
		Rectangulo r2  =  new Rectangulo (5, 2, 5, 10);
		Circulo c1 = new Circulo (1, 1, 1);
		Circulo c2 = new Circulo (3, 10, 5);
		
		Punto centroMasa = Figura.getCentroMasa(r1,r2,c1,c2);
		System.out.println("Coordenadas X,Y del punto de centro de masa: " + centroMasa);
		System.out.println("cortando a dos decimales coordenadas X,Y de l punto: " + Figura.redondeo(centroMasa.getX()) + "," + Figura.redondeo(centroMasa.getY()) );
		
	}

	
	
}