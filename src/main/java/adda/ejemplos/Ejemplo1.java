package adda.ejemplos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.geometria.Cuadrante;
import us.lsi.geometria.Punto2D;

public class Ejemplo1 {
	public static Map<Cuadrante, Double> ejemplo1(List<Punto2D> ls) {
		return ls.stream().collect(
				Collectors.groupingBy(Punto2D::cuadrante, 
						Collectors.reducing(0., x -> x.x(), (x, y) -> x + y)));
	}
	
	public static Map<Cuadrante, Double> ejemplo1Iter(List<Punto2D> ls) {
		Map<Cuadrante, Double> res = new HashMap<>();
		Integer e = 0;
		while(e < ls.size()) {
			Punto2D p = ls.get(e);
			Cuadrante key = p.cuadrante();
			if(!res.containsKey(key)) {
				res.put(key, 0.0);
			}
			res.put(key, res.get(key) + p.x());
			e++;
		}
		return res;
	}
	
	public static Map<Cuadrante, Double> ejemplo1Rec(List<Punto2D> ls) {
		Map<Cuadrante, Double> res = new HashMap<>();
		Integer e = 0;
		return ejemplo1RecAux(ls, res, e);
	}
	
	public static Map<Cuadrante, Double> ejemplo1RecAux(List<Punto2D> ls, Map<Cuadrante, Double> res, Integer e) {
		if(!(e < ls.size())) {
			return res;
		} else {
			Punto2D p = ls.get(e);
			Cuadrante key = p.cuadrante();
			if(!res.containsKey(key)) {
				res.put(key, 0.0);
			}
			res.put(key, res.get(key) + p.x());
			e++;
			return ejemplo1RecAux(ls, res, e);
		}
	}
}
