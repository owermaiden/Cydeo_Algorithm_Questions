package week_23_AOP_testingAsiya;

import java.util.Scanner;

public class Q22_ContinuousSequenceOfIntegersWithLargestSum {

    /*
     * inputArr, represents the array with inputArr_size (N) elements.
     */
    public class Solution1 {
        public static int funcSum(int[] inputArr) {
            int answer = Integer.MIN_VALUE;
            // Write your code here
            int size = inputArr.length;
            int max_still = 0;

            for (int i = 0; i < size; i++) {
                max_still += inputArr[i];
                if (answer < max_still)
                    answer = max_still;
                if (max_still < 0)
                    max_still = 0;
            }

            return answer;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            //input for inputArr
            int inputArr_size = in.nextInt();
            int[] inputArr = new int[inputArr_size];
            for (int idx = 0; idx < inputArr_size; idx++) {
                inputArr[idx] = in.nextInt();
            }

            int result = funcSum(inputArr);
            System.out.print(result);

        }
    }
}
