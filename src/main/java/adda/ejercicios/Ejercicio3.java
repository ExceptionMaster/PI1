package adda.ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}
