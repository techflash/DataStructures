package com.ds.linkedlist;

import com.ds.common.Node;

public class SinglyLinkedList {
	private Node first;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public SinglyLinkedList() {
		this.first = null;

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
