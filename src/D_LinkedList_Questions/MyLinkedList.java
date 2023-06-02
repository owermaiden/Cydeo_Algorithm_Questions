package D_LinkedList_Questions;

public class MyLinkedList {
    public ListNode head;
    public ListNode tail;

    public void add(int n) {
        ListNode newNode = new ListNode(n);
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}