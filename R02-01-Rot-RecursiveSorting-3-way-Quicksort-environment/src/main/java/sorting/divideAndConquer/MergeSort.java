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
		if(leftIndex < rightIndex){
			int middleIndex = (leftIndex + rightIndex)/2;
			sort(array,leftIndex,middleIndex);
			sort(array,middleIndex+1,rightIndex);
			merge(array,leftIndex,middleIndex,rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {

		T[] aux = (T[]) new Comparable[array.length];
		int i = leftIndex;
		int j = middleIndex + 1;

		for (int l = 0; l < array.length; l++){
			aux[l] = array[l];
		}

		for(int k = leftIndex; k <= rightIndex; k++){

			if(i > middleIndex){
				array[k] = aux[j];
				j++;
			}else if(j > rightIndex){
				array[k] = aux[i];
				i++;
			}else if(aux[j].compareTo(aux[i]) > 0){
				array[k] = aux[i];
				i++;
			}else {
				array[k] = aux[j];
				j++;
			}
		}
	}
}
