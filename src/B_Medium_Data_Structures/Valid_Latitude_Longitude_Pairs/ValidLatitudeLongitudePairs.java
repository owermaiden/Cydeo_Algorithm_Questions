package z_questions;
/*
Write an algorithm to identify the valid and invalid lattitide/longtitude pairs from the given list of the strings.
Input:
The first line of the input consists of an integer -inputsize,representing the size of the string(N).
the next line consists of N space-seperated substrings containing the latitude/longtitude pairs.
Output:
Print N space-seperated strings representing the valisd and invaliud latitude/longtitude pairs from the given list of strings.
Print "Valid" for valid pairs and "invalid" for invalid pairs.
Contraints:
1< N<100
Example:
input:
5
(90,180)(+90,+180)(90.,180)(90..0,180.1)(855,95W)

Output:
Valid Valid Invalid Invalid Invalid
 */

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args) {

//        String[] parts = {"(90,180)","(91,180)"};
        String[] parts = {"(90,180)", "(+90,+180)", "(90.,180)", "(90..0,180.1)", "(855,95W)"};
        System.out.println(Arrays.toString(validPairs(parts)));
        System.out.println(Arrays.toString(funcValidPairs(parts)));
        System.out.println(Arrays.toString(myValidation(parts)));
    }

    static String[] myValidation(String[] inputStr) {
        String[] answer = new String[inputStr.length];
        // a decimal with no leading zero (.14 instead of 0.14) or without a trailing fractional part (3. instead of 3.0) :
        System.out.println(   "^((\\+|-)?(0|([1-9][0-9]*))(\\.[0-9]+)?)$"  );
        for (int i = 0; i < inputStr.length; i++) {
            boolean b = inputStr[i].matches("^\\(((\\+|-)?(0|([1-9][0-9]*))(\\.[0-9]+)?),((\\+|-)?(0|([1-9][0-9]*))(\\.[0-9]+)?)\\)$");
            if (!b) {
                answer[i] = "Invalid";
                continue;
            }
            inputStr[i] = inputStr[i].replaceAll("\\(|\\)", "");
            String[] numbers = inputStr[i].split(",");
            double x = Double.parseDouble(numbers[0]);
            double y = Double.parseDouble(numbers[1]);
            if (x > 90 | x < -90) {
                answer[i] = "Invalid";
                continue;
            }
            if (y > 180 | y < -180) {
                answer[i] = "Invalid";
                continue;
            }
            answer[i] = "Valid";
        }

        return answer;
    }

    static String[] validPairs(String[] inputStr) {
        String[] answer = new String[inputStr.length];
        String pattern = "^-?([0-8]?[0-9]|90)(\\.\\d{1,10})?,\\s*-?((1?[0-7]?[0-9])|180)(\\.\\d{1,10})?$";

        Pattern match = Pattern.compile(pattern);

        for (int i = 0; i < inputStr.length; i++) {
            Matcher m = match.matcher(inputStr[i]);

            if (m.find()) {
                answer[i] = "Valid";
            } else {
                answer[i] = "Invalid";
            }
        }

        return answer;
    }

    public static String[] funcValidPairs(String[] inputStr) {
        String[] answer = new String[inputStr.length];
        //System.out.println(Arrays.toString(inputStr));

        for (int i = 0; i < inputStr.length; i++) {
            answer[i] = "Valid";
            String each = inputStr[i];
            if (each.contains(" ") || !each.startsWith("(") || !each.endsWith(")")) {
                answer[i] = "Invalid";
                continue;
            }
            String X = each.substring(1, each.indexOf(","));
            if (X.charAt(0) == '-' || X.charAt(0) == '+') {
                X = X.substring(1);
            }
            if (X.charAt(X.length() - 1) == '.') {
                answer[i] = "Invalid";
                continue;
            }
            for (int j = 0; j < X.length(); j++) {
                if (!Character.isDigit(X.charAt(j)) && X.charAt(j) != '.') {
                    answer[i] = "Invalid";
                }
            }
            try {
                double Xnumber = Double.parseDouble(X);
                if (Xnumber > 180.0) {
                    answer[i] = "Invalid";
                    continue;
                }

                String Y = each.substring(each.indexOf(",") + 1, each.length() - 1);
                if (Y.charAt(0) == '-' || Y.charAt(0) == '+') {
                    Y = Y.substring(1);
                }
                if (Y.charAt(Y.length() - 1) == '.') {
                    answer[i] = "Invalid";
                    continue;
                }
                for (int j = 0; j < Y.length(); j++) {
                    if (!Character.isDigit(Y.charAt(j)) && Y.charAt(j) != '.') {
                        answer[i] = "Invalid";
                    }
                }
                double Ynumber = Double.parseDouble(X);
                if (Ynumber > 180.0) {
                    answer[i] = "Invalid";
                    continue;
                }
            } catch (NumberFormatException e) {
                answer[i] = "Invalid";
            }

        }
        return answer;
    }

}
