package A_Easy_Data_Structures.CardinalitySorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class CardinalitySorting {

    public static void main(String[] args) {
        List<Integer> decimalList = List.of(5, 3, 8, 12, 6, 9);

        List<Integer> sortedList = sortByBinaryCardinality(decimalList);

        System.out.println("Sorted List: " + sortedList);
    }

    public static List<Integer> sortByBinaryCardinality(List<Integer> decimalList) {
        List<Integer> sortedList = new ArrayList<>(decimalList);

        sortedList.sort(Comparator.comparingInt(Integer::bitCount)
                .thenComparing(Comparator.naturalOrder()));

        return sortedList;
    }
}

