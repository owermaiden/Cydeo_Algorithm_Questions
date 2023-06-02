package D_LinkedList_Questions.Remove_LinkedList_Elements;

class MyLinkedList {
    ListNode head;
    ListNode tail;

    void add(int n) {
        ListNode newNode = new ListNode(n);
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}