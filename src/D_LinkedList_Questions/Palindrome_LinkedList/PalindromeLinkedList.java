package D_LinkedList_Questions.Palindrome_LinkedList;

import D_LinkedList_Questions.ListNode;
import D_LinkedList_Questions.MyLinkedList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

public class PalindromeLinkedList {
    /*
    234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false

Constraints:
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
     */

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        //for positive scenario
        MyLinkedList linkedList = new MyLinkedList();
        Stream.of(1, 8, 3, 6,6, 3, 8, 1).forEach(linkedList::add);

        System.out.println("positive scenario : ");
        linkedList.head.printList();
        System.out.println(solution.withTwoPointer(linkedList.head));

        //for negative scenario
        MyLinkedList linkedList2 = new MyLinkedList();
        Stream.of(1, 8, 3, 6, 4, 8, 1).forEach(linkedList2::add);

        System.out.println("negative scenario : ");
        linkedList2.head.printList();
        System.out.println(solution.withTwoPointer(linkedList2.head));
    }

     boolean withStackSimple(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        // it compares all nodes twice
        while (current != null) {
            if (current.val != stack.pop())
                return false;
            current = current.next;
        }
        return true;
    }

     boolean withStackAdvanced(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = head;
        ListNode prev = null;
        // it compares each node once.
        // we need to keep previous if linkedlist size is even number
        while (current != stack.peek() && prev != stack.peek()) {   // object equality not value
            if (current.val != stack.pop().val) return false;
            prev = current;
            current = current.next;
        }
        return true;
    }

     boolean withTwoPointer(ListNode head) {
        ListNode slow = head, fast = head, prev, nextNode, current;
        // find middle point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse 2nd half of linked list
        prev = slow;
        current = slow.next;
        prev.next = null;   // we break the reverse cycle and avoid an endless loop.
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // palindrome check : first half and second half
        ListNode left = head;
        ListNode right = prev;
        while (left != null && right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

}
