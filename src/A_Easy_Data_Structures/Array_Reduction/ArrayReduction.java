package A_Easy_Data_Structures.Array_Reduction;

import java.util.*;

public class ArrayReduction {

    public static void main(String[] args) {
        int[] num1 = {4, 6, 8 }; // Example input array
        List<Integer> num = new ArrayList<>(Arrays.asList(4,6,8));
        int minimumCost = minimumTotalCost(num);
        int minimumCost2 = minimumTotalCost(num1);
        System.out.println("Minimum total cost: " + minimumCost);
        System.out.println("Minimum total cost: " + minimumCost2);
    }

    public static int minimumTotalCost(List<Integer> num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : num) {
            pq.offer(n);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            cost += sum;
            pq.offer(sum);
        }

        return cost;
    }

    public static int minimumTotalCost(int[] num) {
        Arrays.sort(num); // Sort the array in ascending order
        int cost = 0;

        while (num.length > 1) {
            int sum = num[0] + num[1]; // Calculate the sum of the two smallest elements
            cost += sum; // Add the sum to the total cost

            // Create a new array with size reduced by 2
            int[] newArray = new int[num.length - 1];
            newArray[0] = sum; // Place the sum at the end of the new array

            // Copy the remaining elements from the original array to the new array
            for (int i = 2; i < num.length; i++) {
                newArray[i - 1] = num[i];
            }

            num = newArray; // Update the array reference
            Arrays.sort(num); // Sort the array again
        }

        return cost;
    }

}
