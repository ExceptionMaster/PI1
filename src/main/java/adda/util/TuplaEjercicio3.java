package adda.util;

import java.util.Iterator;
import java.util.List;

public record TuplaEjercicio3(Iterator<String> iterA, Iterator<String> iterB, List<String> ac) {
	public static TuplaEjercicio3 of(Iterator<String> iterA, Iterator<String> iterB, List<String> ac) {
		return new TuplaEjercicio3(iterA, iterB, ac);
	}
	
	public boolean hasNext() {
		return iterA.hasNext() || iterB.hasNext();
	}
	
	public TuplaEjercicio3 next() {
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
		return TuplaEjercicio3.of(iterA, iterB, ac);
	}
}
