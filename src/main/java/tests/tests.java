package tests;

import java.util.ArrayList;
import java.util.List;

import ejemplos.Ejemplo1;
import ejemplos.Ejemplo2;
import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;

public class tests {
	public static void test1() {
		List<Punto2D> ls = new ArrayList<>();
		for(String linea: Files2.linesFromFile("data/Ejemplo1DatosEntrada.txt")) {
			String[] partes = linea.split(",");
			Punto2D p = Punto2D.of(Double.valueOf(partes[0]),
					Double.valueOf(partes[1]));
			ls.add(p);
		}
		System.out.println("==== EJEMPLO 1 ====");
		System.out.println("Iterativo: " + Ejemplo1.ejemplo1Iter(ls));
		System.out.println("Recursivo: " + Ejemplo1.ejemplo1Rec(ls));
	}
	
	public static void test2() {
		System.out.println("==== EJEMPLO 2 ====");
		for(String linea: Files2.linesFromFile("data/Ejemplo2DatosEntrada.txt")) {
			String[] partes = linea.split(",");
			Integer a = Integer.valueOf(partes[0]);
			Integer b = Integer.valueOf(partes[1]);
			System.out.println("Recursivo no final: " + Ejemplo2.ejemplo2RecNF(a, b));
			System.out.println("Recursivo final: " + Ejemplo2.ejemplo2RecF(a, b));
			
		}
	}
	
	public static void main(String[] args) {
		//test1();
		test2();
	}
	
}
