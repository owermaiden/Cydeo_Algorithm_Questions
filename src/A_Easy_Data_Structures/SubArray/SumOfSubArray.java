package A_Easy_Data_Structures.SubArray;

import java.util.List;
import java.util.Stack;

public class SumOfSubArray {

    public static long subarraySum(List<Integer> arr) {
        int n = arr.size();
        long sum = 0;

        // Calculate prefix sums to optimize subarray sum calculations
        long[] prefixSums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + arr.get(i - 1);
        }

        // Iterate through all subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                // Calculate the sum of the current subarray using prefix sums
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        // Example usage
//        List<Integer> arr = List.of(4, 5, 6);
//        long result = subarraySum2(arr);
//        System.out.println("Sum of all subarrays: " + result);
        List<Integer> arr = List.of(4, 5, 6);
        long result = subarraySum(arr);
        System.out.println("Sum of all subarrays: " + result);
    }
}
