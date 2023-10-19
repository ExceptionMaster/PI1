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
		EnteroCadena seed = EnteroCadena.of(varA, "A");
		StringBuilder res = new StringBuilder();
		int a = varA;
		res.append(seed.s());
		while(a < varB) {
			EnteroCadena ec = EnteroCadena.of(a+3, a % 2 == 0 ? a + "*" : a + "!");
			if(ec.a() % 10 != 0 && ec.a() < varB) {
				res.append("-").append(ec.s());
			}
			a+=3;
		}
	    return res.toString();
	}
}