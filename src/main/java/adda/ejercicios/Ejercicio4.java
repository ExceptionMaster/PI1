package adda.ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Pair;

public class Ejercicio4 {
	public static String ejercicio4RecSinMem(Integer a, Integer b) {
		if(a <= 4) {
			return a+"."+b;
		} else if(b <= 4) {
			return b+"-"+a;
		} else {
			return ejercicio4RecSinMem(a/2, b-2)+","+ejercicio4RecSinMem(a-2, b/2)+","+ejercicio4RecSinMem(a-1, b-1);
		}
	}
	
	public static String ejercicio4RecConMem(Integer a, Integer b) {
		return ejercicio4RecConMemAux(a,b,new HashMap<>());
	}
	
	public static String ejercicio4RecConMemAux(Integer a, Integer b, Map<Pair<Integer,Integer>,String> map) {
		Pair<Integer,Integer> pair = Pair.of(a, b);
		String res = null;
		if(map.containsKey(pair)) {
			return map.get(pair);
		} else {
			if(a <= 4) {
				res = a+"."+b;
				map.put(pair, res);
			} else if(b <= 4) {
				res = b+"-"+a;
				map.put(pair, res);
			} else {
				res = ejercicio4RecConMemAux(a/2, b-2,map)+","+ejercicio4RecConMemAux(a-2, b/2,map)+","+ejercicio4RecConMemAux(a-1, b-1,map);
				map.put(pair, res);
			}
		}
		return res;
	}
	
	public static String ejercicio4Iter(Integer a, Integer b) {
		Map<Pair<Integer,Integer>, String> map = new HashMap<>();
		for(int i = 0; i <= a; i++) {
			for(int j = 0; j <= b; j++) {
				Pair<Integer,Integer> pair = Pair.of(i, j);
				String res = null;
				if(map.containsKey(pair)) {
					return map.get(pair);
				} 
				if(i <= 4) {
					res = i+"."+j;
					map.put(pair, res);
				} else if(j <= 4) {
					res = j+"-"+i;
					map.put(pair, res);
				} else {
					res = map.get(Pair.of(i/2, j-2))+","+map.get(Pair.of(i-2, j/2))+","+map.get(Pair.of(i-1, j-1));
					map.put(pair, res);
				}
			}
		}
		return map.get(Pair.of(a, b));
	}
}
