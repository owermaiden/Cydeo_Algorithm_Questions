package week_22_TicketingREST;

import java.util.Arrays;

public class MultiplyOfArray_Elements {
    /*
    Given an array of integers, update every element with the multiplication of previous and next elements with the following exceptions.
    a) The First element is replaced the by multiplication the of first and second.
    b) The last element is replaced by multiplication of the last and second last.

    Input : arr[] = {2, 3, 4, 5, 6}
    Output : arr[] = {6, 8, 15, 24, 30}

    if length 1 ? null ?
     */

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(multiplyElements(new int[]{2, 3, 4, 5, 6})));
//        System.out.println(Arrays.toString(multiplyElements(new int[]{2, 3})));
        System.out.println(Arrays.toString(multiplyElements(new int[]{2})));
//        System.out.println(Arrays.toString(multiplyElements(new int[]{})));
//        System.out.println(Arrays.toString(multiplyElements(null)));
//        System.out.println(Arrays.toString(multiplyElements2(new int[]{2, 3, 4, 5, 6})));
//        System.out.println(Arrays.toString(multiplyElements2(new int[]{2})));
//        System.out.println(Arrays.toString(multiplyElements2(null)));
    }

    static int[] multiplyElements(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int n = nums.length;
        int[] result = new int[n];
        result[0] = nums[0] * nums[1];
        result[n - 1] = nums[n - 2] * nums[n - 1];

        for (int i = 1; i < n - 1; i++) {
            result[i] = nums[i - 1] * nums[i + 1];
        }
        return result;
    }

    static int[] multiplyElements2(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int n = nums.length;
        int prev = nums[0];
        nums[0] = nums[0] * nums[1];
        for (int i = 1; i < n-1; i++) {
            int current = nums[i];
            nums[i] = prev * nums[i + 1];
            prev = current;
        }
        nums[n - 1] = nums[n - 1] * prev;
        return nums;
    }

}
