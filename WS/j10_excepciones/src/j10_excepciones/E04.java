package j10_excepciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

import javax.management.RuntimeErrorException;

public class E04 {
	public static void main(String[] args) throws Exception{
		
		try {
			otroProblematico(0);
		}finally {
			//esto se ejecutará siempre aunque haya error si va dentro de finally, aunque el codigo no llegue
			System.out.println("Esto si o si se debe ejecutar");
		}
		
		
	}
	
	
	public static void metodo1() throws IOException{
		try {
			otroProblematico(0);
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			}  /*catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} este tramo si no se supiese solucionar habría que lanzarlo aunque sea el main */
	}
		
	
	public static void metodo2() {
		try {
			otroProblematico(0);
		} catch (FileNotFoundException e) {
			// Arregla FileNotFoundException
			e.printStackTrace();
		} catch (IOException e) {
			// Arregla IOException
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e){
			//arrgla la excepcion Array
		} catch (RuntimeException e) {
			//Arregla runtime
		}
	}
	
	public static void metodo3() {
		try {
			otroProblematico(0);
		} catch (Exception e) {
			//Arregla cualquier excepción(todas heredan de esta)
		} 
	}
	
	public static void metodo4() {
		try {
			otroProblematico(0);
		}catch (ArrayIndexOutOfBoundsException | FileSystemNotFoundException e){
			//Arregla array o file exception
		}catch (RuntimeException | IOException e){
			//Arregla runtime o io exception
		}
	}
	
	
	public static void otroProblematico(int num) throws FileNotFoundException,IOException {
		switch(num) {
		case 1: 
			throw new ArrayIndexOutOfBoundsException();
		case 2:
			throw new RuntimeException();
		case 3:
			throw new FileNotFoundException();//debe lanzarse (en el metodo)or no ser exception tipo catch
		case 4:
			throw new IOException();//debe lanzarse (en el metodo)por no ser exception tipo catch		
		}
	}
	
}
