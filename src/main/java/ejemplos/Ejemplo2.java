package ejemplos;

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
}
