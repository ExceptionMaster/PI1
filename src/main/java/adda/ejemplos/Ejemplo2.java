package adda.ejemplos;

import java.util.stream.Stream;

public class Ejemplo2 {
	public static String ejemplo2RecNF(Integer a, Integer b) {
		if(a < 5 || b < 5) {
			return "(" + (a*b) + ")";
		} else {
			return (a+b) + ejemplo2RecNF(a/2, b-2);
		}
	}
	
	public static String ejemplo2RecF(Integer a, Integer b) {
		return ejemplo2RecFAux(a, b, "");
	}
	
	public static String ejemplo2RecFAux(Integer a, Integer b, String ac) {
		if(a < 5 || b < 5) {
			return ac + "(" + (a*b) + ")";
		} else {
			ac += (a+b);
			return ejemplo2RecFAux(a/2, b-2, ac);
		}
	}
	
	public record TuplaEj2(Integer a, Integer b, String ac) {
		public static TuplaEj2 of(Integer a, Integer b) {
			return new TuplaEj2(a,b,"");
		}
		
		public Boolean hasNext() {
			return !(a < 5 || b < 5);
		}
		
		public TuplaEj2 next() {
			String newAc = ac;
			Integer newA = a;
			Integer newB = b;
			
			newAc = newAc + (newA+newB);
			newA = newA/2;
			newB = newB-2;
			
			return new TuplaEj2(newA,newB,newAc);
		}
		
		public String result() {
			return ac + "(" + (a*b) + ")";
		}
	}
	
	public static String Ej2Fun(Integer a, Integer b) {
		return Stream.iterate(TuplaEj2.of(a, b), x -> x.next())
				.filter(x -> !x.hasNext())
				.findFirst()
				.get()
				.result();
	}
}

