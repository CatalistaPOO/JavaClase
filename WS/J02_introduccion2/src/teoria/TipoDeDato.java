package teoria;

public class TipoDeDato {
	byte b = 7;
	//byte b1 = 200; //dará error;
	
	double  d= 1.5; //8 bytes
	
	//float f = 0.1; //dará error porque ocupa más de lo que abarca un float (float son 4 bytes)
	float f = 0.1F;//los prefijos (este caso F)permiten convertir ese dato

	//int numGrande = 2_200_000_000; //error , supera el rango int
	long l = 2_200_000_000L;//prefijjo L permite convierte el dato, solucionando el error

}
