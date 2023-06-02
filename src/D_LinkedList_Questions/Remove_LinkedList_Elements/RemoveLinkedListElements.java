package week_13_Stack_Recursion_ORMpart1;

import java.util.stream.Stream;

class RemoveLinkedListElements {
    /*
    203. Remove Linked List Elements
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []

Constraints:
    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50

    https://leetcode.com/problems/remove-linked-list-elements/
     */
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        Stream.of(1, 2, 6, 3, 4, 5, 6).forEach(list1::add);
        list1.head.printList();
        ListNode head1 = solution.twoPointer(list1.head, 6);
        head1.printList();

        MyLinkedList list2 = new MyLinkedList();
        Stream.of(6, 1, 2, 6, 3, 4, 5, 6).forEach(list2::add);
        list2.head.printList();
        ListNode head2 = solution.removeElements(list2.head, 6);
        head2.printList();

        System.out.println(solution.twoPointer(null, 1));

        MyLinkedList list4 = new MyLinkedList();
        Stream.of(7, 7, 7, 7).forEach(list4::add);
        list4.head.printList();
        System.out.println(solution.twoPointer(list4.head, 7));

        MyLinkedList list5 = new MyLinkedList();
        Stream.of(2, 2, 3, 4).forEach(list5::add);
        list5.head.printList();
        solution.twoPointer(list5.head, 2).printList();
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode current = head.next;

        while (current.next != null) {
            if (head.val == val) {
                head = current;
            } else if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // time complexity : O(n) space complexity : O(1)
    public ListNode twoPointer(ListNode head, int val) {
        if (head == null) return null;
        ListNode current = head;
        ListNode prev = head;
        while (current != null) {
            if (current.val == val) {       // 6, 1, 2, 6, 3, 4, 5, 6
                if (current == head) {
                    current = current.next;
                    head = current;
                    prev = current;
                } else {
                    current = current.next;
                    prev.next = current;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    // time complexity : O(n) space complexity : O(1)
    public ListNode withFakeHead(ListNode head, int val) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode current = fakeHead;

        while (current.next != null) {  // -1, 6, 1, 2, 6, 3, 4, 5, 6
            if (current.next.val == val) {
                current.next = current.next.next;
            } else
                current = current.next;
        }
        return fakeHead.next;
    }

    // time complexity : O(n) space complexity : O(1)
    public ListNode withOnePointer(ListNode head, int val) {
        if (head == null) return null;
        ListNode current = head;

        while (current.next != null) {
            if (current.next.val == val){
                current.next = current.next.next;
            } else{
                current = current.next;
            }
        }
        return head.val == val ? head.next : head;
    }


    // other solutions
    /*
First, we shift a head of a list while its value equals to val.
Then, we iterate through the nodes of the list checking if the next node's value equals to val and removing it if needed.
     */
    // time complexity : O(n) space complexity : O(1)
    public ListNode withShiftingHeadFirst(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    // recursive solutions
    // time complexity : O(n) space complexity : O(n)
    public ListNode withRecursive(ListNode head, int val) {
        if (head == null) return null;
        ListNode next = withRecursive(head.next, val);
        if (head.val == val) return next;
        head.next = next;
        return head;
    }

    /*
When the input node is an empty node, then there is nothing to delete, so we just return a null node back. (That's the first line)
When the head of the input node is the target we want to delete, we just return head.next instead of head to skip it.
(That's the third line), else we will return head.
We apply the same thing to every other node until it reaches null. (That's the second line).
     */
    // time complexity : O(n) space complexity : O(n)
    public ListNode withRecursive2(ListNode head, int val) {
        if (head == null) return null;
        head.next = withRecursive2(head.next, val);
        return head.val == val ? head.next : head;
    }

}
