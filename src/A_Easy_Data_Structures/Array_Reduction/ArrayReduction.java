package A_Easy_Data_Structures.Array_Reduction;

import java.util.*;

public class ArrayReduction {

    /*
    There is an array of n integers called num. The array
can be reduced by 7 element by performing a move.
Each move consists of the following three steps:

1. Pick two different elements num(ijand num[j, i # j.
2. Remove the two selected elements from the array.

3. Add the sum of the two selected elements to the end
of the array.

Each move has a cost associated with it: the sum of
the two elements removed from the array during the
move. Calculate the minimum total cost of reducing
the array to one element.

Example
num = [4,6,8]

Remove 4 and 6in the first move ata cost of 4 +6 =
10, and the resultant array is num’ = [8,10].

Remove 8and 70in the second move at a cost of 8 +
10 = 18, and the resultant array is num" = [18].

The total cost of reducing this array to one element
using this sequence of moves is 10 + 18 = 28. This is
just one set of possible moves.
     */

    public static void main(String[] args) {
        int[] num1 = {2,3,4,6,8, 10 }; // Example input array
        List<Integer> num = new ArrayList<>(Arrays.asList(2,3,4,6,8, 10));
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
