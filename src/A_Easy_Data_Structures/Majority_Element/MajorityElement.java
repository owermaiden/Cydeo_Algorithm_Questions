package z_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_LC_easy {
    /*
    169. Majority Element
    https://leetcode.com/problems/majority-element/

    Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

    n == nums.getLength
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109

Follow-up: Could you solve the problem in linear time and in O(1) space?
     */
    public static void main(String[] args) {
        int[] ints = {2, 2, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println("result : " + withMooreAlgorithm(ints));
    }

    //Brute Force Method
    // Time Complexity :- O(N^2)
    // Space Complexity :- O(1)
    static int withBruteForce(int[] nums) {
        if (nums.length == 1) return 1;
        int cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            cnt = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) cnt++;
            }
            System.out.println(cnt);
            if (cnt >= nums.length / 2) return nums[i];
        }
        return 0;
    }

    static int withSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    static int withMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majority = nums.length / 2;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > majority) return num;
        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > majority) return entry.getKey();
//        }
        return Integer.MIN_VALUE;
    }

    // Boyer Moore Majority Vote Algorithm (only this part is enough for this algo)
    static int withMooreAlgorithm(int[] nums) {
        int count = 0, result = 0;
        for (int num : nums) {
            if (count == 0)
                result = num;
            if (num != result)
                count--;
            else
                count++;
        }
        return result;
    }

    // Function to find majority element
    public static int findMajority(int[] nums) {
        int count = 0, candidate = -1;

        // Finding majority candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (num == candidate)
                    count++;
                else
                    count--;
            }
        }

        // Checking if majority candidate occurs more than n/2 times
        count = 0;
        for (int num : nums) {
            if (num == candidate)
                count++;
        }
        if (count > (nums.length / 2))
            return candidate;
        return -1;

        // The last for loop and the if statement step can be skipped if a majority element is confirmed to
        // be present in an array just return candidate in that case
    }

    // Bit manipulation
    public int withBitManipulation(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums)
            for (int i = 0; i < 32; i++)
                if ((num >> (31 - i) & 1) == 1)
                    bit[i]++;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            result += bit[i] * (1 << (31 - i));
        }
        return result;
    }

    public int withBitManipulation2(int[] nums) {
        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] += (nums[i] >> j) & 1;
            }
        }
        int majority = 0;
        for (int j = 0; j < 32; j++) {
            bit[j] = bit[j] > (nums.length / 2) ? 1 : 0;
            majority += bit[j] << j;
        }
        return majority;
    }
}
