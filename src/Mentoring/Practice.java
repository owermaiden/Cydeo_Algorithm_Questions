package Mentoring;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {
        // convert array to arraylist
        int[] nums = {1,2,3,4};
//        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (int each : nums) {
            list.add(each);
        }
        System.out.println(list);


        // convert arraylist to int[]
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4));
        int [] arr = new int [list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
        System.out.println(Arrays.toString(arr));

//        int[] numsArray = numbers.stream().mapToInt(Integer::intValue).toArray();

        // convert list to Integer[]
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4));
        Integer[] intArr= list2.toArray(new Integer[0]);

        // convert array to hashset
        int[] nums2 = {1,2,3,4};
    }
}
