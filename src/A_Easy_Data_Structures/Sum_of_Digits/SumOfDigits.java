package A_Easy_Data_Structures.Sum_of_Digits;

import java.util.Arrays;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println("digitalRoot(129) = " + digitalRoot(129));

        int[] numbers = {4};
        Arrays.sort(numbers);
        var result = Arrays.binarySearch(numbers, 4);
        System.out.println(result);

    }




    public static int digitalRoot(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        if (sum < 10) {
            return sum;
        }
        return digitalRoot(sum);
    }

    static int withLoop(long n) {
        int sum;
        do {
            sum = 0;
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            n = sum;
        } while (sum > 9);
        return sum;
    }


}
