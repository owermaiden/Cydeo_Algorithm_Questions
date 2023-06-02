package D_LinkedList_Questions.Delete_N_nodes_After_M_nodes;

import D_LinkedList_Questions.ListNode;
import D_LinkedList_Questions.MyLinkedList;
import java.util.ArrayList;
import java.util.List;
    /*
    1474. Delete N Nodes After M Nodes of a Linked List
    easy
    locked version : https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
    question : https://leetcode.ca/2019-12-13-1474-Delete-N-Nodes-After-M-Nodes-of-a-Linked-List/

Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:

    Start with the head as the current node.
    Keep the first m nodes starting with the current node.
    Remove the next n nodes
    Keep repeating steps 2 and 3 until you reach the end of the list.

Return the head of the modified list after removing the mentioned nodes.

Follow up question: How can you solve this problem by modifying the list in-place?

Example 1:
Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
Output: [1,2,6,7,11,12]
Explanation: Keep the first (m = 2) nodes starting from the head of the linked List (1 ->2) show in black nodes.
Delete the next (n = 3) nodes (3 -> 4 -> 5) show in read nodes.
Continue with the same procedure until reaching the tail of the Linked List. Head of linked list after removing nodes is returned.

Example 2:
Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3       Output: [1,5,9]
Explanation: Head of linked list after removing nodes is returned.

Example 3:
Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1       Output: [1,2,3,5,6,7,9,10,11]

Example 4:
Input: head = [9,3,7,7,9,10,8,2], m = 1, n = 2      Output: [9,7,8]

Constraints:
    The given linked list will contain between 1 and 10^4 nodes.
    The value of each node in the linked list will be in the range [1, 10^6].
    1 <= m,n <= 1000
 */

public class DeleteNnodesAfterMnodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);
        ListNode listNode7 = new ListNode(8);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(10);
        ListNode listNode10 = new ListNode(11);
        head.next = listNode1;
        head.next.next = listNode2;
        head.next.next.next = listNode3;
        head.next.next.next.next = listNode4;
        head.next.next.next.next.next = listNode5;
        head.next.next.next.next.next.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        ListNode current = head;
        for (int i = 2; i < 15; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        head.printList();
        deleteNodes(head, 1, 2);
        head.printList();
    }


    public void deleteNodesWhileLoop(List<Integer> expected, ListNode input, int m, int n) {
        ListNode current = input;
        List<Integer> actual = new ArrayList<>();
        deleteNodes(input, m, n);
        input.printList();
        while (current != null) {
            actual.add(current.val);
            current = current.next;
        }
    }

    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode lastM = head;
        while (current != null) {
            // initialize mCount to m and nCount to n
            int mCount = m, nCount = n;
            // traverse m nodes
            while (current != null && mCount != 0) {
                lastM = current;
                current = current.next;
                mCount--;
            }
            // traverse n nodes
            while (current != null && nCount != 0) {
                current = current.next;
                nCount--;
            }
            // delete n nodes
            lastM.next = current;
        }
        return head;
    }
    /*  Above solution time&space complexity
    Time Complexity: O(N). Here, N is the getLength of the linked list pointed by head. We traverse over the linked list only once.
    Space Complexity: O(1). We use constant extra space to store pointers like lastMNode and currentNode.
     */

    public void deleteNodesForLoop(List<Integer> expected, ListNode input, int m, int n) {
        ListNode current = input;
        List<Integer> actual = new ArrayList<>();
        deleteNodes2(input, m, n);
        input.printList();
        while (current != null) {
            actual.add(current.val);
            current = current.next;
        }
    }

    public static ListNode deleteNodes2(ListNode head, int m, int n) {
        ListNode pointer1 = head;
        ListNode pointer2;
        while (pointer1 != null) {
            for (int i = 1; i < m && pointer1.next != null; i++) { //go in blue
                pointer1 = pointer1.next;
            }
            pointer2 = pointer1.next;                                  //p2 to red
            for (int i = 1; i <= n && pointer2 != null; i++) {          //go in red
                pointer2 = pointer2.next;
            }
            pointer1.next = pointer2;                                  //make connection
            pointer1 = pointer2;                                       //come together
        }
        return head;
    }
    /*  Above solution time&space complexity
    Time Complexity: O(N). Here, N is the getLength of the linked list pointed by head. We traverse over the linked list only once.
    Space Complexity: O(1). We use constant extra space to store pointers like lastMNode and currentNode.
     */

}

