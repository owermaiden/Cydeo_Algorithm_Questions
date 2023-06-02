package z_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q23_TwinsSurvey {

    /*
     * inputArr, represents the given array of element of size inputArr_size.
     */
    public static void funcTwins(int[] inputArr) {
        // Write your code here
        List<Integer> listOfArr = new ArrayList<>();
        for (int i = 0; i < inputArr.length; i++) {
            int result = -1;
            int count = 0;
            int each = inputArr[i];
            for (int j = 0; j < inputArr.length; j++) {
                if (inputArr[j] == each) {
                    count++;
                }
            }
            if (count == 1) {
                result = each;
                listOfArr.add(each);
            }
        }
        if (listOfArr.size() > 0) {
            int minResult = listOfArr.get(0);
            for (int i = 0; i < listOfArr.size(); i++) {
                if (listOfArr.get(i) < minResult) {
                    minResult = listOfArr.get(i);
                }
            }
            System.out.println(minResult);
        } else {
            System.out.println(-1);
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //input for inputArr
        int inputArr_size = in.nextInt();
        int inputArr[] = new int[inputArr_size];
        for (int idx = 0; idx < inputArr_size; idx++) {
            inputArr[idx] = in.nextInt();
        }


        funcTwins(inputArr);
    }
    

}
