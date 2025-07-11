package interfaces;

public class TestInterfaces {
	
	public static void main(String[] args) {
		
		//creamos un objeto anónimo de una clase anónima
		EjemploInterfaz iNormal = new EjemploInterfaz() {

			@Override
			public void procesa(String str) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int otroProceso() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		iNormal.procesa("hola que tal");
		System.out.println(iNormal.otroProceso());
		
		
		//solo definimos el metodo abstracto
		MiInterfazFuncional iFuncional = new MiInterfazFuncional() {
			
			@Override
			public void haceAlgo() {
				System.out.println("haciendo algo...");
				
			}
		};
		
		iFuncional.haceAlgo();
		// podemos usar una expresion lambda (->)
		MiInterfazFuncional iFuncional2 = () -> {
			System.out.println("soy  el método haceAlgo() desde lambda");
		};
		iFuncional2.haceAlgo();
		
	}
}
