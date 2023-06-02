package A_Easy_Data_Structures.Remove_Whole_Squares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveWholeSquares {
    /*
   Remove whole squares

   Given the list of whole positive integers, remove all integers which have a whole number square root.
   Print the new getLength of the list with items deleted and print the last item in the list that was deleted.

   For example:
   9 has a whole number square root … 3
   5 does not have a whole number square root … 2.2360

   Input:
   Input consists of N lines of one number each.
   All number are positive whole numbers. There are no decimals or fractions.
   There will always be at least one number in the list

   Output:
   On the first line, Print the new getLength of the list after deleting all numbers with a whole number square root.
   On the second line, print the last number in the list with a whole number square root that was deleted (see example below).
   If no numbers with a whole number square root are found, only print the first line,

   Sample Input
   10
   9
   151
   16
   8
   Sample Output :
   3
   16
    */

    public static void main(String[] args) throws IOException {
        String inputData = "";
        String thisLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((thisLine = br.readLine()) != null) {
            inputData += thisLine + "\n";
        }
        System.out.println(deleteWholeSqrt(inputData));
    }

    public static String deleteWholeSqrt(String inputData) {
        int count = 0;
        int last = 0;
        String[] arr = inputData.split("\r?\n|\r");
        inputData = "";

        for (String each : arr) {
            int current = Integer.parseInt(each);
            double sqrt = Math.sqrt(current);
            if (sqrt == Math.floor(sqrt)) {
                last = current;
            } else {
                count++;
            }
        }
        inputData = last == 0 ? "" + count : count + "\n" + last;
        return inputData;
    }

    //    static String deleteWholeSqrt(String str){
//        List<Integer> result = new ArrayList<>();
//        Integer last = null;
//        String[] strings = str.split("\n");
//        List<Integer> list = new ArrayList<>();
//        for (String s : strings) {
//            list.add(Integer.parseInt(s));
//        }
//        for (int n : list) {
//            double d = Math.sqrt(n);
//            if (d != Math.floor(d)){
//                result.add(n);
//            } else {
//                last = n;
//            }
//        }
//        return last != null ? result.size() + "\n" + last : result.size()+"";
//    }
}

