package week_15_DSA_probSolving_TicketingORMpart1;

import java.util.HashSet;
import java.util.stream.Stream;

public class LinkedListCycleDetection {
    /*
    141. Linked List Cycle
    Easy
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following
the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?

https://leetcode.com/problems/linked-list-cycle/
     */

    public static void main(String[] args) {
        LinkedListCycleDetection solution = new LinkedListCycleDetection();
        MyLinkedList list = new MyLinkedList();
        Stream.of(3, 2, 0, -4).forEach(list::add);
        list.tail.next = list.head.next;
        System.out.println("list.hashSet(list.head) = " + solution.hashSet(list.head));
        System.out.println("list.twoPointer(list.head) = " + solution.twoPointer(list.head));
    }

    public boolean hashSet(ListNode head) {
        if (head == null) return false;
        ListNode current = head;
        HashSet<ListNode> set = new HashSet<>();
        while (current != null) {
            if (!set.add(current)) return true;
            current = current.next;
        }
        return false;
    }

    public boolean twoPointer(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

}
