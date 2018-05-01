package com.ds.linkedlist;

import com.ds.common.Node;

public class SinglyLinkedList {
    private Node first;
    private int size = 0;

    public SinglyLinkedList() {
        this.first = null;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Node newNode = getNewNode(data);

        newNode.next = first;
        first = newNode;
        size++;
    }

    public void display() {
        Node current = first;
        System.out.println("[ ");
        while (current != null) {
            System.out.println(current.data + ", ");
            current = current.next;
        }
        System.out.println(" ]");
    }

    private Node getNewNode(int data) {
        Node node = new Node();
        node.data = data;
        return node;
    }

    public void iterativeReverse() {
        Node prev = null;
        for (Node current = this.first, next; current != null; current = next) {
            next = current.next;
            current.next = prev;
            prev = current;
        }
        this.first = prev;
    }

    /**
     * 1.l -> 2.l - > 3.l //-> null
     */
    public void recursiveReverseLL(Node p) {
        // stop recursion when first.next reached to null
        if (p.next == null) {
            this.first = p;
            return;
        }

        recursiveReverseLL(p.next);

        // When recursion stops and returns here for first time
        // the pointer p will be pointing to second last element of linked list
        // hence we are in position to reach to the last node and make it point to it.
        p.next.next = p;

        // once last pointer starts pointing to the second
        // last set second last pointer's next to null
        p.next = null;

    }

    public void exchangeFirstWith(int index) {
        Node t = first;
        Node nodePrev = null;
        if (index == 1)
            return;
        while (t != null && index > 1) {
            nodePrev = t;
            t = t.next;
            index--;
        }

        if (index > 1) {
            System.out.println("Error: Linked list is not that long");
            return;
        }

        Node second = first.next;
        nodePrev.next = first;
        first.next = t.next;
        t.next = second;

        first = t;
    }

    public Node findMid() {

        if (first == null || first.next == null) return first;
        Node fast = first.next;
        Node slow = first;

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        return slow;
    }

    public Node getHead() {
        return first;
    }

    public void setHead(Node node) {
        this.first = node;
    }

    public Node getNext(Node n) {
        return n.next;
    }

    public void setNext(Node a, Node b) {
        a.next = b;
    }

}
