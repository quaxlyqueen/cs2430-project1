/**
 * Compares Merge, Quick, Shaker, and Heap sorting algorithms based upon
 *      the number of comparisons each algorithm completes. This is completed
 *      by generating and sorting every permutation of numbers from 
 *      0 (inclusive) to n (exclusive).
 *
 * @author Josh Ashton, Lexus Lindeman, Sean, Abbas, ...
 */
public class CompareSortingAlgorithms {

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
     *
     * @param int[] arr, an array containing a permutation.
     * @return the number of comparisons
     */
    public static int quickSort(int[] arr) {
        return -1; // TODO: @
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
