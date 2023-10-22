package adda.ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import adda.util.TuplaEjercicio2;

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
	    if (a < 2 || b < 2) {
	        ls.add(a * b);
	    } else if (a > b) {
	        ls.addAll(ejercicio2RecFAux(a % b, b - 1, new ArrayList<>()));
	        ls.add(a);
	    } else {
	        ls.addAll(ejercicio2RecFAux(a - 2, b / 2, new ArrayList<>()));
	        ls.add(b);
	    }
	    return ls;
	}
	
	public static List<Integer> ejercicio2Iter(Integer a, Integer b) {
	    List<Integer> ls = new ArrayList<>();
	    while (a >= 2 && b >= 2) {
	        if (a > b) {
	            ls.add(a);
	            a %= b;
	            b--;
	        } else {
	            ls.add(b);
	            b /= 2;
	            a -= 2;
	        }
	    }
	    ls.add(a * b);
	    Collections.reverse(ls);
	    return ls;
	}
	
	public static List<Integer> ejercicio2Func(Integer a, Integer b) {
		UnaryOperator<TuplaEjercicio2> next = x -> {
			if(x.a() < 2 || x.b() < 2) {
				x.ac().add(x.a()*x.b());
				return TuplaEjercicio2.of(0, 0, x.ac());
			} else if (x.a() > x.b()) {
                x.ac().add(x.a());
                return TuplaEjercicio2.of(x.a() % x.b(), x.b() - 1, x.ac());
            } else {
                x.ac().add(x.b());
                return TuplaEjercicio2.of(x.a() - 2, x.b() / 2, x.ac());
            }
        };
        List<Integer> res = Stream.iterate(
				TuplaEjercicio2.of(a, b, new ArrayList<Integer>()),
				x -> x.hasNext(),
				x -> next.apply(x)).toList().get(0).ac();
        Collections.sort(res);
        return res;		
	}

}
