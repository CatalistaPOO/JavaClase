package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Th04Sincronizacion {
	
	public static void main(String[] args) {
//		m1();
		
//		//m1() hilos dessincronizados
//		Thread th1 = new Thread(()->{
//		//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
//			while (true) {
//				ThreadUtil.sleep();
//				m1();
//			}
//		});
//			
//		Thread th2 = new Thread(()->{
//			//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
//			while (true) {
//				ThreadUtil.sleep();
//				m1();
//				}
//		});
		
//		//m1() hilos sincronizados
//		Thread th1 = new Thread(()->{
//		//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
//			while (true) {
//				ThreadUtil.sleep();
//				m2();
//			}
//		});
//			
//		Thread th2 = new Thread(()->{
//			//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
//			while (true) {
//				ThreadUtil.sleep();
//				m2();
//				}
//		});
		
//		//m1() hilos sincronizados en un bloque de codigo del metodo al que se llama, Object lock lo gestiona
//		Object lock = new Object();
//		Thread th1 = new Thread(()->{
//		//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
//			while (true) {
//				ThreadUtil.sleep();
//				m3(lock);
//			}
//		});
//			
//		Thread th2 = new Thread(()->{
//			//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
//			while (true) {
//				ThreadUtil.sleep();
//				m3(lock);
//				}
//		});
		
		//m1() hilos sincronizados en un bloque de codigo del metodo al que se llama, la clase Lock lo gestiona
		 Lock lock = new ReentrantLock();
		Thread th1 = new Thread(()->{
			//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
			while (true) {
				ThreadUtil.sleep();
				m4(lock);
			}
		});
		
		Thread th2 = new Thread(()->{
			//Con lambda(es una interface funcional(1solo metodo abstracto)) le pasamos el sleep de nuestra clase ThreadUtil
			while (true) {
				ThreadUtil.sleep();
				m4(lock);
			}
		});
		
		
			
			th1.start();
			th2.start();
		
		
	}

	public static void m1() {
		//los hilos tienen un nombre automatico, con esto lo rescatamos
		System.out.println(Thread.currentThread().getName() + " entrando");
		ThreadUtil.sleep();
		//los hilos tienen un nombre automatico, con esto lo rescatamos
		System.out.println(Thread.currentThread().getName() + " saliendo");
		
		System.out.println("--------------------");
	}
	
	//este metodo añade el modificador synchronized(nunca hay dentro del metodo dos hilos,permitiendo la ejecucion sin solapamiento)
	public static synchronized void m2() {
		//los hilos tienen un nombre automatico, con esto lo rescatamos
		System.out.println(Thread.currentThread().getName() + " entrando");
		ThreadUtil.sleep();
		//los hilos tienen un nombre automatico, con esto lo rescatamos
		System.out.println(Thread.currentThread().getName() + " saliendo");
		
		System.out.println("--------------------");
	}
	
	//este metodo añade el modificador synchronized recibiendo un objeto que gestiona la sincronizacion
	//para gestionar un bloque del metodo en vez del metodo entero
	public static void m3(Object lock) {
		System.out.println(Thread.currentThread().getName() + " hace cosas");
		
//		Llamamos al objeto que gestiona el bloque al que entra un solo hilo a la vez
		synchronized(lock){
			//los hilos tienen un nombre automatico, con esto lo rescatamos
			System.out.println(Thread.currentThread().getName() + " entrando");
			ThreadUtil.sleep();
			//los hilos tienen un nombre automatico, con esto lo rescatamos
			System.out.println(Thread.currentThread().getName() + " saliendo");
		
		System.out.println("--------------------");
		}
	}
	
	//Usamos lock para bloquear, pero de la clase Lock, no de la clase objeto,
	//permitiendo la entrada y salida en trozos parciales del metodo con lock y unlock que son metodos de Lock
	public static void m4(Lock lock) {
		System.out.println(Thread.currentThread().getName() + " hace cosas");
		
//		Llamamos al objeto que gestiona el bloque al que entra un solo hilo a la vez
		lock.lock();
			//los hilos tienen un nombre automatico, con esto lo rescatamos
			System.out.println(Thread.currentThread().getName() + " entrando");
			ThreadUtil.sleep();
			//los hilos tienen un nombre automatico, con esto lo rescatamos
			System.out.println(Thread.currentThread().getName() + " saliendo");
			
			System.out.println("--------------------");
		lock.unlock();
	}
	
	
}