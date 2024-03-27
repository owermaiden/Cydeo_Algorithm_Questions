package A_InterviewPrep;

import java.util.*;

public class DequeSliderWindow {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> unique = new HashSet<>();
        int n = 6;
        int m = 3;
        int[] nums = {5,3,5,2,3,2};

        int max = 0;
        for (int i = 0; i < n; i++) {
            deque.addLast(nums[i]);
            unique.add(nums[i]);

            if (deque.size() == m + 1) {
                int removed = deque.removeFirst();
                if (!deque.contains(removed)) {
                    unique.remove(removed);
                }
            }

            if (deque.size() == m) {
                max = Math.max(max, unique.size());
            }
        }
        System.out.println(max);
    }
}
/***
In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

Note: Time limit is  second for this problem.

Input Format

The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.

Constraints




The numbers in the array will range between .

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size .

Sample Input

6 3
5 3 5 2 3 2
Sample Output

3
Explanation

In the sample testcase, there are 4 subarrays of contiguous numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

In these subarrays, there are  unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is .
 */
