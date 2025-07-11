package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	public static void main(String[] args) {
		
		String fichero = "/Users/Mananas/Empleado.java"; //Path del archivo que leemos
		System.out.println(LeerFichero(fichero));
//		System.out.println(muestraFichero(fichero));
		
	}
	
	public static String LeerFichero(String fichero) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))){
			//lee todo el contenido con un aotoclosable(el BufferedReader de try)
			String linea;
			while ((linea = br.readLine()) != null) {
				sb.append(linea + "\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	public static String muestraFichero(String fichero) {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			//lee todo el contenido el fichero y lo almacena en sb
			br = new BufferedReader(new FileReader(fichero));//Buffered Reader espera otro reader,FileReader será el nombre del archivo.
			String linea;
			while ((linea = br.readLine()) != null) {
				sb.append(linea + "\n");
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (br !=null) {
				//si el archivo se pudo abrir (podría fallar, de ahí el try siguiente)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return sb.toString();
	}
	
}
