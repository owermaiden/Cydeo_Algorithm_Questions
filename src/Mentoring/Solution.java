package Mentoring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
Problem : Count the number of Duplicated Letters
Write a function that will return the count of distinct case-insensitive alphabetic characters and
numeric digits that occur more than once in the input string.
The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
Example:
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */
    public static void main(String[] args) {
        String given = "abbcdeaa   ";
        System.out.println(findDuplicatedLetters(given));
    }

    private static int findDuplicatedLetters(String given) {
        //  given.charAt(i)
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < given.length(); i++) {
            int count = 0;
            for (int j = 0; j < given.length(); j++) {
                if (given.charAt(i) == given.charAt(j)
                   && given.charAt(j) != ' '){
                    count++;
                }
            }
            if (count > 1){
                chars.add(given.charAt(i));
            }

        }
        return chars.size();
    }
}
