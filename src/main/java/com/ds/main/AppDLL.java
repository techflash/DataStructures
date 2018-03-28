package com.ds.main;

import com.ds.linkedlist.DoublyLinkedList;

public class AppDLL {
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();

		dll.insertFirst(100);
		dll.insertFirst(101);
		dll.insertFirst(102);

		dll.insertLast(1111);

		System.out.println("deleted: " + dll.deleteLast().data);
		System.out.println("List now");
		dll.display();

		System.out.println("Sorted!");

		dll.recursiveSortLL(dll.getHead());

		dll.display();
	}

}
