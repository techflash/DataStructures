package com.ds.linkedlist;

import com.ds.common.Node;

/**
 * Find merge poit of two linked list Problem and Solution:
 * http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 * 
 * @author Sunil
 *
 */
public class FindMergePoint {
	public static void main(String[] args) {
		// Create first and second linked list
		SinglyLinkedList singlyLinkedList1 = new SinglyLinkedList();
		SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();

		// Fill elements from 1 to 10 into first linked list
		for (int i = 0; i < 10; i++) {
			singlyLinkedList1.insertFirst(i);

		}

		// Fill elements from 11 to 15 in second linked list
		for (int i = 11; i <= 15; i++) {
			singlyLinkedList2.insertFirst(i);

		}

		// Merge two linked list such that second linked list's last node
		// points to the mid of first linked list
		Node temp2 = singlyLinkedList2.getHead();

		// Traverse to the end of second linked list
		while (temp2.next != null) {
			temp2 = temp2.next;
		}

		// Find mid of second linked list
		Node temp1 = singlyLinkedList1.getHead();
		Node mid = temp1;
		while (temp1.next != null) {

			temp1 = temp1.next.next;
			if (temp1 == null) {
				break;
			}
			mid = mid.next;
		}

		// Set the second linked list's last node point to mid of first element
		temp2.next = mid;

		System.out.println("Merge Point: ");
		System.out.println(findMergePoint(singlyLinkedList1.getHead(), singlyLinkedList1.getSize(),
				singlyLinkedList2.getHead(), singlyLinkedList2.getSize()));

	}

	/**
	 * Finds the merge point of two linked list
	 * 
	 * @param llist1
	 * @param llist2
	 * @return
	 */
	public static Node findMergePoint(Node llist1, int s1, Node llist2, int s2) {
		int r = Math.abs(s1 - s2);
		Node first = null;
		Node second = null;
		Node result = null;
		if (s1 > s2) {
			first = llist1;
			second = llist2;

		} else {
			first = llist2;
			second = llist1;

		}
		while (r > 0) {
			first = first.next;
			second = second.next;
			r--;
		}

		while (first != null) {
			if (second == null) {
				break;
			}
			if (first == second) {
				result = first;
			}
			first = first.next;
			second = second.next;
		}
		return result;

	}
}
