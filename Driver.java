import java.util.Random;

/**
 * Compares Merge, Quick, Shaker, and Heap sorting algorithms based upon
 *      the number of comparisons each algorithm completes. This is completed
 *      by generating and sorting every permutation of numbers from 
 *      0 (inclusive) to n (exclusive).
 *
 * @author Josh Ashton, Lexus Lindeman, Sean, Abbas, ...
 */
public class Driver {

	private static int quickSortCounter = 0;
	
    /**
     * Tests the sorting algorithms where n = 4, n = 6, n = 8. n is used 
     * to call generatePermutations().
     *
     * For each sorting algorithm, store the number of comparisons for each permutation.
     * Print the following for each sort algorithm:
     *      - number of comparisons for the best 10 cases (and the permutations of those cases)
     *      - number of comparisons for the worst 10 cases (and the permutations of those cases)
     *      - average number of comparisons for all permutations of each n
     */
    public static void main(String[] args) {
        // TODO: @quagmire
    }

    /**
     * For an input n, generate an array of arrays. The sub-arrays contain each permutation.
     *      Call eg:        generatePermutations(3);
     *      Return eg:      int[][] perms = { {0,1,2}, {0,2,1}, {1,0,2}, {1,2,0}, {2,0,1}, {2,1,0} };
     *
     * @param int n
     * @return every permutation of 0 ... n
     */
    public static int[][] generatePermutations(int n) {
        return null; // TODO: @quaxlyqueen
    }

    /**
     * @param int[] arr, an array containing a permutation.
     * @return the number of comparisons
     */ 
    public static int mergeSort(int[] arr) {
        return -1; // TODO: @
    }

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

    /**
     * @param int[] arr, an array containing a permutation.
     * @return the number of comparisons
     */
    public static int shakerSort(int[] arr) {
        return -1; // TODO: @Lexus :3
    }

    /**
     * @param int[] arr, an array containing a permutation.
     * @return the number of comparisons
     */
    public static int heapSort(int[] arr) {
        return -1; // TODO: @sean_of_c_137
    }
}
