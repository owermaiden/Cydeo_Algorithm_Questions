package F_Recursion_Questions.Climbing_Stairs;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    /*
    Simba has a number of staircases in his house, and he likes to climb each staircase 1 or 2 steps at a time.
It takes n steps to reach the top. In how many distinct ways can he climb to the top?

Example 1:
Input: n = 2	Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3	Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
•	1 <= n <= 45

Follow-up: What if he climbs each staircase 1, 2 or 3 steps at a time?
Hint: Think about Fibonacci numbers. How would you find the n’th number in Fibonacci series?
     */

    public static void main(String[] args) {
        int n = 45;         // user input
        ClimbingStairs solution = new ClimbingStairs();

        System.out.println("iteration : " + solution.iteration(n));
        System.out.println("recursion : " + solution.recursion(n));
        System.out.println("recursion_forDebug = " + solution.recursion_forDebug(n));
        System.out.println("map_recursive : " + solution.map_recursive(n));
        System.out.println("array_recursive : " + solution.array_recursive(n));

    }

    // time complexity : O(n)
    // space complexity : O(1)
    long iteration(int n) {
        if (n <= 2) {
            return n;
        }
        int n1 = 1, n2 = 2, result = 0;

        for (int i = 3; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }

    // time complexity : O(2^n)
    // space complexity : O(n)
    int recursion(int n) {
        if (n <= 2) {
            return n;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    int recursion_forDebug(int n) {
        int result = 0;
        if (n <= 2) {
            return n;
        }
        System.out.println("before; n : " + n + " result : " + result);
        result = recursion(n - 1) + recursion(n - 2);
        System.out.println("\tafter; n : " + n + " result : " + result);
        return result;
    }

    // memoization
    // time complexity : O(n)
    // space complexity : O(n)
    public int map_recursive(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return mapUtil(n, map);
    }

    private int mapUtil(int n, Map<Integer, Integer> map) {
        if (n <= 2) {
            return n;
        }
        if (map.containsKey(n)) // if calculated before, the use it
            return map.get(n);

        // if not calculated before, calculate it recursively and put in map:
        int ways = mapUtil(n - 1, map)
                + mapUtil(n - 2, map);
        map.put(n, ways);
        return ways;
    }

    // time complexity : O(n)
    // space complexity : O(n)
    public int array_recursive(int n) {
        int[] ways = new int[n + 1];
        return memoizationArrayUtil(n, ways);
    }

    private int memoizationArrayUtil(int n, int[] ways) {
        if (n <= 2) {
            return n;
        }
        if (ways[n] != 0) return ways[n]; // if calculated before, the use it

        // if not calculated before, calculate it recursively and put in array:
        ways[n] = memoizationArrayUtil(n - 1, ways)
                + memoizationArrayUtil(n - 2, ways); // first store it to use afterward, and then return the value
        return ways[n];
    }


    // Tabulation
    // time complexity : O(n)
    // space complexity : O(n)
    public int onlyWithArray(int n) {
        if (n <= 2) {
            return n;
        }
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }


    /**
     * *****************************************************
     */
    // follow-up:

    // time complexity : O(n)
    // space complexity : O(1)
    long iteration_follow_up(int n) {
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        long n1 = 1, n2 = 2, n3 = 4, result = 0;

        for (int i = 4; i <= n; i++) {
            result = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = result;
        }
        return result;
    }

    // time complexity : O(3^n)
    // space complexity : O(n)
    long recursion_follow_up(int n) {
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        return recursion_follow_up(n - 1) + recursion_follow_up(n - 2) + recursion_follow_up(n - 3);
    }

    long recursion_follow_up_forDebug(int n) {
        long result = 0;
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        System.out.println("before; n : " + n + " result : " + result);
        result = recursion_follow_up_forDebug(n - 1) + recursion_follow_up_forDebug(n - 2) + recursion_follow_up_forDebug(n - 3);
        System.out.println("\tafter; n : " + n + " result : " + result);
        return result;
    }

    // memoization
    // time complexity : O(n)
    // space complexity : O(n)
    public long map_recursive_follow_up(int n) {
        Map<Integer, Long> map = new HashMap<>();
        return mapUtil_follow_up(n, map);
    }

    private long mapUtil_follow_up(int n, Map<Integer, Long> map) {
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        if (map.containsKey(n))// if solved before the use it
            return map.get(n);

        long ways = mapUtil_follow_up(n - 1, map)
                + mapUtil_follow_up(n - 2, map)
                + mapUtil_follow_up(n - 3, map);
        map.put(n, ways);
        return ways;
    }

    // time complexity : O(n)
    // space complexity : O(n)
    public long memoizationArray_recursive_follow_up(int n) {
        long[] ways = new long[n + 1];
        return memoizationArrayUtil_follow_up(n, ways);
    }

    private long memoizationArrayUtil_follow_up(int n, long[] ways) {
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        if (ways[n] != 0) return ways[n]; // if solved before the use it

        ways[n] = memoizationArrayUtil_follow_up(n - 1, ways)
                + memoizationArrayUtil_follow_up(n - 2, ways)
                + memoizationArrayUtil_follow_up(n - 3, ways); // first store it to use afterwards and then return the value
        return ways[n];
    }


    // Tabulation
    // time complexity : O(n)
    // space complexity : O(n)
    public long onlyWithArray_follow_up(int n) {
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        long[] ways = new long[n + 1];

        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;

        for (int i = 4; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }
        return ways[n];
    }

}
