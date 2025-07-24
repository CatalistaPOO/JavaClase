package com.cursogetafe.agenda.inicio;




import com.cursogetafe.agenda.config.Config;
import com.cursogetafe.agenda.vista.MenuPrincipal;
import com.cursogetafe.agenda.vista.swing.VInicial;

//Esta clase ejecuta nuestra agenda o bien por consola o bien por vista
public class Main {
	public static void main(String[] args) {
		//utiliza de app.properties el valor 6 (tipoVista) para saber con qué modo debe iniciar la app (gráfica o
		String tipoVista = Config.getProp().getProperty("tipoVista");
		
		if (tipoVista.equals("grafico"))
			new VInicial();
		else
			new MenuPrincipal();
		
		
		
//		if (args.length !=1) {
//			System.err.println("Debe ejecutar Main consola o Main gráfico");
//			return;
//		}
//		if(args[0].equals("grafico")){
//				new VInicial();
//		}
//		else {
//			new MenuPrincipal();//Menu por consola
//		}
		
	}
}