package tests;

import modelo.Circulo;
import modelo.Figura;
import modelo.Rectangulo;

public class Test01 {
	public static void  main(String[]args){
		//en la clase no se ha inicializado pero al crear este nuevo objeto,
		//los atributos x e y se inicializan a 0 (los booleanos a false, objetos a null, char a null)
//		Figura f = new Figura();//Figura, al ser clase abstracta, no permite la creación de un objeto
//		System.out.println(f); //devuelve: clase.objeto.hashcode( con @)
		
		
		//04Geometria
				Rectangulo r = new Rectangulo (-1.5, 3.75, 5 , 6);
				Rectangulo r2 = new Rectangulo(2, 3.75, 5, 6);//Su localizacion es diferente (x,y) pero el rectangulo mide lo mismo(lado1,lado2)
				System.out.println(r.equals(r2));
				
				Circulo c = new Circulo (0,0,5);
				Circulo c2 = new Circulo (5,5,5);
				System.out.println(c.toString());
				System.out.print(c.equals(c2));
				
	}
}