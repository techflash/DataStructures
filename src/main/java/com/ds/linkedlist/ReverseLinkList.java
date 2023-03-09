package com.ds.linkedlist;

import com.ds.common.Node;

public class ReverseLinkList {
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.insertFirst(30);
        ll.insertFirst(20);
        ll.insertFirst(10);
        System.out.println("reverseList");
        Node head = reverseList(ll.getHead());
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
    }



    public static Node reverseList(Node head) {
        LinkedList ll = new LinkedList();
        ll.reverseList(head);
        return ll.getFirst();
    }

    static class LinkedList {
        Node first = null;

        public Node getFirst() {
            return first;
        }

        public Node reverseList(Node head) {

            // [10 [20], 20[30], 30[null]]
            if (head.next == null) {
                first = head;
                return head;
            }
            Node x = reverseList(head.next);
            x.next = head;
            head.next = null;
            return head;
        }
    }
}
