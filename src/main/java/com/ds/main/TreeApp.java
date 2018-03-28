package com.ds.main;

import com.ds.tree.BST;

public class TreeApp {
	public static void main(String[] args) {
		BST bst = new BST();

		for (int i = 0; i < 10; i++) {
			bst.insert(i);
		}
		
		System.out.println(bst.inorderPredecessor(5));
	}
}
