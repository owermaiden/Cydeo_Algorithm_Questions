package week_19_api;

public class SlidingWindowSample {

    /*
    The problem gives us an array of length n and a number k. The problem asks us to find the maximum sum of k
    consecutive elements inside the array.
     */
    public static void main(String[] args) {
//        int[] nums = {1, 3, 2, 4, 6, 1, 2, 1};     // k = 3  result = 12
        int[] nums = {5, 7, 1, 4, 3, 6, 2, 9, 2};    // k = 5  result = 24
        int k = 5;
        System.out.println(withNestedLoop(nums, k));
        System.out.println(withSlidingWindow(nums, k));
    }

    /*
    The outer loop iterates over each possible starting index of a subarray of length k, from 0 to n-k.
    The inner loop then calculates the sum of the elements in the subarray starting from the current index,
    and updates the maximum sum seen so far.
    Note that this solution has a time complexity of O(nk), since for each of the n-k+1 possible subarrays,
    we need to sum up k elements.
     */
    public static int withNestedLoop(int[] nums, int k) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /*
    The method initializes the maxSum variable to the smallest possible integer value and the currentSum variable to 0.
    It then iterates through the array using a sliding window of size k.
    For each window, the method adds the current element to the currentSum and checks if the window has reached size k.
    If so, it updates the maxSum with the maximum value between the current maxSum and the currentSum,
    and then removes the first element of the window from the currentSum by subtracting the element nums[i-k+1].
    Finally, the method returns the maxSum.
     */
    public static int withSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;

        for (int i = k; i < n; i++) {
            currentSum -= nums[i - k];  // subtract element to the left of current window
            currentSum += nums[i];      // add last element in current window
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
