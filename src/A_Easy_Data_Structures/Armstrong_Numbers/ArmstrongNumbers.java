package z_questions;

import java.util.Scanner;

public class ArmstrongNumbers {
    /*
    Lorraine Cannom — Today at 2:19 AM
These are questions I was asked during an online assessment:

    Armstrong Numbers
Programming challenge description:
An Armstrong number is an n-digit number that is equal to the sum of the nth powers of its digits. Determine if the input numbers are Armstrong numbers.
Input:
Your program should read lines from standard input. Each line has a positive integer.
Output:
Print out True if the number is an Armstrong number, or False if not.
Test 1
351
Expected Output
False
Test 2
153
Expected Output
True

1134. Armstrong Number
The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.

Given a positive integer N, return true if and only if it is an Armstrong number.

Example 1:
Input: 153
Output: true
Explanation:
153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
Example 2:

Input: 123
Output: false
Explanation:
123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.

Note:
1 <= N <= 10^8
locked leetcode question
https://leetcode.ca/all/1134.html
*/
    // chatGPT
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            boolean isArmstrong = isArmstrongNumber(num);
            System.out.println(isArmstrong);
        }

        scanner.close();
    }

    public static boolean isArmstrongNumber(int num) {
        // Convert the number to a string to get its getLength
        String numStr = Integer.toString(num);
        int n = numStr.length();

        // Compute the sum of the nth powers of the digits
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, n);
        }

        // Check if the sum is equal to the original number
        return sum == num;
    }

/*
[2:19 AM]

Calculate Distance
Programming challenge description:
You have (x, y) coordinates for 2 points and need to find the distance between them.
Input:
Your program should read lines from standard input. Each line contains two space-delimited coordinate pairs. All x and y values are integers between -100 and 100.
Output:
Print the distance between the two points. You do not need to round the results you receive.
Test 1
(25, 4) (1, -6)
Expected Output
26

Test 2
(47, 43) (-25, -11)
Expected Output 90
*/
// chatGPT
static class CalculateDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            int x1 = Integer.parseInt(tokens[0].substring(1, tokens[0].length() - 1));
            int y1 = Integer.parseInt(tokens[1].substring(0, tokens[1].length() - 1));
            int x2 = Integer.parseInt(tokens[2].substring(1, tokens[2].length() - 1));
            int y2 = Integer.parseInt(tokens[3].substring(0, tokens[3].length() - 1));

            double distance = calculateDistance(x1, y1, x2, y2);
            System.out.println(distance);
        }

        scanner.close();
    }

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        int xDiff = x2 - x1;
        int yDiff = y2 - y1;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
/*
[2:20 AM]
Alter Case
Programming challenge description:
Write a program that, given an input sentence, alternates the case of every alphabetic character, starting with uppercase. Spaces and non-alphabetical characters should be added to the final output as is, i.e. they should not be taken into account when alternating between upper/lowercase.
Input:
Your program should read lines from standard input. Each line contains a sentence. Assume all characters are ASCII.
Output:
For each sentence from standard input, print to standard output the sentence such that the first character is uppercase, the next character is lowercase and so on.
Test 1
Test Input
We are the world
Expected Output
We ArE tHe WoRlD

Test 2
this is some code
Expected Output
ThIs Is SoMe CoDe
     */

    // chatGPT
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String sentence = scanner.nextLine();
                StringBuilder sb = new StringBuilder();

                boolean isUpper = true;

                for (char c : sentence.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        if (isUpper) {
                            sb.append(Character.toUpperCase(c));
                        } else {
                            sb.append(Character.toLowerCase(c));
                        }
                        isUpper = !isUpper;
                    } else {
                        sb.append(c);
                    }
                }

                System.out.println(sb.toString());
            }
        }
    }

//    Explanation:
//
//    We use a Scanner to read the input sentences from standard input.
//    For each sentence, we create a StringBuilder to build the output string.
//    We use a boolean flag isUpper to keep track of whether we should append an uppercase or lowercase character to the output string.
//    We iterate through each character in the input sentence using a for loop.
//    If the character is alphabetic, we append either an uppercase or lowercase version of the character to the output string based on the value of isUpper. We then toggle the value of isUpper.
//    If the character is not alphabetic, we simply append it to the output string.
//    After processing the entire sentence, we print the output string using System.out.println().


}
