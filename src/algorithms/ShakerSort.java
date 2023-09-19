package algorithms;

public class ShakerSort {
    /**
     * @param int[] arr, an array containing a permutation.
     * @return the number of comparisons
     */
   public static void shakerSort(int[] array) {
   	for (int i = 0; i < array.length / 2; i++) {
		boolean swapped = false;
		for (int j = i; j < array.length - i - 1; j++) {
			if (array[j] > array[j + 1]) {
				int tmp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = tmp;
				swapped = true;
			}
		}
		for (int j = array.length - 2 - i; j > i; j--) {
			if (array[j] < array[j - 1]) {
				int tmp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = tmp;
				swapped = true;
			}
		}
		if (!swapped)
			break;
        }
    }

}
