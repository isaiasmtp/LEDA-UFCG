package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {

			int mid = (rightIndex + leftIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int mid, int rightIndex) {

		//criar um array auxiliar e copiar os valores

		T[] aux = (T[]) new Comparable[array.length];
		int i = leftIndex;
		int j = mid + 1;

		for (int l = 0; l < aux.length; l++ ){
			aux[l] = array[l];
 		}

		//inserir os elementos no array
		for (int k = leftIndex; k <= rightIndex; k++){
			if (i > mid){
				array[k] = aux[j];
				j++;
			}else if (j > rightIndex){
				array[k] = aux[i];
				i++;
			}else if(aux[i].compareTo(aux[j]) < 0){
				array[k] = aux[i];
				i++;
			}else{
				array[k] = array[j];
				j++;
			}
		}
	}
}
