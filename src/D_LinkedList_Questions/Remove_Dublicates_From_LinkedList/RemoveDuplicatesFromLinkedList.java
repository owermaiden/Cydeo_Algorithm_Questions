package Remove_Dublicates_From_LinkedList;

import java.util.stream.Stream;

public class RemoveDuplicatesFromLinkedList {
    /*
     * Question # 17
     Description: Remove Duplicates From Linked List
     * Difficulty: Easy Category: Linked Lists
     You're given the head of a Singly Linked List whose nodes are in sorted order with respect to
     their values. Write a function that returns a modified version of the Linked List that doesn't
     contain any nodes with duplicate values. The Linked List should be modified in place (i.e.,
     you shouldn't create a brand-new list), and the modified Linked List should still have its
     nodes sorted with respect to their values. Each LinkedList node has an integer value as well
     as a next node pointing to the next node in the list or to None / null if it's the tail of the list.
     Example:
     Input: 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 // the head node with value 1
     Output: 1 -> 3 -> 4 -> 5 -> 6 // the head node with value 1
     */
    /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-list/

    83. Remove Duplicates from Sorted List
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    Return the linked list sorted as well.

    Input: head = [1,1,2]
    Output: [1,2]

    Input: head = [1,1,2,3,3]
    Output: [1,2,3]

    Constraints:
    1 <= digits.getLength <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.
     */

    public static void main(String[] args) {
        RemoveDuplicatesFromLinkedList solution = new RemoveDuplicatesFromLinkedList();
        MyLinkedList list = new MyLinkedList();
        Stream.of(1, 1, 2).forEach(list::add);
        ListNode head = solution.twoPointer(list.head);
        head.printList();

        MyLinkedList list2 = new MyLinkedList();
        Stream.of(1, 2, 3, 3).forEach(list2::add);
        ListNode head2 = solution.twoPointer(list2.head);
        head2.printList();

        MyLinkedList list3 = new MyLinkedList();
        Stream.of(1, 1, 2, 3, 3, 4).forEach(list3::add);
        ListNode head3 = solution.twoPointer(list3.head);
        head3.printList();

        MyLinkedList list4 = new MyLinkedList();
        list4.add(4);
        ListNode head4 = solution.twoPointer(list4.head);
        head4.printList();
    }

    // time complexity : O(n) space complexity : O(1)
    public ListNode twoPointer(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }

    // time complexity : O(n) space complexity : O(1)
    public ListNode withOnePointer(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    // time complexity : O(n) space complexity : O(1)
    public ListNode withOnePointerTwoWhile(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
