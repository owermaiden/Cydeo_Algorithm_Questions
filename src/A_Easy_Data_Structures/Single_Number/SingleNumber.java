package A_Easy_Data_Structures.Single_Number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] input = {2, 2, 1};
        System.out.println(findSingleOn2(input));
        System.out.println(findSingle1(input));
        System.out.println(findSingle2(input));
        System.out.println(findSingle3(input));
        System.out.println(findSingle4(input));

    }

    public static int findSingleOn2(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (Integer num : nums) {
            if (!result.remove(num)) {
                result.add(num);
            }
        }
        return result.get(0);
    }

    public static int findSingle1(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();

        for (Integer num : nums) {
            if (setOfNums.contains(num)) {
                setOfNums.remove(num);
            } else {
                setOfNums.add(num);
            }
        }
        return (int) setOfNums.toArray()[0];
    }

    public static int findSingle2(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();

        for (Integer num : nums) {
            if (!setOfNums.remove(num)) {
                setOfNums.add(num);
            }
        }
        return setOfNums.iterator().next();
    }

    public static int findSingle3(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();

        for (Integer num : nums) {
            if (!setOfNums.add(num)) {
                setOfNums.remove(num);
            }
        }
        return setOfNums.iterator().next();
    }

    public static int findSingle4(int[] nums) {
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;
    }


    public static int findSingle5(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int sumOfAllElements = 0;
            int sumOfUniqueElements = 0;

            for (int i = 0; i < nums.length; i++) {
                if (set.add(nums[i]))   sumOfUniqueElements += nums[i];
                sumOfAllElements += nums[i];
            }
            return 2 * sumOfUniqueElements - sumOfAllElements;
        }

/*4,1,1,2,2
    4+1+2  = 7   sum of unique elements
    10              sum of all elements
    2*7 -10 = 4      the difference - is our searching element

  -4,1,1,2,2
    -4+1+2  = -1   sum of unique elements
    2              sum of all elements
    2*(-1) -2 = -4      the difference - is our searching element
*/

}
