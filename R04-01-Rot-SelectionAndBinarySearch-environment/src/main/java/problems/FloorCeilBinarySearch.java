package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		return floor(array, x, 0, array.length-1);
	}

	private int floor(Integer[] arr, int n, int left, int right) {
		int result = -1;
		int middle = (left+right) / 2;

		if (left < right) {
			if (n == arr[middle]) {
				result = arr[middle];
			} else if (n > arr[middle]) {
				result = floor(arr, n, middle+1, right);
			} else {
				result = floor(arr, n, left, middle-1);
			}

		} else if (left <= right) {
			if (n >= arr[middle]) {
				result = arr[middle];
			} else {
				result = arr[middle-1];
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		return ceil(array, x, 0, array.length-1);
	}

	private int ceil(Integer[] arr, int n, int left, int right) {
		int result = -1;
		int middleIndex = (left+right) / 2;

		if (left < right) {
			if (n == arr[middleIndex]) {
				result = arr[middleIndex];
			} else if (n > arr[middleIndex]) {
				result = ceil(arr, n, middleIndex+1, right);
			} else {
				result = ceil(arr, n, left, middleIndex-1);
			}

		} else if (left >= right) {
			if (n <= arr[middleIndex]) {
				result = arr[middleIndex];
			} else if (middleIndex+1 < arr.length) {
				result = arr[middleIndex+1];
			}
		}
		return result;
	}
}
