package teoria;

public class tiposDeDatoCompatible {
 public static void main(String[]args) {
	 
	 byte b = 5;
	 short s = b;
	 int i = s;
	 long l = i;
	 float f =l;
	 double d = f;
	 
	 System.out.println(b);
	 System.out.println(s);
	 System.out.println(i);
	 System.out.println(l);
	 System.out.println(f);
	 System.out.println(d);
	 System.out.println("-------");
	 
	 
	 i = Integer.MAX_VALUE; //MAX_VALUE es una constante que almacena el mayor valor enetro
	 f = i;
	 d = i;
	 System.out.println(i); //redondea el decimal, pierde precision
	 System.out.println(f); //redondea el decimal, pierde precision
	 System.out.println(d);
	 System.out.println("-------");
	 
	 l= Long.MAX_VALUE;
	 f = l;
	 d = l;
	 System.out.println(l);
	 System.out.println(f);
	 System.out.println(d);		 
 }
}
