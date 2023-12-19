package A_Easy_Data_Structures.DistinctDigitNumbers;

import java.util.List;

public class DistinctDigitNumbers {

    public static void main(String[] args) {
        // Example input
        List<Integer> first = List.of(2, 2, 1, 20, 9, 19);
        List<List<Integer>> rangeList = List.of(first);

        // Output the counts of distinct digit numbers
        countDistinctDigitNumbers(rangeList);
    }

    public static void countDistinctDigitNumbers(List<List<Integer>> rangeList) {
        for (List<Integer> range : rangeList) {
            int rowCount = range.get(0);
            int columnCount = range.get(1);

            // Start index for boundaries in the range list
            int boundaryIndex = 2;

            // Iterate through each range in the list
            for (int i = 0; i < rowCount; i++) {
                int lowerBound = range.get(boundaryIndex);
                int upperBound = range.get(boundaryIndex + 1);

                // Count distinct digit numbers within the current range
                int count = countDistinctNumbersInRange(lowerBound, upperBound);
                System.out.println(count);

                // Move to the next set of boundaries in the range list
                boundaryIndex += 2;
            }
        }
    }

    public static int countDistinctNumbersInRange(int lowerBound, int upperBound) {
        int count = 0;

        // Iterate through the numbers in the range
        for (int num = lowerBound; num <= upperBound; num++) {
            if (hasDistinctDigits(num)) {
                count++;
            }
        }

        return count;
    }

    public static boolean hasDistinctDigits(int num) {
        boolean[] digitOccurred = new boolean[10]; // Assuming numbers are less than 10 digits

        // Check for distinct digits
        while (num > 0) {
            int digit = num % 10;
            if (digitOccurred[digit]) {
                return false; // Digit repeated
            }

            digitOccurred[digit] = true;
            num /= 10;
        }

        return true; // No repeating digits
    }
}



