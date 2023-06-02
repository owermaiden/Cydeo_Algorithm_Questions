package week_14_ORMpart2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAllElementsGreaterThanItsRight {
    /*
Find All Elements Greater Than Their Right

Given an unsorted integer array, return all greater elements than all elements present to their right using Stack.
Example:
Input: [10, 4, 6, 3, 5]
Output: [10, 6, 5]
The elements that are greater than all elements to their right are 10, 6, and 5.
10 > 4  &  10 > 6  &  10 > 3  &  10 > 5
     */
    public static void main(String[] args) {
        FindAllElementsGreaterThanItsRight solution = new FindAllElementsGreaterThanItsRight();
        int[] ints = {10, 4, 6, 3, 5};
        int[] ints2 = {10};
        Stream<int[]> inputs = Stream.of(ints, ints2, new int[0], null);
        inputs.forEach(l -> {
            System.out.println("\t" + Arrays.toString(l));
            System.out.println(solution.withLinkedList(l));
            System.out.println(solution.withStack(l));
            System.out.println(solution.withDeque(l));
            System.out.println(solution.withArrayDeque(l));
            System.out.println(solution.withArrayList(l));
        });
    }

    // time complexity O(n)  space complexity O(n)
    List<Integer> withLinkedList(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<>();
        if (arr == null || arr.length == 0) {
            return stack;
        }

        for (int value : arr) {
            // pop all the elements that are less than the current element
            while (!stack.isEmpty() && stack.peek() < value) {
                stack.pop();
            }
            // push current element into the stack
            stack.push(value);
        }
        // Collections reverse method reverses the element of a List in linear time i.e time complexity is O(n).
        stack.sort(Collections.reverseOrder());
        return stack;
    }

     List<Integer> withStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        if (nums == null || nums.length == 0) return stack;
        stack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > stack.peek()) {
                stack.push(nums[i]);
            }
        }
         stack.sort(Comparator.reverseOrder());
         return stack;
    }

     Deque<Integer> withDeque(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        if (nums == null || nums.length == 0) return stack;
        stack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > stack.peek()) {
                stack.push(nums[i]);
            }
        }
        return stack;
    }

     Deque<Integer> withArrayDeque(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (nums == null || nums.length == 0) return stack;
        stack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > stack.peek()) {
                stack.push(nums[i]);
            }
        }
        return stack;
    }

     List<Integer> withArrayList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        list.add(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
