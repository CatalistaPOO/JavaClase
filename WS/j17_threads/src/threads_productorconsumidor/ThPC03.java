package threads_productorconsumidor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

import threads.ThreadUtil;


//con esta clase creamos un numero de hilos para gestionar el consumo y produccion a traves del Executor a traves de un pool de hilos
public class ThPC03 {

	private static final int CAPACIDAD = 5;
	private static final LinkedBlockingDeque<Integer> buffer = new LinkedBlockingDeque(CAPACIDAD);
	
	private static final int CANT_PROD = 9;
	private static final int CANT_CONS = 2;
	private static AtomicInteger valor = new AtomicInteger(0);

	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(8);//especifica el numero de hilos con lo que trabajara el sistema operativo
		System.out.println(Runtime.getRuntime().availableProcessors());//con Runtime pregunta procesadores que tiene el sistema operativo

		
		Runnable productor = ()-> {
			while (true) {
				ThreadUtil.sleep();//llamada a nuestra clase para tiempos aleatorios que simula un tiempo de consumo y no sea instantaneo
				int v = valor.getAndIncrement();
					
				buffer.add(v);//bloquea el hilo si no lo puede guardar
				System.out.println(Thread.currentThread().getName() + " produjo " + v);
				System.out.println("--------------");
				}
		};
		
		Runnable consumidor = () -> {
			while(true) {
				int v;
				try {
					v = buffer.take();
					System.out.println(Thread.currentThread().getName()+ " consumio " + v);
					System.out.println("~~~~~~~~~~~");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//no permite extraer si no hay nada, lanza excepcion
						
			}
		};
		
		//Generamos varios consumidores y productores
		for (int i = 0; i <= CANT_PROD; i++) {
			executor.submit(productor);
		}
		
		for (int i = 0; i <= CANT_CONS; i++) {
			executor.submit(consumidor);
			
			
		}
		
	}
}
