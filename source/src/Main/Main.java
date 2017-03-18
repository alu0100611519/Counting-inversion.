/**
 * 
 * Esta es la clase main que utiliza las otras dos para hacer pruebas
 * 
 * Suponemos que queremos ordenar el array de menor a mayor.
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package Main;

import CountInversion.*;
import java.util.*;

public class Main {
	public static void main(String args[]){
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		for(String s : args){
			numeros.add(Integer.parseInt(s));
		}
		BruteForceCI brute = new BruteForceCI(numeros);
		DDCountInversion dd = new DDCountInversion(numeros);
		
		long startTimeB = System.nanoTime();
		int bcount = brute.countInversion();
		long endTimeB = System.nanoTime();
		long startTimeDD = System.nanoTime();
		int ddcount = dd.countInversion();
		long endTimeDD = System.nanoTime();
		
		System.out.println("Para " + numeros.size() + " elementos: ");
		System.out.println("El algoritmo divdie and conquer ha contado " + ddcount+ " inversiones en " +(endTimeDD-startTimeDD)+" nanosegundos.");
		System.out.println("El algoritmo por fuerza bruta ha contado " + bcount+ " inversiones en " +(endTimeB-startTimeB)+" nanosegundos.");
	}
}
