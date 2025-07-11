package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class ProcesaEntrada {
	//objetivo: leer cualquier entrada de texto
	
	public static void main(String[] args) throws IOException, MalformedURLException{
		
//		FileReader fr = new FileReader("/Users/Mananas/Empleado.java");
//		System.out.println(leerEntrada(fr));
		
		//System.out.println(leerEntrada(System.in));
		
		//una URL es un fichero publico, capturamos en texto el contenido de la URL
		URL url = new URL("https://www.elmundo.es");
		System.out.println(leerEntrada(url.openStream()));
		
	}
	
	public static String leerEntrada(InputStream is) {
		//En este metodo convertimos lo que devuelve leerEntrada en String
		return leerEntrada(new InputStreamReader(is));
	}
	
	public static String leerEntrada(Reader r) {
		StringBuilder sb = new StringBuilder();
		
		try (BufferedReader br = new BufferedReader(r)){
			String linea;
			while ((linea=br.readLine()) != null){
				sb.append(linea + "\n");
			}
		} catch (IOException e) {
			//hacer un log
			throw new RuntimeException();
		}
		return sb.toString();
	}
	
}