package com.ds.linkedlist;

public class AppSLL {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();

		sll.insertFirst(100);
		sll.insertFirst(101);
		sll.insertFirst(102);
		System.out.println("List now");
		sll.display();

		sll.recursiveReverseLL(sll.getHead());

		System.out.println("After recursive reverse :");
		sll.display();

		// Add new element
		sll.insertFirst(10);
		sll.iterativeReverse();

		System.out.println("After iterative reverse :");
		sll.display();

	}

}
