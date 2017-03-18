/**
 * 
 * Esta clase Cuenta las inversiones de un array de enteros utilizando un algoritmo divide y vencerás.
 * 
 * Suponemos que queremos ordenar el array de menor a mayor.
 * 
 * @author alu0100888102
 * @version 1.0
 * Ángel Hamilton Lopez
 * alu0100888102@ull.es
 */

package CountInversion;

import java.util.ArrayList;

public class DDCountInversion {
	ArrayList<Integer> numeros;
	int inversiones;
	
	public DDCountInversion(){
		numeros = new ArrayList<Integer>();
	}
	public DDCountInversion(ArrayList<Integer> n){
		setNumeros(n);
	}
	
	
	/**
	 * Funcion que devuelve el arraylist con todos los numeros.
	 * @return
	 */
	
	public ArrayList<Integer> getNumeros(){
		return numeros;
	}
	
	/**
	 * Funcion que permiite cambiar el tamaño del arraylist
	 * @param n
	 */
	
	public void setNumeros(ArrayList<Integer> n){
		numeros = n;
	}
	
	/**
	 * Algoritmo que devuelve un numero del array list dependiendo del indice 
	 * @param index variable que indica la celda que devuelve el numero
	 * @return
	 */
	
	public int getNumero(int index){
		return numeros.get(index);
	}
	
	/**
	 * Algoritmo para cambiar la celda dependiendo del indice
	 * @param index variable que indica el numero 
	 * @param value
	 */
	
	public void setNumero(int index, int value){
		numeros.set(index, value);
	}
	
	/**
	 * añadir un numero al final de la lista
	 * @param n
	 */
	
	public void add(int n){
		numeros.add(n);
	}
	
	/**
	 * Funcion que devuele la cantidad de inversiones 
	 * @return
	 */
	public int getInversiones(){
		return inversiones;
	}
	
	/**
	 * Funcion setter que modifica el valor de inversiones
	 * @param n
	 */
	public void setInversiones(int n){
		inversiones = n;
	}
	
	/**
	 * El algoritmo divide y venceras es una variante del mergesort en la que contamos mientras ordenamos.
	 * 
	 * Dividimos el array en dos subarrays recursivamente.
	 * Cuando llegamos al tamaño minimo, si hay que invertir los elementos se aumentan las inversiones.
	 * A la hora de hacer el merge, siempre que alguno del subarray derecho haya que ponerlo por delante de uno del subarray izquierdo hemos realizado una inversion.
	 * 
	 * @return
	 */
	
	
	private ArrayList<Integer> countStep(ArrayList<Integer> lista, int izquierda, int derecha){
		ArrayList<Integer> result = new  ArrayList<Integer>();
		
		//caso base en el que solo hay un elemento
		if(izquierda == derecha){
			result.add(lista.get(izquierda));
			return result;
		}
		
		//dividimos
		int mid = (izquieda + derecha)/2;
		ArrayList<Integer> izquierda =countStep(lista, izquierda, mid);
		ArrayList<Integer> derecha =countStep(lista, mid+1, derecha);
		
		//hacemos el merge
		int i = izquierda, j = mid+1;
		while((i <= mid) && (j <= derecha)){
			
			//como lo queremos ordenar de menor a mayor, si el menor esta a la derecha esta mal colocado
			if(derecha.get(j) < izquierda.get(i)){
				result.add(derecha.get(j));
				inversion++;
				j++;
			}
			else{
				result.add(izquierda.get(i));
				i++;
			}
		}
		//añadimos los que sobran si sobran por algun lado
		while(j < derecha){
			result.add(derecha.get(j));
			j++;
		}
		while(i < mid){
			result.add(izquierda.get(i));
			i++;
		}
		return result;
	}
	
	/**
	 * este es el metodo que devemos invocar tras crear la clase.
	 * 
	 * @return
	 */
	public int countInversion(){
		setInversiones(0);
		numeros = countStep(numeros, 0, numeros.size()-1);
		return getInversiones();
	}
	
	
	
	
}