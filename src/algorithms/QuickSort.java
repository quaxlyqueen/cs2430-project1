package algorithms;

public class QuickSort {

	private static int quickSortCounter = 0;

    /**
     * Public method for the user to use quick sort.
     *
     * @param int[] arr, an array containing a permutation.
     * @return sorted array
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Utility method for quickSort
     * 
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {
    	if (low < high + 1) {
    		quickSortCounter++;
    		int p = partition(arr, low, high);
    		quickSort(arr, low, p - 1); 		
    		quickSort(arr, p + 1, high); 		
    	}
    }
    
    /**
     * Swaps two indices of an array
     * 
     * @param arr
     * @param index1
     * @param index2
     */
    private static void swap(int[] arr, int index1, int index2) {
    	int temp = arr[index1];
    	arr[index1] = arr[index2];
    	arr[index2] = temp;
    }
    /**
     * Returns random pivot index between low and high.
     * 
     * @param low
     * @param high
     * @return random pivot
     */
    private static int getPivot(int low, int high) {
    	Random rand = new Random();
    	return rand.nextInt((high - low) + 1) + low;
    }
    
    /**
     * Moves all n < pivot to the left of pivot and all n > pivot
     * to the right of pivot, then returns the pivot index. 
     * 
     * @param arr
     * @param low
     * @param high
     * @return pivot index
     */
    private static int partition(int[] arr, int low, int high) {
    	swap(arr, low, getPivot(low, high));
    	int border = low + 1;
    	for (int i = border; i <= high; i++) {
    		quickSortCounter++;
    		if (arr[i] < arr[low]) {
    			quickSortCounter++;
    			swap(arr, i, border++);
    		}
    	}
    	swap(arr, low, border - 1);
    	return border - 1;
    }
}
