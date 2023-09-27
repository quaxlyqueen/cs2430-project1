package src.algorithms;

public class MergeSort {

    private int comparisons = 0;

    public void sort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

	private void sort(int arr[], int l, int r) {
        if (l < r) {
            comparisons++;
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
	
	 private void merge(int arr[], int l, int m, int r) {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        // Create temp arrays
	        int L[] = new int[n1];
	        int R[] = new int[n2];
	 
	        // Copy data to temp arrays
	        for (int i = 0; i < n1; ++i) {
                comparisons++;
	            L[i] = arr[l + i];
            }
	        for (int j = 0; j < n2; ++j) {
                comparisons++;
	            R[j] = arr[m + 1 + j];
            }
	 
	        // Merge the temp arrays
	 
	        // Initial indices of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarray array
	        int k = l;
	        while (i < n1 && j < n2) {
	            if (L[i] <= R[j]) {
                    comparisons++;
	                arr[k] = L[i];
	                i++;
	            }
	            else {
                    comparisons++;
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        // Copy remaining elements of L[] if any
	        while (i < n1) {
                comparisons++;
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        // Copy remaining elements of R[] if any
	        while (j < n2) {
                comparisons++;
	            arr[k] = R[j];
	            j++;
	            k++;
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
