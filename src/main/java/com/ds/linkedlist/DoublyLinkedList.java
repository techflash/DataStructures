package com.ds.linkedlist;

import com.ds.common.Node;

public class DoublyLinkedList {
	private Node first;
	private Node last;

	public DoublyLinkedList() {
		this.first = null;
		this.last = null;

	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Node newNode = getNewNode(data);

		if (isEmpty()) {
			last = newNode;
		} else {
			first.prev = newNode;
		}

		newNode.next = first;
		first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = getNewNode(data);
		if (isEmpty()) {
			first = newNode;

		} else {
			last.next = newNode;
			newNode.prev = last;
		}
		last = newNode;
	}

	public Node deleteLast() {
		Node temp = last;
		if (isEmpty()) {
			return null;
		} else {
			last = last.prev;
			last.next = null;

		}
		return temp;
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

	public void sortLinkedList() {
		Node current = first, next = null, prev = null;
		last = first;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		first = prev;

	}

	/**
	 * 1.l -> 2.l - > 3.l //-> null
	 */
	public void recursiveSortLL(Node p) {
		// stop recursion when first reached to null
		if (p.next == null) {
			this.first = p;
			return;
		}

		// assign the returned value to first next
		recursiveSortLL(p.next);
		p.next.next = p;
		p.next = null;

	}

	public Node getHead() {
		return first;
	}

	public void setHead(Node node) {
		this.first = node;
	}

	/**
	 * Write program to implement the merging of two sorted list
	 * 
	 * @param ll1
	 * @param ll2
	 */
	public void mergeSortedLL(Node ll1, Node ll2) {
		Node t1 = ll1, t2 = ll2;

		while (t2 != null) {
			Node temp = t1;
			while (temp != null) {
				if (temp.data <= ll2.data) {
					Node nn = new Node();
					nn.data = temp.data;
					nn.next = ll2;
					ll2 = nn;
				}
				if (temp.data >= t1.data) {
					Node nn = new Node();
					nn.data = temp.data;
					nn.next = temp.next;
					temp.next = nn;
				}
				t1 = t1.next;
			}

			t2 = t2.next;
		}

	}

}
