package interfaces;

public interface EjemploInterfaz {
	
	static int numerito = 34;
		
		//Antes de Java8 solo existian métodos abstractos en una interfaz
		//Java8 incorpora métodos estáticos y default
		//Java 11 incorpora métodos private
	
	
	//métodos abstractos
	void procesa(String str);
			
	int otroProceso();
			
	//metodos default
	default void haceAlgo() {
		System.out.println("Soy el método default!!");
	}
	
	//métodos static
	static void metodoEstatico() {
		System.out.println("yo soy estático");
	}
	
	//métodos privados
	private String metodoPrivado(){
		return "Soy Privado";
	}
	
	default void metodoDefaultUsaPrivate() {
		System.out.println(metodoPrivado());
	}
	
	//metodos private static
	private static String metodoStaticoPrivado() {
		return "Soy privado y estático";
	}
	
	static void metodoStaticUsaPrivate() {
		System.out.println(metodoStaticoPrivado());
	}
			
			
}
