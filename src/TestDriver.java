import algorithms.HeapSort;
import utils.Result;
import utils.FileOutputUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static utils.PermutationsGenerator.generate;

/**
 * Compares various sorting algorithms based upon the number of comparisons each algorithm completes.
 * Generates and sorts every permutation of numbers from 0 (inclusive) to n (exclusive).
 * Current implementation only tests the HeapSort algorithm, but it can be extended to other algorithms.
 *
 * @author Josh Ashton, Lexus Lindeman, Sean, Abbas
 */
public class TestDriver {

    /**
     * The main driver method to test the sorting algorithms.
     * Generates all possible permutations for each test size, then sorts each permutation using a new HeapSort instance.
     * After sorting, results (including the number of comparisons) are stored.
     * The results are then processed to print out the best, worst, and average cases based on the number of comparisons.
     * Results are also saved to a text file in the "results" directory.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] testSizes = {4, 6, 8};  // Sizes for which the sorting algorithms will be tested
        StringBuilder output = new StringBuilder();  // To collect the output for the file

        for (int n : testSizes) {
            int[][] permutations = generate(n);
            int totalComparisons = 0;
            List<Result> results = new ArrayList<>();

            for (int[] permutation : permutations) {
                HeapSort heapSort = new HeapSort();  // Create a new HeapSort instance for each permutation
                int[] copy = Arrays.copyOf(permutation, permutation.length);
                heapSort.sort(copy);
                int comparisons = heapSort.getComparisonCount();
                totalComparisons += comparisons;
                results.add(new Result(permutation, copy, comparisons));
            }

            results.sort(Comparator.comparingInt(Result::comparisons));

            // Append results to the output StringBuilder
            output.append("\n========================================\n");
            output.append("RESULTS FOR N = ").append(n).append("\n");
            output.append("========================================\n\n");

            output.append("Best 10 cases:\n");
            output.append("--------------------\n");
            for (int i = 0; i < 10; i++) {
                output.append("Original: ").append(Arrays.toString(results.get(i).originalArray()))
                        .append("\nSorted:   ").append(Arrays.toString(results.get(i).sortedArray()))
                        .append("\nComparisons: ").append(results.get(i).comparisons()).append("\n\n");
            }

            output.append("\nWorst 10 cases:\n");
            output.append("--------------------\n");
            for (int i = results.size() - 10; i < results.size(); i++) {
                output.append("Original: ").append(Arrays.toString(results.get(i).originalArray()))
                        .append("\nSorted:   ").append(Arrays.toString(results.get(i).sortedArray()))
                        .append("\nComparisons: ").append(results.get(i).comparisons()).append("\n\n");
            }

            // Print the average comparisons for this test size with two decimal places
            output.append("\nAverage comparisons: ").append(String.format("%.2f", totalComparisons / (double) permutations.length)).append("\n");
        }

        // Write results to a file in the "results" directory
        try {
            FileOutputUtil.writeToFile("heapsort.txt", output.toString());
            System.out.println("Results written to results/heapsort.txt");
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
