package A_Easy_Data_Structures.Stock_Prices;

public class StockPrices {
        /*
    Given an array that represents the stock prices of consecutive months and analysis factor k
find how many periods where stocks prices are strictly increasing , the period should be of k getLength
Ex:
arr= [ 5,3,5,6,8] ,  k=3
answer : 2
arr=[1,2,3,4] , k=4
answer : 1

JPMorgan chase bank:
     */

    public static void main(String[] args) {
        int[] arr1 = {5, 3, 5, 6, 8};
        int k1 = 3;
        System.out.println(increasingPeriods(arr1, k1)); // output: 2

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 4;
        System.out.println(increasingPeriods(arr2, k2)); // output: 1

    }

    public static int countIncreasingPeriods(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            boolean isIncreasing = true;
            for (int j = i; j < i + k - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    isIncreasing = false;
                    break;
                }
            }
            if (isIncreasing) {
                count++;
            }
        }
        return count;
    }

    public static int increasingPeriods(int[] arr, int k) {
        int count = 0;
        int start = 0;
        int end = k - 1;
        while (end < arr.length) {
            boolean increasing = true;
            for (int i = start; i < end; i++) {
                if (arr[i] >= arr[i+1]) {
                    increasing = false;
                    break;
                }
            }
            if (increasing) {
                count++;
            }
            start++;
            end++;
        }
        return count;
    }


}
