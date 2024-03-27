package B_Medium_Data_Structures.Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

      /*
      3. Longest Substring Without Repeating Characters

Given a string s, find the getLength of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the getLength of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the getLength of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the getLength of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
    0 <= s.getLength <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

https://leetcode.com/problems/longest-substring-without-repeating-characters/
         */

    public static void main(String[] args) {
        System.out.println(withStringBuilder("abcabcbb"));
    }
    public static int withNestedLoop(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            int len = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                }
                set.add(c);
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    static int withSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            char ch = s.charAt(right);
            if (set.add(ch)) {
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

    // abcabc
    static int withMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;   // keep track of the starting index of the current non-repeating substring
        int max = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                // move the left pointer to the right side of the previous occurrence of that character.
                // By taking the maximum value, we ensure that the left pointer never moves backward,
                // as it should always point to the starting index of a valid non-repeating substring.
                left = Math.max(map.get(ch) + 1, left); // "abba" fails without Math.max
            }
            map.put(ch, right);
            max = Math.max(max, right - left + 1);  // current non-repeating length = right - left + 1
        }
        return max;
    }


    // other solutions
    // TC: O(n^2)
    static int withString(String s) {
        if (s.length() < 2) return s.length();
        int max = 0;
        String sub = "";
        for (int i = 0; i < s.length(); i++) {  // TC: O(n)
            char ch = s.charAt(i);
            if (!sub.contains(ch + "")) {       // TC: O(n)
                sub = sub + ch;
                max = Math.max(max, sub.length());
            } else {
                sub = sub.substring(sub.indexOf(ch) + 1) + ch;
            }
        }
        return max;
    }

    // TC: O(n^2)     SC: O(n)
    static int withStringBuilder(String s) {
        if (s.length() < 2) return s.length();
        int max = 0;
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!sub.toString().contains(ch + "")) {
                sub.append(ch);
                max = Math.max(max, sub.length());
                String x = sub.substring(0) + 'a';
                System.out.println(x);
                StringBuilder a = new StringBuilder(x);
                System.out.println(a);
            } else {
                sub = new StringBuilder(sub.substring(sub.toString().indexOf(ch) + 1) + ch);
            }
        }
        return max;
    }

    // TC: O(n^2)     SC: O(1)
    static int withNestedLoopWithArray(String s) {
        int length = s.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            boolean[] visited = new boolean[128];
            int j = i;
            while (j < length && !visited[s.charAt(j)]) {
                visited[s.charAt(j)] = true;
                j++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    // TC: O(n)     SC: O(1)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), longest = 0;
        int[] nextIndex = new int[128];

        for (int r = 0, l = 0; r < n; r++) {
            l = Math.max(nextIndex[s.charAt(r)], l);
            longest = Math.max(longest, r - l + 1);
            nextIndex[s.charAt(r)] = r + 1;
        }

        return longest;
    }

}
