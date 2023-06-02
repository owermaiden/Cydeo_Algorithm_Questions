package C_Hard_Data_Structures.Frequency_of_Words_Regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOFWordsWithRegex {
    /*
* Using the sentence below create an application to count the number of times each word appears in the sentence.
  The application should output the number of times each word occurs.

"This is an example paragraph in which words appear multiple times.

*   However, it is important that we consider all possibilities in our count of words.
*   Please feel free to ask questions based on the requirements as this is an interactive interview!"
     */

    public static void main(String[] args) {
        String given = "This is an example paragraph in which words appear multiple times.          However, it is important that we consider all possibilities in our count of words.  Please feel free to ask questions based on the requirements as this is an interactive interview!";
        String given2 = "This is an example of example";
        String given3 = "This” is an example!    of example…";
        String[] strings = {given, given2, given3,"   ", "", null};
        for (String s : strings) {
            System.out.println(getFreqOFWords(s));
        }
    }

    static Map<String, Integer> getFreqOFWords(String str) {
        if (str == null) return null;
        Map<String, Integer> mapOfWords = new HashMap<>();
//        String[] words = str.trim().replaceAll("[^A-Za-z ]+", "").toLowerCase().split(" +");
//        String[] words = str.trim().toLowerCase().split("[^A-Za-z]+");
        String[] words = str.trim().toLowerCase().split("\\W+");
        for (String word : words) {
            mapOfWords.put(word, mapOfWords.getOrDefault(word, 0) + 1);
        }
        return mapOfWords;
    }


    static Map<String, Long> withStreamLong(String str) {
        if (str == null) return null;
        return Arrays.stream(str.trim().toLowerCase().split("[^A-Za-z]+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    static Map<String, Integer> withStream(String str) {
        if (str == null) return null;
        return Arrays.stream(str.trim().toLowerCase().split("\\W+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(s -> 1)));
    }

}


