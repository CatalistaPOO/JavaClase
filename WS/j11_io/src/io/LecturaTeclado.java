package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LecturaTeclado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Buffered reader solo lee clases tipo Reader, pero hay una clase adaptadora que permite recibir inputString
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("pon algo");
		String algo = br.readLine();//Aquí obliga a capturar el error
	}
	
}
