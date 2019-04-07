package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		Integer valorMax = this.maxValue(array,leftIndex);
		Integer valorMin = this.minValue(array,leftIndex);

		Integer[] aux = new Integer[valorMax - valorMin + 1];
		Integer[] out = new Integer[array.length];

		this.startArray(aux);

		//Soma da quantidade dos valores do array do array no indice correspondente
		for (int i = 0; i < array.length; i++) {
			int normalizar = array[i] - valorMin ;
			aux[normalizar]++;
		}

		//Soma o indice com o anterior
		for (int i = 1; i < aux.length; i++) {
			aux[i] = aux[i] + aux[i - 1];
		}

		//Insere no array auxiliar, o elemento do array na posicao que o array auxiliar indica
		for (int o = array.length-1; o >= 0; o--) {
			int index = array[o] - valorMin;
			int indexEnd = --aux[index];
			out[indexEnd] = array[o];
		}

		this.copyArray(array, out);
	}

	private void startArray(Integer[] array) {
		for (int l = 0; l < array.length; l++) {
			array[l] = 0;
		}
	}

	private Integer maxValue(Integer[] array, int leftIndex) {
		Integer max = leftIndex;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	private Integer minValue(Integer[] array, int leftIndex) {
		Integer min = leftIndex;

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	private void copyArray(Integer[] array1, Integer[] array2 ){
		for (int i = 0; i < array1.length; i++){
			array1[i] = array2[i];
		}
	}

}
