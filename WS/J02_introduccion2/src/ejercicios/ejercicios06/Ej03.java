package ejercicios.ejercicios06;

public class Ej03 {
	public static void main(String[] args) {
//		Cantidad de dígitos de un número natural.
		int n = 1200;
		System.out.println(cantidadDigitos(n));
		
	}
	public static int cantidadDigitos(int n) {
		//cuando el divisor sea menor que 1
		if (n / 10 < 1) {
			return 1;
		}
		return 1 + cantidadDigitos(n / 10);
	}
}