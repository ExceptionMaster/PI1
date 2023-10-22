package adda.tests;

import adda.ejercicios.Ejercicio1;
import adda.ejercicios.Ejercicio2;
import adda.ejercicios.Ejercicio3;
import us.lsi.common.Files2;

public class Tests {	
	public static void testEjercicio1 () {
		System.out.println("==== EJERCICIO 1 ====");
		StringBuilder sbFun = new StringBuilder("Funcional: \n");
		StringBuilder sbIter = new StringBuilder("Iterativo: \n");
		StringBuilder sbRecF = new StringBuilder("Recursivo Final: \n");
		for(String linea: Files2.linesFromFile("data/PI1Ej1DatosEntrada.txt")) {
			String[] partes = linea.split(",");
			Integer a = Integer.valueOf(partes[0]);
			Integer b = Integer.valueOf(partes[1]);
			sbFun.append(Ejercicio1.ej1Func(a, b));
			sbFun.append("\n");
			sbIter.append(Ejercicio1.ej1Iter(a, b));
			sbIter.append("\n");
			sbRecF.append(Ejercicio1.ej1RecF(a, b));
			sbRecF.append("\n");
		}
		System.out.println(sbFun.toString());
		System.out.println(sbIter.toString());
		System.out.println(sbRecF.toString());
		System.out.println("\n\n");
	}
	
	public static void testEjercicio2 () {
		System.out.println("==== EJERCICIO 2 ====");
		StringBuilder sbFun = new StringBuilder("Funcional: \n");
		StringBuilder sbIter = new StringBuilder("Iterativo: \n");
		StringBuilder sbRecF = new StringBuilder("Recursivo Final: \n");
		StringBuilder sbRecNF = new StringBuilder("Recursivo No Final: \n");
		
		for(String linea: Files2.linesFromFile("data/PI1Ej2DatosEntrada.txt")) {
			String[] partes = linea.split(",");
			Integer a = Integer.valueOf(partes[0]);
			Integer b = Integer.valueOf(partes[1]);
			
			sbFun.append(Ejercicio2.ejercicio2Func(a, b));
			sbFun.append("\n");
			
			sbIter.append(Ejercicio2.ejercicio2Iter(a, b));
			sbIter.append("\n");
			
			sbRecF.append(Ejercicio2.ejercicio2RecF(a, b));
			sbRecF.append("\n");
			
			sbRecNF.append(Ejercicio2.ejercicio2RecNF(a, b));
			sbRecNF.append("\n");
		}
		
		System.out.println(sbFun.toString());
		System.out.println(sbIter.toString());
		System.out.println(sbRecF.toString());
		System.out.println(sbRecNF.toString());
		System.out.println("\n\n");
	}
	
	public static void testEjercicio3 () {
		String file1A = "./data/PI1Ej3DatosEntrada1A.txt";
		String file1B = "./data/PI1Ej3DatosEntrada1B.txt";
		String file2A = "./data/PI1Ej3DatosEntrada2A.txt";
		String file2B = "./data/PI1Ej3DatosEntrada2B.txt";
		String file3A = "./data/PI1Ej3DatosEntrada3A.txt";
		String file3B = "./data/PI1Ej3DatosEntrada3B.txt";
		
		System.out.println("==== EJERCICIO 3 ====");
		System.out.println("Iterativo: ");
		System.out.println(Ejercicio3.ejercicio3Iter(file1A, file1B));
		System.out.println(Ejercicio3.ejercicio3Iter(file2A, file2B));
		System.out.println(Ejercicio3.ejercicio3Iter(file3A, file3B));
		System.out.println("\n");
		System.out.println("Recursivo Final: ");
		System.out.println(Ejercicio3.ejercicio3RecF(file1A, file1B));
		System.out.println(Ejercicio3.ejercicio3RecF(file2A, file2B));
		System.out.println(Ejercicio3.ejercicio3RecF(file3A, file3B));
		System.out.println("\n");
		System.out.println("Funcional: ");
		System.out.println(Ejercicio3.ejercicio3Func(file1A, file1B));
		System.out.println(Ejercicio3.ejercicio3Func(file2A, file2B));
		System.out.println(Ejercicio3.ejercicio3Func(file3A, file3B));
	}
	
	public static void main(String[] args) {
		testEjercicio1();
		testEjercicio2();
		testEjercicio3();
	}
	
}
