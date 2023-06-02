package D_Queue_Dequeue_Questions.Time_Needed_to_Buy_Ticket;


import java.util.*;
import java.util.stream.Collectors;

public class TimeNeededtoBuyTickets {
    /*
    2073. Time Needed to Buy Tickets

There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and
the (n - 1)th person is at the back of the line.
You are given a 0-indexed integer array tickets of getLength n where the number of tickets that the ith person
would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to
go back to the end of the line (which happens instantaneously) in order to buy more tickets.
If a person does not have any tickets left to buy, the person will leave the line.

Return the time taken for the person at position k (0-indexed) to finish buying tickets.

Example 1:
Input: tickets = [2,3,2], k = 2
Output: 6
Explanation:
- In the first pass, everyone in the line buys a ticket and the line becomes [1, 2, 1].
- In the second pass, everyone in the line buys a ticket and the line becomes [0, 1, 0].
The person at position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.

Example 2:
Input: tickets = [5,1,1,1], k = 0
Output: 8
Explanation:
- In the first pass, everyone in the line buys a ticket and the line becomes [4, 0, 0, 0].
- In the next 4 passes, only the person in position 0 is buying tickets.
The person at position 0 has successfully bought 5 tickets and it took 4 + 1 + 1 + 1 + 1 = 8 seconds.

Constraints:

    n == tickets.getLength
    1 <= n <= 100
    1 <= tickets[i] <= 100
    0 <= k < n
     */

    public static void main(String[] args) {

        int[] ints = {5, 1, 1, 1};  // 0
        int[] ints2 = {84, 49, 5, 24, 70, 77, 87, 8};  // 3
        int[] ints3 = {1, 10};  // 0
        System.out.println(withDeque(ints3, 0));
    }

    // TC : O(n * k) SC : O(n)
    static int withDeque(int[] tickets, int k) {
        int result = 0;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            int[] person = {tickets[i], 0};
            if (i == k)
                person[1] = 1;
            deque.addLast(person);
        }

        while (!deque.isEmpty()) {
            int[] front = deque.pollFirst();
            result++;
            if (--front[0] > 0) {
                deque.addLast(front);
            }
            if (front[1] == 1 && front[0] == 0)
                return result;
        }
        return result;
    }

    // TC : O( n * k ) SC : O(n)
    static int withDeque2(int[] tickets, int k) {
        int result = 0;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            int[] person = {tickets[i], 0};
            if (i == k)
                person[1] = 1;
            deque.addLast(person);
        }

        int[] front = new int[2];
        while ( !(front[1] == 1 && front[0] == 0) ) {
            front = deque.pollFirst();
            result++;
            if (--front[0] > 0) {
                deque.addLast(front);
            }
        }
        return result;
    }

    // TC : O(n) SC : O(1)
    static int oneLoopWithArray(int[] tickets, int k) {
        int result = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                result += Math.min(tickets[k], tickets[i]);
            } else {
                result += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return result;
    }

    // TC : O( n * k ) SC : O(n)
    public static int timeRequiredToBuyWithQueue(int[] tickets, int k) {
        Queue<Integer> ticketQueue = Arrays.stream(tickets).boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int totalTime = 0;
        while (!ticketQueue.isEmpty()) {

            int leftTicketCount = ticketQueue.poll()-1;
            totalTime++;

            if (leftTicketCount == 0){
                if (k == 0){
                    return totalTime;
                }
                else if (k > 0){
                    k--;
                }
            }
            else {
                ticketQueue.add(leftTicketCount);
                if (k > 0){
                    k--;
                }
                else if (k == 0){
                    k = ticketQueue.size() - 1;
                }
            }
        }

        return -1;
    }

    // TC O( n * k )    SC O( n * k )
    public static int getTimeWithQueue(int[] tickets, int k) {
        Queue<Integer> ticketQueue = new ArrayDeque<>();

        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == 0) {
                    continue;
                }
                if (tickets[k] == 0) {
                    break;
                }
                ticketQueue.add(tickets[i]--);
            }
        }
        return ticketQueue.size();
    }

}
