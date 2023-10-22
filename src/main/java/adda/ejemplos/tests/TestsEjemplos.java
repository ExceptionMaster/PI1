package adda.ejemplos.tests;

import java.util.ArrayList;
import java.util.List;

import adda.ejemplos.Ejemplo1;
import adda.ejemplos.Ejemplo2;
import adda.ejemplos.Ejemplo3;
import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;

public class TestsEjemplos {
	public static void testEjemplo1() {
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
		System.out.println("\n\n");
	}
	
	public static void testEjemplo2() {
		System.out.println("==== EJEMPLO 2 ====");
		for(String linea: Files2.linesFromFile("data/Ejemplo2DatosEntrada.txt")) {
			String[] partes = linea.split(",");
			Integer a = Integer.valueOf(partes[0]);
			Integer b = Integer.valueOf(partes[1]);
			System.out.println("Recursivo no final: " + Ejemplo2.ejemplo2RecNF(a, b));
			System.out.println("Recursivo final: " + Ejemplo2.ejemplo2RecF(a, b));
			//System.out.println("Iterativo: " + Ejemplo2.ejemplo2Iter(a,b));
			System.out.println("Funcional: " + Ejemplo2.ejemplo2Fun(a, b));
			
		}
		System.out.println("\n\n");
	}
	
	public static void testEjemplo3() {
		System.out.println("==== EJEMPLO 3 ====");
		for(String linea: Files2.linesFromFile("data/Ejemplo3DatosEntrada.txt")) {
			String[] partes = linea.split(",");
			Integer a = Integer.valueOf(partes[0]);
			Integer b = Integer.valueOf(partes[1]);
			System.out.println("Recursivo sin memoria: " + Ejemplo3.ej3RecSinMem(a, b));
			System.out.println("Recursivo con memoria: " + Ejemplo3.ej3RecConMem(a, b));
		}
		System.out.println("\n\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testEjemplo1();
		testEjemplo2();
		testEjemplo3();
	}

}
