package ejercicios.ejercicios06;

public class Ej01 {
	public static void main(String[] args) {
//		Factorial de n.
//		n! = n . (n-1)!
//		0! = 1
		
		System.out.println(factorial(5));	
		
	}
	
	public static long factorial(long n) {
		if(n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
}	