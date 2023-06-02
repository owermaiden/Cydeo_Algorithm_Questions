package F_Recursion_Questions.Happy_Number;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {

    /*
        202. Happy Number
        Write a function that returns true if a number is a happy number, and false if it is an unhappy number.

        A happy number is a number defined by the following process:
            Starting with any positive integer, replace the number by the sum of the squares of its digits.
            Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
            Those numbers for which this process ends in 1 are happy.

        Example 1:
        Input: n = 19
        Output: True
        Explanation:
            19 is Happy Number,
            1^2 + 9^2 = 82
            8^2 + 2^2 = 68
            6^2 + 8^2 = 100
            1^2 + 0^2 + 0^2 = 1
            As we reached to 1, 19 is a Happy Number.

        Example 2:
        Input: n = 20   Output: False

        Constraints:
        1 <= n <= 2^31 - 1

        leetcode link : https://leetcode.com/problems/happy-number/

        For more explanation about happy number : https://en.wikipedia.org/wiki/Happy_number
     */


    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        int[] input = {4,       19,     20,     2,      365,    256};
        // expected : false,   true,   false,   false,  true,   false
        for (int each : input) {
            System.out.println(solution.solutionWithNestedLoop(each));
            System.out.println(solution.solutionWithSet(each));
            System.out.println(solution.twoPointer(each));
            System.out.println(solution.solutionWithRecursion(each));
            System.out.println("--------------------");
        }

    }


    /*
    A number will not be a Happy Number when it makes a loop in its sequence which already been touched.
    So to check whether a number is happy or not, we can keep a set, if the same number
    occurs again, we flag result as not happy.
     */

    // TC : hard to guess O(log n)  SC: O(log n))
    /*
 TC explanation:   https://stackoverflow.com/questions/58977656/how-to-understand-time-complexity-of-happy-number-problem-solution-from-leetcode
space complexity: for simplicity of let's assume our input can only take the form (10, 100, 1000, ..., 10^d) where d+1 is the number of digits.
n = 10^d
take log both sides
log(n) = d
number of digits = log(n) + 1
We usually ignore constants when we talk about big O and therefore the answer is O(log(n))
     */
    public boolean solutionWithSet(int n) {     // n = 19
        Set<Integer> seenSet = new HashSet<>();
        while (seenSet.add(n)) {     // TC : hard to guess,
            if (n == 1)
                return true;
            int sum = 0;
            while (n != 0) {        // TC :  O(log(n))
                sum += Math.pow(n % 10, 2);     // 1. iteration: sum = 0 + 9 * 9   2. iteration: sum = 81 + 1 * 1
                n = n / 10;
            }
            n = sum;
        }
        return false;
    }

    // We can solve this problem without using extra space and that technique can be used in some other similar problems also.
    // If we treat every number as a node and replacement by square sum digit, then this problem is same as
    // finding a loop in a linklist : we will keep two numbers slow and fast both initialize from a given number,
    // slow is replaced one step at a time and fast is replaced two steps at a time. If they meet at 1,
    // then the given number is Happy Number otherwise not.

    // TC : hard to guess O(log n)  SC: O(1))
    public boolean twoPointer(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(fast);
            fast = findSquareSum(fast);
            if (fast == 1) return true;
        } while (slow != fast);

        return false;
    }

    private int findSquareSum(int n) {
        int squareSum = 0;
        while (n != 0) {
            int eachDigit = n % 10;
            squareSum += eachDigit * eachDigit;
            n /= 10;
        }
        return squareSum;
    }

    // TC : hard to guess O(log n)  SC: O(log n))
    public boolean solutionWithRecursion(int n) {
        // it becomes infinite loop if n = 4        4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 → ...
        if (n == 4)
            return false;
        if (n == 1) return true;
        int sum = findSquareSum(n);
        return solutionWithRecursion(sum);
    }


    // other solutions
    public boolean solutionWithNestedLoop(int n) {
        // it becomes infinite loop if n = 4
        while (n != 1 && n != 4) {
            int eachDigit, sum = 0;

            while (n > 0) {
                eachDigit = n % 10;
                sum = sum + (eachDigit * eachDigit);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
