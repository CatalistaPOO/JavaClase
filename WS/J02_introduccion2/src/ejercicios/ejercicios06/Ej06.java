package ejercicios.ejercicios06;

public class Ej06 {
	public static void main(String[] args) {
//		Calcular la potencia
		System.out.println(potencia(3,2));
		
	}
	
	public static double potencia (int num, int exponent) {
		if (exponent == 0){
			return Math.pow(num, exponent = 1);
		}
		return Math.pow(num, exponent);
	}
}