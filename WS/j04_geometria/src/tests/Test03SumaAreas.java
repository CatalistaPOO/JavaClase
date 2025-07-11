package tests;

import modelo.Circulo;
import modelo.Figura;
import modelo.Rectangulo;

public class Test03SumaAreas {
	
	public static double sumaAreas(Figura... figs) {
		double sumaArea = 0;
		for (int i = 0; i < figs.length; i++) {
			 sumaArea += figs[i].area();
		}
		return sumaArea;
	}
	
	public static void main(String[]args) {
	
	Figura c1 = new Rectangulo (2, 2, 4, 8);
	Figura c2 = new Circulo(0, 0, 5);
	
	Figura[] figuritas = {c1,c2};
	
	
	
	System.out.println(Figura.redondeo(sumaAreas(figuritas)) + "m2");
	
	}

}