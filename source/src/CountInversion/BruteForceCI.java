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
	
	/**
	 * Constructor por defecto y a partir de un array.
	 */
	public BruteForceCI(){
		numeros = new ArrayList<Integer>();
	}
	public BruteForceCI(ArrayList<Integer> n){
		setNumeros(n);
	}
	
	/**
	 * Setters y getters
	 */
	public ArrayList<Integer> getNumeros(){
		return numeros;
	}
	public void setNumeros(ArrayList<Integer> n){
		numeros = n;
	}
	/**
	 * Setter y getter para numeros individuales del array.
	 */
	public int getNumero(int index){
		return numeros.get(index);
	}
	public void setNumero(int index, int value){
		numeros.set(index, value);
	}
	/**
	 * Metodo para añadir un numero al array
	 * @param n
	 */
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
	public static int countInversion(ArrayList<Integer> toAnalyze){
		int inversionCount=0;
		
		for(int i =0; i < toAnalyze.size(); i++)
			for(int j =i; j < toAnalyze.size(); j++)
				if(toAnalyze.get(i) >toAnalyze.get(j))
					inversionCount++;
		
		return inversionCount;
	}
	
	/**
	 * Este es el metodo que utilizamos una vez tenemos creado un objeto
	 * @return
	 */
	public int countInversion(){
		return countInversion(numeros);
	}
}
