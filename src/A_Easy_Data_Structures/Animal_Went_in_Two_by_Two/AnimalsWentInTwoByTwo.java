package A_Easy_Data_Structures.Animal_Went_in_Two_by_Two;

import java.util.*;

public class AnimalsWentInTwoByTwo {
    /*
A great flood has hit the land, and just as in Biblical times we need to get the animals to the ark in pairs.
We are only interested in getting one pair of each animal, and not interested in any animals where there are less than 2. They need to mate to repopulate the planet after all!
Write a function that takes a list of animals as a parameter, which you need to check to see which animals there are at least two of, and then return a Map<String, Integer> that contains the name of the animal along with the fact that there are 2 of them to bring onto the ark.
Examples:
Input: []
Output: {}

Input: ['goat']
Output: {}
Input : ["dog", "goat", "dog"]
Output: {dog=2}
Input : ["dog", "cat", "dog", "cat", "beaver", "cat"]
Output: {cat=2, dog=2}

Input: ["goat", "goat", "rabbit", "rabbit", "rabbit", "duck", "horse", "horse", "swan"]
Output: {horse=2, rabbit=2, goat=2}
     */
    public static void main(String[] args) {
        System.out.println(withIterator(Arrays.asList()));  // {}
        System.out.println(withIterator(Arrays.asList("goat")));    // {}
        System.out.println(withIterator(Arrays.asList("dog", "goat", "dog"))); // {dog=2}
        System.out.println(withIterator(Arrays.asList("dog", "cat", "dog", "cat", "beaver", "cat")));   // {cat=2, dog=2}
        System.out.println(withIterator(Arrays.asList("goat", "goat", "rabbit", "rabbit", "rabbit", "duck", "horse", "horse", "swan")));
        // {horse=2, rabbit=2, goat=2}
    }

    // TC : O (n)  SC : O (n)
    static Map<String, Integer> withRemoveIf(List<String> animals) {
        Map<String, Integer> pairs = new HashMap<>();
        if (animals.size() < 2) return pairs;
        for (String animal : animals) {
            int num = pairs.getOrDefault(animal, 0);
            if (num < 2) {
                pairs.put(animal, ++num);
            }
        }
        pairs.entrySet().removeIf(e -> e.getValue() == 1);
        return pairs;
    }

    // TC : O (n)  SC : O (n)
    static Map<String, Integer> withIterator(List<String> animals) {
        Map<String, Integer> pairs = new HashMap<>();
        if (animals.size() < 2) return pairs;
        for (String animal : animals) {
            int num = pairs.getOrDefault(animal, 0);
            if (num < 2) {
                pairs.put(animal, ++num);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = pairs.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue()== 1){
                iterator.remove();
            }
        }
        return pairs;
    }

}
