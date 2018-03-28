package com.ds.linkedlist;

public class ExchangeRandomLLNodeWithHead {

	public static void main(String[] args) {
		// Create first and second linked list
		SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();

		// Fill elements from 1 to 10 into first linked list
		for (int i = 0; i < 10; i++) {
			singlyLinkedList1.insertFirst(i);

		}

		singlyLinkedList1.display();

		singlyLinkedList1.exchangeFirstWith(10);

		System.out.println("==========" + "");
		singlyLinkedList1.display();

	}
}
