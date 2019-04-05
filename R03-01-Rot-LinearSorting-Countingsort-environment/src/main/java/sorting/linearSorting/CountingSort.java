package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratÃ©gia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o mÃ¡ximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      Integer valorMax = this.maxValue(array, leftIndex);
      Integer[] aux = new Integer[valorMax + 1];
      Integer[] out = new Integer[array.length];

      this.startArray(aux);

      //Soma da quantidade dos valores do array do array no indice correspondente
      for (int i = 0; i < array.length; i++) {
         aux[array[i]]++;
      }

      //Soma o indice com o anterior
      for (int i = 1; i < aux.length; i++) {
         aux[i] = aux[i] + aux[i - 1];
      }

      //Insere no array auxiliar, o elemento do array na posicao que o array auxiliar indica
      for (int i = 0; i < array.length; i++) {
         out[aux[array[i]] - 1] = array[i];
         aux[array[i]]--;
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

   private void copyArray(Integer[] array1, Integer[] array2) {
      for (int i = 0; i < array1.length; i++) {
         array1[i] = array2[i];
      }
   }
}
