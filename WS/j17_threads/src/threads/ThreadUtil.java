package threads;

import java.util.Random;

//Esta clase es para ayudarse con los metodos sleep
public class ThreadUtil {
	public static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//duerme el hilo actual entre 0 y 2 segundos aleatoriamente
	public static void sleep() {
		sleep(new Random().nextLong(2_000));
	}
}
