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
	
	/**
	 * Constructor base y apartir de un array.
	 */
	public DDCountInversion(){
		numeros = new ArrayList<Integer>();
	}
	public DDCountInversion(ArrayList<Integer> n){
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
	public int getInversiones(){
		return inversiones;
	}
	public void setInversiones(int n){
		inversiones = n;
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
		
		/**
		 * Caso base en el que solo hay un elemento
		 */
		if(izquierda == derecha){
			result.add(lista.get(izquierda));
			return result;
		}
		
		/**
		 * Dividimos
		 */
		int mid = (izquierda + derecha)/2;
		ArrayList<Integer> izquierdaList =countStep(lista, izquierda, mid);
		ArrayList<Integer> derechaList =countStep(lista, mid+1, derecha);
		
		/**
		 * hacemos el merge y utilizamos los iteradores para movernos dentro del array
		 */
		int i = 0, j =0;
		while((i <izquierdaList.size()) && (j < derechaList.size())){
			
			/**
			 * Como lo queremos ordenar de menor a mayor, si el menor esta a la derecha esta mal colocado
			 */
			if(derechaList.get(j) < izquierdaList.get(i)){
				result.add(derechaList.get(j));
				
				/**
				 * Lo contamos de esta manera porque si el elemento j de la derecha es menor que el elemento i de la izquierda,
				 * entonces j es menor que todos los que son mayores que i en el array de la izquierda, 
				 * y hay que añadir una inversion por cada uno de ellos.
				 */
				inversiones = inversiones + (izquierdaList.size()-i);
				j++;
			}
			else{
				result.add(izquierdaList.get(i));
				i++;
			}
		}
		/**
		 * añadimos los que sobran.
		 */
		while(j<derechaList.size()){
			result.add(derechaList.get(j));
			j++;
		}
		while(i<izquierdaList.size()){
			result.add(izquierdaList.get(i));
			i++;
		}
		return result;
	}
	
	/**
	 * este es el metodo que devemos invocar tras crear la clase.
	 * @return
	 */
	public int countInversion(){
		setInversiones(0);
		numeros = countStep(numeros, 0, numeros.size()-1);
		return getInversiones();
	}
}