/**
 * 
 * Esta clase Cuenta las inversiones de un array de enteros utilizando la fuerza bruta.
 * 
 * Suponemos que queremos ordenar el array de menor a mayor.
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */
package CountInversion;

import java.util.*;

public class BruteForceCI {
	ArrayList<Integer> numeros;
	
	public BruteForceCI(){
		numeros = new ArrayList<Integer>();
	}
	public BruteForceCI(ArrayList<Integer> n){
		setNumeros(n);
	}
	
	//Setters y getters
	public ArrayList<Integer> getNumeros(){
		return numeros;
	}
	public void setNumeros(ArrayList<Integer> n){
		numeros = n;
	}
	public int getNumero(int index){
		return numeros.get(index);
	}
	public void setNumero(int index, int value){
		numeros.set(index, value);
	}
	public void add(int n){
		numeros.add(n);
	}
	
	/**
	 * El algoritmo por fuerza bruta es el siguiente:
	 * por cada elemento, recorre todos los elementos a su derecha y comprueba cuantos son menores que el.
	 * 
	 * @param toAnalyze
	 * @return
	 */
	public static int countInversions(ArrayList<Integer> toAnalyze){
		int inversionCount=0;
		
		for(int i =0; i < toAnalyze.size(); i++)
			for(int j =i; j < toAnalyze.size(); j++)
				if(toAnalyze.get(i) >toAnalyze.get(j))
					inversionCount++;
		
		return inversionCount;
	}
	
	//en caso de que tengamos creado un objeto BruteForceCI, podemos usar este.
	public int countInversion(){
		return countInversion(numeros);
	}
}
