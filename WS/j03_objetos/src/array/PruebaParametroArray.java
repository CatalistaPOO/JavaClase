package array;


public class PruebaParametroArray {
	
	public static void otroMetodo(String algo,String otro, int ...nums) {
		
	}
	
	
	public static int suma (int... nums) {
		int suma = 0;
		for (int i = 0; i < nums.length; i++) {
			suma += nums[i];
		}
		return suma;
	}
	
	public static void main(String[]args) {
		
		System.out.println (suma(17,25));
		System.out.println (suma(17,25, 45));
		
		int[] numeritos = {1, 2, 3, 4, 8};
		System.out.println(suma(numeritos));
		
	}
	
}
