package ejercicios.ejercicios06;

public class Ej02 {
	public static void main(String[] args) {
		//	Suma de los primeros n números naturales.
		int n = 10;
		System.out.println("Sumatoria de " + n + ": " + sumatoria(n));
	}
	
	public static long sumatoria(int n) {
		if (n == 1) return 1;
		return n + sumatoria(n-1);
	}
}
