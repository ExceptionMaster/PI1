package adda.ejercicios;

import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import adda.util.EnteroCadena;

public class Ejercicio1 {
	public static String ej1Func(Integer varA, Integer varB) {
		UnaryOperator<EnteroCadena> nx = elem -> {
			return EnteroCadena.of(elem.a() + 3,
					elem.a() % 2 == 0 ? elem.a() + "*" : elem.a() + "!");
		};
				
		return Stream.iterate(EnteroCadena.of(varA, "A"), elem -> elem.a() < varB, nx)
				.filter(elem -> elem.a() % 10 != 0)
				.map(elem -> elem.s())
				.collect(Collectors.joining("-"));
	}
	
	public static String ej1Iter(Integer varA, Integer varB) {
		EnteroCadena seed = EnteroCadena.of(varA, "A");
		StringBuilder res = new StringBuilder();
		int ac = varA;
		res.append(seed.s());
		while(ac < varB) {
			EnteroCadena ec = EnteroCadena.of(ac+3, ac % 2 == 0 ? ac + "*" : ac + "!");
			if(ec.a() % 10 != 0 && ec.a() < varB) {
				res.append("-").append(ec.s());
			}
			ac+=3;
		}
	    return res.toString();
	}
	
	public static String ej1RecF(Integer varA, Integer varB) {
		EnteroCadena seed = EnteroCadena.of(varA, "A");
		StringBuilder res = new StringBuilder();
		int ac = varA;
		res.append(seed.s());
		return ej1RecFAux(varA, varB, res, ac);
	}
	
	public static String ej1RecFAux(Integer varA, Integer varB, StringBuilder res, Integer ac) {
		if(ac < varB) {
			EnteroCadena ec = EnteroCadena.of(ac+3, ac % 2 == 0 ? ac + "*" : ac + "!");
			if(ec.a() % 10 != 0 && ec.a() < varB) {
				res.append("-").append(ec.s());
			}
			ac+=3;
			return ej1RecFAux(varA, varB, res, ac);
		} else {
			return res.toString();
		}
	}
}