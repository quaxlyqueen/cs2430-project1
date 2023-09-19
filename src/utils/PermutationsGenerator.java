package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides functionality to generate all permutations of n integers in lexicographic (dictionary) order.
 * The integers in each permutation range from 0 to n-1.
 *
 * @author Sean White
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>
 * {@code
 *   PermutationsGenerator generator = new PermutationsGenerator();
 *   int[][] permutationsFor3 = generator.generate(3);
 *   for (int[] permutation : permutationsFor3) {
 *       System.out.println(Arrays.toString(permutation));
 *   }
 * }
 * </pre>
 *
 * The above code will generate and print all permutations for n=3 in lexicographic order:
 * <pre>
 * [0, 1, 2]
 * [0, 2, 1]
 * [1, 0, 2]
 * [1, 2, 0]
 * [2, 0, 1]
 * [2, 1, 0]
 * </pre>
 */
public class PermutationsGenerator {

    /**
     * Generates all permutations of n integers in lexicographic order.
     *
     * @param n The number of integers in each permutation.
     * @return A 2D array where each row represents a permutation.
     */
    public static int[][] generate(int n) {
        List<int[]> results = new ArrayList<>();

        // Initialize with the smallest permutation (i.e., [0, 1, 2, ..., n-1])
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = i;
        }
        results.add(current.clone());

        while (true) {
            // Identify the rightmost pair (i, i+1) where current[i] < current[i+1]
            int i;
            for (i = n - 2; i >= 0; i--) {
                if (current[i] < current[i + 1]) {
                    break;
                }
            }
            // If no such pair exists, we have generated all permutations
            if (i == -1) {
                break;
            }

            // Identify the largest index j > i such that current[i] < current[j]
            int j;
            for (j = n - 1; j > i; j--) {
                if (current[i] < current[j]) {
                    break;
                }
            }

            // Swap elements at indices i and j
            int temp = current[i];
            current[i] = current[j];
            current[j] = temp;

            // Reverse the elements after index i to get the next permutation in lexicographic order
            int start = i + 1, end = n - 1;
            while (start < end) {
                temp = current[start];
                current[start] = current[end];
                current[end] = temp;
                start++;
                end--;
            }

            // Store the new permutation
            results.add(current.clone());
        }

        // Convert the list of permutations to a 2D array for the final result
        return results.toArray(new int[0][0]);
    }
}
