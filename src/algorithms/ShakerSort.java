package src.algorithms;

public class ShakerSort {
    private int comparisons = 0;

    /**
     * @param int[] arr, an array containing a permutation.
     * @return the number of comparisons
     */
   public void sort(int[] array) {
   	for (int i = 0; i < array.length / 2; i++) {
        comparisons++;
		boolean swapped = false;
		for (int j = i; j < array.length - i - 1; j++) {
            comparisons++;
			if (array[j] > array[j + 1]) {
                comparisons++;
				int tmp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = tmp;
				swapped = true;
			}
		}
		for (int j = array.length - 2 - i; j > i; j--) {
            comparisons++;
			if (array[j] < array[j - 1]) {
                comparisons++;
				int tmp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = tmp;
				swapped = true;
			}
		}
		if (!swapped)
            comparisons++;
			break;
        }
    }

    /**
     * Retrieves the count of comparisons made during the sorting process.
     *
     * @return The number of comparisons made during sorting.
     */
    public int getComparisonCount() {
        return comparisons;
    }
}
