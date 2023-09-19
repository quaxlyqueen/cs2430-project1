package utils;

/**
 * Represents the result of sorting a permutation using an algorithm.
 * This class encapsulates the original permutation (before sorting),
 * the sorted permutation, and the number of comparisons made during sorting.
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>
 * {@code
 *   int[] original = {3, 1, 2};
 *   int[] sorted = {1, 2, 3};
 *   int comparisons = 2; // Typically obtained from the sorting algorithm
 *
 *   Result result = new Result(original, sorted, comparisons);
 *   System.out.println("Original Array: " + Arrays.toString(result.getOriginalArray()));
 *   System.out.println("Sorted Array: " + Arrays.toString(result.getSortedArray()));
 *   System.out.println("Comparisons Made: " + result.getComparisons());
 * }
 * </pre>
 * <p>
 * The above code will create a Result object and print:
 * <pre>
 * Original Array: [3, 1, 2]
 * Sorted Array: [1, 2, 3]
 * Comparisons Made: 2
 * </pre>
 *
 * @param originalArray The original permutation before sorting
 * @param sortedArray   The permutation after sorting
 * @param comparisons   The number of comparisons made during sorting
 * @author Sean White
 */

public record Result(int[] originalArray, int[] sortedArray, int comparisons) {

    /**
     * Constructs an immutable Result object with the provided parameters.
     *
     * @param originalArray The original permutation before sorting
     * @param sortedArray   The permutation after sorting
     * @param comparisons   The number of comparisons made during sorting
     */
    public Result(int[] originalArray, int[] sortedArray, int comparisons) {
        this.originalArray = originalArray.clone(); // Create a defensive copy
        this.sortedArray = sortedArray.clone();     // Create a defensive copy
        this.comparisons = comparisons;
    }

    /**
     * Retrieves the original permutation before sorting.
     *
     * @return The original permutation
     */
    @Override
    public int[] originalArray() {
        return originalArray.clone(); // Return a defensive copy
    }

    /**
     * Retrieves the permutation after sorting.
     *
     * @return The sorted permutation
     */
    @Override
    public int[] sortedArray() {
        return sortedArray.clone(); // Return a defensive copy
    }

    /**
     * Retrieves the number of comparisons made during sorting.
     *
     * @return The number of comparisons
     */
    @Override
    public int comparisons() {
        return comparisons;
    }
}
