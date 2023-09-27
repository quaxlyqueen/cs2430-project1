package src.algorithms;

/**
 * The `HeapSort` class provides an implementation of the heapsort algorithm.
 * Heapsort is a comparison-based sorting algorithm that builds a binary heap
 * and then repeatedly extracts the maximum element from the heap to build the
 * sorted array.
 *
 * @author Sean White
 *
 *<p>
 * Usage example:
 *<p>
 *     HeapSort sorter = new HeapSort();
 *     int[] arr = {4, 10, 3, 5, 1};
 *     sorter.sort(arr);
 *     int comparisons = sorter.getComparisonCount();
 */
public class HeapSort {

    private int comparisons = 0;

    /**
     * Sorts an array of integers in ascending order using the HeapSort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public void sort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            comparisons++;
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            comparisons++;
            // Swap current root with end
            swap(arr, 0, i);
            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Performs the heapify operation on a subtree rooted at a specified index.
     *
     * @param arr The array in which the heapify operation is performed.
     * @param n   The size of the heap/subtree.
     * @param i   The index at which the heapify operation starts.
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child exists and is greater than the root
        if (left < n) {
            comparisons++;  // Incrementing the counter for comparison with largest
            if (arr[left] > arr[largest]) {
                comparisons++;
                largest = left;
            }
        }

        // Check if right child exists and is greater than the largest value determined so far
        if (right < n) {
            comparisons++;  // Incrementing the counter for comparison with largest
            if (arr[right] > arr[largest]) {
                comparisons++;
                largest = right;
            }
        }

        // If the largest is not root
        if (largest != i) {
            comparisons++;
            swap(arr, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param arr The array in which elements are swapped.
     * @param i   The index of the first element to be swapped.
     * @param j   The index of the second element to be swapped.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
