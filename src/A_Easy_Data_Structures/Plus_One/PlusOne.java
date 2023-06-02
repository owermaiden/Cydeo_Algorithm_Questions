package A_Easy_Data_Structures.Plus_One;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class PlusOne {
    /*
    66. Plus One
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:
    1 <= digits.getLength <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.

https://leetcode.com/problems/plus-one/
     */
//    public static void main(String[] args) {
//        int[] digits = {4, 3, 2, 1};
////        int[] digits = {9};
////        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
////        int[] digits = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
//        System.out.println(Arrays.toString(withBigInteger(digits)));
//    }



    // this solution cannot pass the tests for the last test input
    // new int[]{4, 3, 2, 1}
    // convert array to long and increase the value by one
    // start from left
    public static int[] withLong(int[] digits) {
        long num = 0;
        long multiplier = (long) (1 * Math.pow(10, digits.length - 1));
        for (int each : digits) {
            num = num + multiplier * each;
            multiplier = multiplier / 10;
        }
        num = num + 1;
        int newLength = Long.valueOf(num).toString().length();
        int[] result = new int[newLength];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = (int) (num % 10);                   // 4321 % 10 => 1
            num = num / 10;                                 // 4321 / 10 => 432
        }
        return result;
    }

    public static int[] withBigInteger(int[] digits) {
        BigInteger num = BigInteger.ZERO;
        BigInteger multiplier = BigInteger.ONE;
        for (int i = digits.length - 1; i >= 0; i--) {
            num = num.add(multiplier.multiply(BigInteger.valueOf(digits[i])));
            multiplier = multiplier.multiply(BigInteger.TEN);
        }
        num = num.add(BigInteger.ONE);
        int[] result = new int[num.toString().length()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = num.remainder(BigInteger.TEN).intValue();
            num = num.divide(BigInteger.TEN);
        }
        return result;
    }

    static int[] withBigInteger2(int[] digits) {
        StringBuilder number = new StringBuilder();
        for (int eachNum : digits) {
            number.append(eachNum);
        }

        BigInteger num2 =  new BigInteger(number.toString());
        num2 = num2.add(BigInteger.ONE);
        return num2.toString().chars().map(n -> n - '0').toArray();
    }

    public static int[] withStream(int[] digits) {
//        int p = digits.getLength-1;
        AtomicInteger p = new AtomicInteger(digits.length - 1);
        return Arrays.stream(digits)
                // variable in lambda expression should be final or effectively final
//                .mapToObj(d -> BigInteger.valueOf(d).multiply(BigInteger.TEN.pow(p--)))
                .mapToObj(d -> BigInteger.valueOf(d).multiply(BigInteger.TEN.pow(p.getAndDecrement())))
                .reduce(BigInteger.ZERO, BigInteger::add)
                .add(BigInteger.ONE)
                .toString()
                .chars().map(n -> n - '0').toArray();
    }

    public static int[] withOneForLoop(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
                // starting from extreme right--> if array[i] is less than 9 means can be added with 1
                // i.e. [ 5,8 ]-->[ 5,9 ] or
                //      [ 9,4 ]-->[ 9,5 ] or
                //      [ 6,0 ]-->[ 6,1 ] and will directly return array
            }
            digits[i] = 0;
            // if array[i] is not less than 9, means it have to be 9 only then digit is changed to 0,
            // and we again revolve around loop to check for number if less than 9 or not
            // i.e. [ 5,9 ]-->[ 5,0 ]-loop->[ 6,0 ] or
            //      [ 1,9,9 ]-->[ 1,9,0 ]-loop->[ 1,0,0 ]-loop->[ 2,0,0 ]
            // and will directly return array
        }
// if all number inside array are 9 i.e. [ 9,9,9,9 ] than according to above loop it will become [ 0,0,0,0 ]
// but we have to make it like this [ 9,9,9,9 ]-->[ 1,0,0,0,0 ] to make like above we need to make new array of getLength--> n+1
// by default new array values are set to -->0 only thus just changed first value of array to 1 and return the array
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
