package adda.util;

import java.util.List;

public record TuplaEjercicio2(Integer a, Integer b, List<Integer> ac) {
	public static TuplaEjercicio2 of(Integer a, Integer b, List<Integer> ac) {
		return new TuplaEjercicio2(a,b,ac);
	}
	
	public boolean hasNext() {
		return a >= 2 || b >= 2;
	}
}
