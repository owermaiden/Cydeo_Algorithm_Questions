package A_InterviewPrep;

import java.util.Objects;

public class Stack<T> {

    private Node<T> top;
    // Not really needing 'head':
    // private StackNode<T> head;
    private int size;

    // Added 'private'. Now even the code in the same package cannot get to
    // 'StackNode':
    private static class Node<T> {

        private T value;
        private Node<T> next;

        // Really do not need 'public' since this class is visible ONLY in the
        // 'Stack':
        /*public*/ Node(T val) {
            this.value = val;
            // JVM already initializes reference fields to 'null' by default:
            // this.next = null;
        }

        // Same argument against use of 'public' as in the constructor:
        /*public*/ T getValue() {
            return value;
        }

        /*public*/ Node<T> getNext() {
            return next;
        }

        /*public*/ void setNext(Node<T> nextNode) {
            this.next = nextNode;
        }

        // '@Override' would not hurt here. If you somehow mistyped the name of
        // the method being override, and it has a @Override, compiler will
        // notify you:
        @Override
        public String toString() {
            // You can do just:
            return Objects.toString(value);
            // if (value == null) {
            //     return "null";
            // }
            // return value.toString();
        }
    }

    // In this case you can omit the constructor altogether. JVM initializes
    // reference fields to 'null' by default, and integer fields to zero by
    // default:
    // public StackImplementation() {
    //     head = new StackNode(0);
    //     size = 0;
    //     top = head;
    // }

    public void push(T val) {
        // Since Java 7, you can do "diamond inference":
        Node<T> cur = new Node<>(val);
        // StackNode<T> cur = new StackNode<T>(val);
        cur.setNext(top);
        top = cur;
        size++;
        // You can remove the 'return' whenever it is the very last statement of
        // a method:
        // return;
    }

    // peek() does not return the topmost node but rather its value:
    public T peek() {
        checkNotEmpty();
        return top.getValue();
    }

    public T pop() {
        checkNotEmpty();
        // if (size == 0 || top.getNext() == null) {
        //     throw new java.util.NoSuchElementException();
        // }

        T poppedElement = top.getValue();
        // Can omit 'this' here:
        top = top.getNext();
        // this.top = this.top.getNext();
        size--;
        return poppedElement;
    }

    public void clear() {
        top = null;
        size = 0;
        // The rest is up to garbage collector.
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[").append(top.getValue());
        Node<T> node = top.getNext();

        while (node != null) {
            sb.append(" -> ").append(node.getValue());
            node = node.getNext();
        }

        return sb.append("]").toString();
    }

    private void checkNotEmpty() {
        if (size == 0) {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.println(st.size());
        st.push(1);
        st.push(10);
        st.push(100);
        st.push(null);
        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
        st.clear();
        System.out.println(st.isEmpty());
        System.out.println(st.size());
        st.peek(); // Exception!
    }
}
