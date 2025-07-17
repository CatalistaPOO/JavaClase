package com.cursogetafe.jpa.ejemplo04pkcompuesta;

import java.io.Serializable;


//esta clase sirve para cumplir con el estandar jp al usar Persona04
public class Dni implements Serializable{
	private int nroDoc;
	private char letraDoc;
	
	
	public Dni() {
	}

	public Dni(int nroDoc, char letraDoc) {
		super();
		this.nroDoc = nroDoc;
		this.letraDoc = letraDoc;
	}
	


	public int getNroDoc() {
		return nroDoc;
	}


	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}


	public char getLetraDoc() {
		return letraDoc;
	}


	public void setLetraDoc(char letraDoc) {
		this.letraDoc = letraDoc;
	}


	@Override
	public String toString() {
		return "Dini [nroDoc=" + nroDoc + ", letraDoc=" + letraDoc + "]";
	}
	
	
}
