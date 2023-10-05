package ejemplos;

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
		for (Punto2D p : ls) {
			Cuadrante key = p.cuadrante();
			if(!res.containsKey(key)) {
				res.put(key, 0.0);
			}
			res.put(key, res.get(key) + p.x());
		}
		return res;
	}
}
