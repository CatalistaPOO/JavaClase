package com.cursogetafe.jpa.ejemplo06herenciajoined;

import java.io.Serializable;
import java.util.Objects;

public abstract class Figura implements Serializable {
	
		//en esta clase no se ha definido un constructor, Java generará un constructor automáticamente.
	
		private int idFigura;
		private double x;
		private double y;
		
		public Figura() {
		
		}
		
		public Figura(double x,double y) {
			this.x = x;
			this.y = y;
		}
		
		public int getIdFigura() {
			return idFigura;
		}

		public void setIdFigura(int idFigura) {
			this.idFigura = idFigura;
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

			
		
		public static double redondeo(double numero) {
			double redondeado = Math.round(numero * 100.0) / 100.0;
			return redondeado;
		}

		@Override
		public int hashCode() {
			return Objects.hash(idFigura);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Figura other = (Figura) obj;
			return idFigura == other.idFigura;
		}

		@Override
		public String toString() {
			return "Figura [idFigura=" + idFigura + ", x=" + x + ", y=" + y + "]";
		}
		
		
	}
