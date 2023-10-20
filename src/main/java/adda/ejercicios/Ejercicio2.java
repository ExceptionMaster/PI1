package adda.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
	public static List<Integer> ejercicio2RecNF(Integer a, Integer b) {
		List<Integer> ls = new ArrayList<>();
		if(a < 2 || b < 2) {
			return List.of(a*b);
		} else if(a > b) {
			ls.addAll(ejercicio2RecNF(a%b, b-1));
			ls.add(a);
		} else {
			ls.addAll(ejercicio2RecNF(a-2, b/2));
			ls.add(b);
		}
		return ls;
	}
	
	public static List<Integer> ejercicio2RecF(Integer a, Integer b) {
		List<Integer> ls = new ArrayList<>();
		return ejercicio2RecFAux(a, b, ls);
	}
	
	public static List<Integer> ejercicio2RecFAux(Integer a, Integer b, List<Integer> ls) {
		if(a < 2 || b < 2) {
			return List.of(a*b);
		} else if(a > b) {
			ls.addAll(ejercicio2RecNF(a%b, b-1));
			ls.add(a);
		} else {
			ls.addAll(ejercicio2RecNF(a-2, b/2));
			ls.add(b);
		}
		return ls;
	}
	
	public static List<Integer> ejercicio2Iter(Integer a, Integer b) {
	    
	}

}
