package adda.ejemplos;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Pair;

public class Ejemplo3 {
	public static Integer ej3RecSinMem(Integer a, Integer b) {
		if(a < 2 || b < 2) {
			return a*a+b;
		} else {
			return ej3RecSinMem(a/2, b-1) + ej3RecSinMem(a/3, b-2);
		}
	}
	
	public static Integer ej3RecConMem(Integer a, Integer b) {
		return ej3RecConMemAux(a, b, new HashMap<>());
	}
	
	public static Integer ej3RecConMemAux(Integer a, Integer b, Map<Pair<Integer,Integer>, Integer> map) {
		Pair<Integer, Integer> entrada = Pair.of(a,b);
		Integer res = null;
		if(map.containsKey(entrada)) {
			return map.get(entrada);
		}
		if(a < 2 || b < 2) {
			res = a*a+b;
			map.put(entrada, res);
		} else {
			res = ej3RecConMemAux(a/2, b-1, map) + ej3RecConMemAux(a/3, b-2, map);
			map.put(entrada, res);
		}
		return res;
	}
	
	public static Integer ej3Iter(Integer a, Integer b) {
		Map<Pair<Integer,Integer>, Integer> map = new HashMap<>();
		for(int i = 0; i <= a; i++) {
			for(int j = 0; j <= b; j++) {
				Pair<Integer, Integer> entrada = Pair.of(i,j);
				Integer res = null;
				if(map.containsKey(entrada)) {
					return map.get(entrada);
				}
				if(i < 2 || j < 2) {
					res = i*i+j;
					map.put(entrada, res);
				} else {
					res = map.get(Pair.of(i/2, j-1)) +  map.get(Pair.of(i/3, j-2));
					map.put(entrada, res);
				}
			}
		}
		return map.get(Pair.of(a, b));
	}
	
}
