package ejercicios.ejercicios06;

public class Ej05 {
	public static void main(String[] args) {
//		Calcular el enésimo número de la serie de Fibonacci.
//		F(n) = F(n-1) + F(n-2)
//		F(0) = 0
//		F(1) = 1
		int n = 10;
		for (int i = 0; i <= n; i++) {
		System.out.println("fibonacci de " + i +": " + fibonacci(i));
		}
	}
	
	public static long fibonacci(long n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci (n-2);
 	}
	
}