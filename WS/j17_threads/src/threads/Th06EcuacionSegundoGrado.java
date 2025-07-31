package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
//Esta clase no está preparada aún
//Esta clase divide en hilos las tareas esperando los resultados en algunos hilos, si falla uno de los procesos debe tirar la excepcion
public class Th06EcuacionSegundoGrado {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		double a = 1;
		double b = -3;
		double c = 2;
		
		//Calcular b al cuadrado, la clase CompletableFuture, abre un nuevo hilo
		CompletableFuture<Double> bCuadrado = CompletableFuture.supplyAsync(() -> {
			ThreadUtil.sleep(3_000);
			System.out.println("Calculando b Cuadrado");
			return b * b;
			});
		
		//Calcular 4*a*c
		CompletableFuture<Double> cuatroAC = CompletableFuture.supplyAsync(() -> {
			ThreadUtil.sleep(4_000);
			System.out.println("Calculando 4*a*c");
			return 4 * a * c;
		});
		
		//calculamos el discriminante => bcuadrado - 4*a*c
		//bcuadrado lo combinamos con cuatroAC.Esa operacion se realizará cuando los dos hayan finalizado
		//Usar thenCombine y le pasaremos una funcion tipo BiFunction
		CompletableFuture<Double> discriminante = bCuadrado.thenCombine(cuatroAC, (b2,ac4) -> {
			ThreadUtil.sleep(1_000);
			System.out.println("Calculando discriminante");
			return b2 - ac4;
		});
		
		//Calcular la raiz del discriminante
		//si el discriminante es menor que 0, lanzamos una excepcion
		CompletableFuture<Double> raizDiscriminante = discriminante.thenApply(d-> {
			ThreadUtil.sleep(3_000);
			if(d<0)
				throw new RuntimeException("Discriminante negativo, no hay raices reales");
			System.out.println("Calculando raíz del discriminante");
			return Math.sqrt(d);
		});
		
		//calcular -b
		CompletableFuture<Double> menosB = CompletableFuture.supplyAsync(() -> {
			ThreadUtil.sleep(500);
			System.out.println("Calculando -b");
			return -b;
		});
		
		//calcular -2a
		CompletableFuture<Double> dosA = CompletableFuture.supplyAsync(() -> {
			ThreadUtil.sleep(750);
			System.out.println("Calculando 2*A");
			return 2*a;
		});
		
		//Calcular x1( (-b + raiz(discriminante) /2a)
		//Combinar menosB con raizDiscriminante y al resultado (cuando termine) lo combinamos con dosA
		CompletableFuture<Double> x1 = menosB.thenCombine(raizDiscriminante, (mB, raiz) -> {
			ThreadUtil.sleep(500);
			System.out.println("Calculando x1");
			return mB + raiz;
		}).thenCombine(dosA, (num, dA)-> num/dA);
		
		//Calcular x2( (-b + raiz(discriminante) /2a)
		//Combinar menosB con raizDiscriminante y al resultado (cuando termine) lo combinamos con dosA
		CompletableFuture<Double> x2 = menosB.thenCombine(raizDiscriminante, (mB, raiz) -> {
			ThreadUtil.sleep(500);
			System.out.println("Calculando x2");
			return mB - raiz;
		}).thenCombine(dosA, (num, dA)-> num/dA);
		
		System.out.println("x1 = " + x1.get());
		System.out.println("x1 = " + x2.get());
		
	}	
}

