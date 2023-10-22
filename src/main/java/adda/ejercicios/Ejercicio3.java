package adda.ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import adda.util.TuplaEjercicio3;
import us.lsi.streams.Stream2;

public class Ejercicio3 {
	public static List<String> ejercicio3Iter(String fichA, String fichB) {
		List<String> ac = new ArrayList<>();
		Iterator<String> iterA = Stream2.file(fichA).iterator();
		Iterator<String> iterB = Stream2.file(fichB).iterator();
		while(iterA.hasNext() || iterB.hasNext()) {
			if(iterA.hasNext()) {
				ac.add(iterA.next());
				if(iterA.hasNext()) {
					ac.add(iterA.next());
				}
			}
			if(iterB.hasNext()) {
				ac.add(iterB.next());
				if(iterB.hasNext()) {
					ac.add(iterB.next());
				}
			}
		}
		return ac;
	}
	
	public static List<String> ejercicio3RecF(String fichA, String fichB) {
		List<String> ac = new ArrayList<>();
		Iterator<String> iterA = Stream2.file(fichA).iterator();
		Iterator<String> iterB = Stream2.file(fichB).iterator();
		return ejercicio3RecFAux(fichA, fichB, iterA, iterB, ac);
	}
	
	public static List<String> ejercicio3RecFAux(String fichA, String fichB, 
			Iterator<String> iterA, Iterator<String> iterB, List<String> ac) {
		List<String> res = new ArrayList<>();
		if(iterA.hasNext() || iterB.hasNext()) {
			if(iterA.hasNext()) {
				ac.add(iterA.next());
				if(iterA.hasNext()) {
					ac.add(iterA.next());
				}
			}
			if(iterB.hasNext()) {
				ac.add(iterB.next());
				if(iterB.hasNext()) {
					ac.add(iterB.next());
				}
			}
			res = ejercicio3RecFAux(fichA, fichB, iterA, iterB, ac);
		} else {
			res = ac;
		}
		return res;
	}
	
	public static List<String> ejercicio3Func(String fichA, String fichB) {
		return Stream.iterate(TuplaEjercicio3.of(
					Stream2.file(fichA).iterator(), 
					Stream2.file(fichB).iterator(), 
					new ArrayList<>()),
				x -> x.next())
				.filter(x -> !x.hasNext())
				.findFirst()
				.get()
				.ac();
	}
}
