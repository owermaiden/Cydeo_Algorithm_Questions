package A_Easy_Data_Structures.Length_of_Words;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfWords {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("JAVA", "APPLE", "HONDA", "DEVELOPER");
        printNumberOfChars(words);
    }

    static void printNumberOfChars(List<String> words) {
        List<Integer> list = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(list);
        String s = words.stream()
                .map(w -> w.length()+"")
                .collect(Collectors.joining(", "));
        System.out.println(s);
    }
}
