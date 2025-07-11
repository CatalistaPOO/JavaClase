package strings;

public class StringVsBuilder {
	
	public static void main (String[]args) {

	String s = "";
	StringBuilder sb = new StringBuilder();
	
	long t0, tf;
	// con String la concatenación es mucho más lenta (400 mil) por su funcionamiento.
	t0 = System.currentTimeMillis();
	for (int i = 1; i <= 400_000; i++) {
		s += "a";
	}
	tf = System.currentTimeMillis();
	System.out.println("String: " + (tf -t0));
	
	//String builder con una concatenación mucho mayor es mucho más rápido (10 millones)
	t0 = System.currentTimeMillis();
	for (int i = 1; i <= 10_000_000; i++) {
		sb.append ("a");
	}
	tf = System.currentTimeMillis();
	System.out.println("StringBuilder: " + (tf -t0));
	}
}