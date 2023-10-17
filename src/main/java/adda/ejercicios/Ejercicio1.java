package adda.ejercicios;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import adda.util.EnteroCadena;

public class Ejercicio1 {
	public static String ejercicio1(Integer varA, Integer varB) {
		UnaryOperator<EnteroCadena> nx = elem -> {
			return EnteroCadena.of(elem.a() + 3,
					elem.a() % 2 == 0 ? elem.a() + "*" : elem.a() + "!");
		};
		return Stream.iterate(EnteroCadena.of(varA, "A"), elem -> elem.a() < varB, nx)
				.filter(elem -> elem.a() % 10 != 0)
				.map(elem -> elem.s())
				.collect(Collectors.joining("-"));
	}
	
	public static String ejercicio1Iter(Integer varA, Integer varB) {
		StringBuilder res = new StringBuilder();
		EnteroCadena ec = EnteroCadena.of(varA, "A");
		int a = ec.a();
		res.append(ec.s());
		while (a < varB) {
			if(a % 10 != 0) {
				if(a % 2 == 0) {
					res.append("-");
					res.append(a + "*");
				} else {
					res.append("-");
					res.append(a + "!");
				}
			}
			a+=3;
	    }
	    return res.toString();
	}
}