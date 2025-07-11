package ejercicios.ejercicios05;

public class Ej06 {
	public static void main(String[] args) {
//		Simula el lanzamiento de un dado de 6 caras utilizando números aleatorios.
		
		for (int i= 0; i < 10; i++) {
			int nDado = (int)Math.ceil(Math.random() * 6);
			System.out.println(nDado);
		}
	}
}