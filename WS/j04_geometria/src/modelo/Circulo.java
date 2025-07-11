package modelo;


public class Circulo extends Figura implements Dibujable{
	
	private double radio;
	
	public Circulo(double x, double y, double radio) {
		super (x, y);
		this.radio = radio;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	
	public double getDiametro() {
		return 2 * radio;
	}
	
	
	public boolean equals(Object otro) {
		if(!super.equals(otro))return false;
		Circulo c = (Circulo)otro;
		return this.radio == c.radio;
	}
	
	
	@Override
	public double perimetro() {
		 return 2 * Math.PI * radio;
	}
	
	@Override
	public double area() {
		return 2 * Math.PI * Math.pow(radio, 2);
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", PI=" + Math.PI + "]";
	}

	@Override
	public void dibujar() {
		System.out.println("Circulo dibujado");
		
	}
	
}