package modelo;

public abstract class Figura {
	
		//en esta clase no se ha definido un constructor, Java generará un constructor automáticamente.
	
		private double x;
		private double y;
		
		public Figura() {
		
		}
		
		public Figura(double x,double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getX() {
			return x;
		}


		public void setX(double x) {
			this.x = x;
		}


		
		public double getY() {
			return y;
		}


		public void setY(double y) {
			this.y = y;
		}


		
		
		
		public abstract double area();
		
		
		public abstract double perimetro();
		
		
		public static Punto getCentroMasa(Figura... figurita) {
			//crear Punto y variables
//			Punto centroMasas = new Punto (0,0);
			double cMasaX = 0;
			double cMasaY = 0;
			double sumatorioAreas = 0;
			
			//bucle
			for  (int i = 0; i <  figurita.length; i++) { 
				cMasaX += figurita[i].getX() * figurita[i].area();
				cMasaY += figurita[i].getY() * figurita[i].area();
				sumatorioAreas += figurita[i].area();
			}
			//definicion de objeto punto
//			centroMasas.setX(cMasaX/ sumatorioAreas);
//			centroMasas.setY( cMasaY/sumatorioAreas);
//			return centroMasas;	
			return new Punto (cMasaX/sumatorioAreas, cMasaY/sumatorioAreas);
		}

			
		
		public static double redondeo(double numero) {
			double redondeado = Math.round(numero * 100.0) / 100.0;
			return redondeado;
		}
		
		
		public boolean equals (Object otro) {
			if(otro == null)return false;
			if(otro == otro)return true;
			if (otro.getClass() != otro.getClass()) return false;
			Figura otra = (Figura) otro;
			return this.x == otra.x && this.y == otra.y;
		}


		@Override
		public String toString() {
			return "Figura [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	

