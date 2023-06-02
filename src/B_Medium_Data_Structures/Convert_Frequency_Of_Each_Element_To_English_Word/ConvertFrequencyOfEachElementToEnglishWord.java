package week_21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertFrequencyOfEachElementToEnglishWord {
    /*
        Find Frequency of Each Array Element And Convert to English Word
        Write a function that takes an integer array, and counts each number and
        prints a sentence to say how many times a number is repeated.
        NumberToWord order is not important.

        EXAMPLE:
        input  :  array = {1, 2, 3, 4, 3, 2, 1, 3, 2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 2}
        output :
        1 is two times
        3 is three times
        4 is two times
        2 is more than ten times
     */

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3, 2, 1, 3, 2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 2};

        arrayAndMap(arr);
        System.out.println("----------------------");
        withEnumAndMap(arr);
        System.out.println("----------------------");
        withStreamAndEnum(arr);
    }

    // Time complexity O( n^2 )   Space Complexity( O(n) )
    static void arrayAndMap(int[] arr) {
        if (arr == null || arr.length == 0){
            System.out.println("array is empty");
            return;
        }
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "more than ten"};
        Map<Integer, String> map = new HashMap<>();

        for (int each : arr) {
            int count = 0;
            for (int n : arr) {
                if (each == n) {
                    count++;
                }
            }
            if (count > 10) {
                map.put(each, words[11]);
            } else {
                map.put(each, words[count]);
            }
        }

        map.forEach((k, v) -> System.out.println(k + " is " + v + " times"));
    }

    // Time complexity O( n )   Space Complexity( O(n) )
    static void withEnumAndMap(int[] arr) {
        if (arr == null || arr.length == 0){
            System.out.println("array is empty");
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int each : arr) {
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        map.forEach((k, v) -> {
            int n = v <= 11 ? v : 11;
            System.out.println(k + " is " + NumberToWord.values()[n].value  + " times");
        });
    }



    // Time complexity O( n )   Space Complexity( O(n) )
    static void withStreamAndEnum(int[] arr) {
        if (arr == null || arr.length == 0){
            System.out.println("array is empty");
            return;
        }
        Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .forEach((k, v) -> {                            //Map.forEach method
                  //  int n = v <= 11 ? Math.toIntExact(v) : 11;
                    long n = v <= 11 ?  v : 11;
                    System.out.println(k + " is " + NumberToWord.values()[(int) n].value + " times");
                });
    }

    enum NumberToWord {
        ZERO("zero"), ONE("one"), TWO("two"), THREE("three"), FOUR("four"), FIVE("five"),
        SIX("six"), SEVEN("seven"), EIGHT("eight"), NINE("nine"), TEN("ten"), MORE_THAN_TEN("more than ten");

        final String value;
        NumberToWord(String value){
            this.value = value;
        }
    }
}


