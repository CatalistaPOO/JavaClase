package recursividad;

public class R01Factorial {
	public static void main(String[] args) {
		
		//metodos que se llaman a sí mismos generando una pila(stack) para su resoulución
		
		System.out.println(factorial(5));
		
		int n = 10;
		for (int i = 0; i <= n; i++) {
		System.out.println("fibonacci de " + i +": " + fibonacci(i));
		}
		
		System.out.println("Sumatoria de " + n + ": " + sumatoria(n));
		
	}
	
	public static long factorial(long n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public static long fibonacci(long n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci (n-2);
 	}
	
	public static long sumatoria(int n) {
		if (n == 1) return 1;
		return n + sumatoria(n-1);
	}
}