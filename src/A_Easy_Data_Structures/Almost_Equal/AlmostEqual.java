package A_Easy_Data_Structures.Almost_Equal;

import java.util.*;

public class AlmostEqual {

    public static void main(String[] args) {

        List<String> firstList = Arrays.asList("aaabbb", "abcdhcb");
        List<String> secondList = Arrays.asList("acabbb", "aaadaab");
        System.out.println(areAlmostEquivalent(firstList, secondList));
        System.out.println(areAlmostEquivalentMap(firstList, secondList));
    }


    public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            int[] sCount = new int[26];
            int[] tCount = new int[26];
            for (char c : s.get(i).toCharArray()) {
                sCount[c - 'a']++;
            }
            for (char c : t.get(i).toCharArray()) {
                tCount[c - 'a']++;
            }
            String res = "YES";
            for (int j = 0; j < 26; j++) {
                if (Math.abs(sCount[j] - tCount[j]) > 3) {
                    res = "NO";
                    break;
                }
            }
            result.add(res);
        }
        return result;
    }

    public static List<String> areAlmostEquivalentMap(List<String> s, List<String> t) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            Map<Character, Integer> sCountMap = new HashMap<>();
            Map<Character, Integer> tCountMap = new HashMap<>();

            // Count occurrences of characters in the first string (s)
            for (char c : s.get(i).toCharArray()) {
                sCountMap.put(c, sCountMap.getOrDefault(c, 0) + 1);
            }

            // Count occurrences of characters in the second string (t)
            for (char c : t.get(i).toCharArray()) {
                tCountMap.put(c, tCountMap.getOrDefault(c, 0) + 1);
            }

            String res = "YES";
            for (char c : sCountMap.keySet()) {
                int sCount = sCountMap.getOrDefault(c, 0);
                int tCount = tCountMap.getOrDefault(c, 0);

                if (Math.abs(sCount - tCount) > 3) {
                    res = "NO";
                    break;
                }
            }
            result.add(res);
        }
        return result;
    }





}
