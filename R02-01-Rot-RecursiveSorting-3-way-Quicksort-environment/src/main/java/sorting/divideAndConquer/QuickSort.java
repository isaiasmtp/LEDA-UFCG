package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex){

			int pivot = particion(array,leftIndex,rightIndex);
			sort(array,leftIndex,pivot-1);
			sort(array,pivot+1,rightIndex);
		}
	}

	private int particion(T[] array, int leftIndex, int rightIndex) {

	T pivot = array[rightIndex];
	int i = leftIndex - 1;

	for(int j = leftIndex; j < rightIndex; j++){
		if(array[j].compareTo(pivot) <= 0){
			i++;
			util.Util.swap(array,i,j);
		}
	}

	util.Util.swap(array,i+1, rightIndex);
	return (i+1);
	}
}

