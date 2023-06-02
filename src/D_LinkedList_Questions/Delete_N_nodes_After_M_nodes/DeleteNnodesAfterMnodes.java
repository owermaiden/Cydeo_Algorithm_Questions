package Delete_N_nodes_After_M_nodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
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
        Node head = new Node(1);
//        Node node1 = new Node(2);
//        Node node2 = new Node(3);
//        Node node3 = new Node(4);
//        Node node4 = new Node(5);
//        Node node5 = new Node(6);
//        Node node6 = new Node(7);
//        Node node7 = new Node(8);
//        Node node8 = new Node(9);
//        Node node9 = new Node(10);
//        Node node10 = new Node(11);
//        head1.next = node1;
//        head1.next.next = node2;
//        head1.next.next.next = node3;
//        head1.next.next.next.next = node4;
//        head1.next.next.next.next.next = node5;
//        head1.next.next.next.next.next.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;
        Node current = head;
        for (int i = 2; i < 15; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        head.print();
        deleteNodes(head, 1, 2);
        head.print();
    }

    public static Stream<Arguments> inputs() {
        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i < 10; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        List<Integer> expected1 = List.of(1, 4, 7);

        Node head2 = new Node(1);
        Node current2 = head2;
        for (int i = 2; i < 25; i++) {
            current2.next = new Node(i);
            current2 = current2.next;
        }
        List<Integer> expected2 = List.of(1, 2, 3, 8, 9, 10, 15, 16, 17, 22, 23, 24);

        Node head3 = new Node(1);
        Node current3 = head3;
        for (int i = 2; i < 1001; i++) {
            current3.next = new Node(i);
            current3 = current3.next;
        }
        List<Integer> expected3 = List.of(1, 101, 201, 301, 401, 501, 601, 701, 801, 901);

        return Stream.of(
                arguments(expected1, head, 1, 2),
                arguments(expected2, head2, 3, 4),
                arguments(expected3, head3, 1, 99)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void deleteNodesWhileLoop(List<Integer> expected, Node input, int m, int n) {
        Node current = input;
        List<Integer> actual = new ArrayList<>();
        deleteNodes(input, m, n);
        input.print();
        while (current != null) {
            actual.add(current.value);
            current = current.next;
        }
        assertEquals(expected, actual);
    }

    public static Node deleteNodes(Node head, int m, int n) {
        Node current = head;
        Node lastM = head;
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

    @ParameterizedTest
    @MethodSource(value = "inputs")
    public void deleteNodesForLoop(List<Integer> expected, Node input, int m, int n) {
        Node current = input;
        List<Integer> actual = new ArrayList<>();
        deleteNodes2(input, m, n);
        input.print();
        while (current != null) {
            actual.add(current.value);
            current = current.next;
        }
        assertEquals(expected, actual);
    }

    public static Node deleteNodes2(Node head, int m, int n) {
        Node pointer1 = head;
        Node pointer2;
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

class Node {

    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    public void print() {
        Node current = this;

        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return value + " -> ";
    }
}
