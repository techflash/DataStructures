package com.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Represents a binary search tree
 * 
 * @author Sunil
 *
 */
public class BST {
	private boolean isBst(Node root, long minValue, long maxValue) {
		if (root == null)
			return true;

		else return root.data > minValue && root.data < maxValue && isBst(root.left, minValue, root.data)
				&& isBst(root.right, root.data, maxValue);

	}

	private Node root = null;

	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);

		} else if (root.data >= data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	/**
	 * Insert data into tree
	 * 
	 * @param data
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * 
	 */
	public void listNodeAtSameDepth() {
		Node temp = this.root;

		Queue<Node> queue;
		queue = new ArrayDeque<>();

		queue.offer(temp);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(" " + current.data);

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
	}

	private long max(long a, long b) {
		return a > b ? a : b;
	}

	private long findHeight(Node root) {
		if (root == null)
			return -1;
		else {
			return max(findHeight(root.left), findHeight(root.right)) + 1;
		}
	}

	/**
	 * Returns the height of a tree
	 * 
	 * @return height
	 */
	public long findHeight() {
		return findHeight(this.root);
	}

	/**
	 * Checks whether a tree is BST or not
	 * 
	 * @return
	 */
	public boolean isBst() {
		return isBst(this.root, -10000000, 100000000);
	}

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node delete(Node root, int data) {
		if (root == null)
			return root;
		else if (root.data > data)
			root.left = delete(root.left, data);
		else if (root.data < data) {
			root.right = delete(root.right, data);
		} else {
			// found you... will delete you now
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.right == null) {
				root = root.left;
			} else if (root.left == null) {
				root = root.right;
			} else {
				// Node temp = ;
				root.data = findMin(root.right).data;
				root.right = delete(root.right, root.data);
			}

		}

		return root;
	}

	public Node findMin() {
		return findMin(this.root);
	}

	private Node findMin(Node root) {
		if (root == null)
			return null;
		else if (root.left == null)
			return root;
		else
			return findMin(root.left);
	}

	private Node findMax(Node root) {
		if (root == null)
			return null;
		else if (root.right == null)
			return root;
		else
			return findMin(root.right);
	}

	public void delete(int data) {

		delete(this.root, data);
	}

	/**
	 * Inorder successor
	 * 
	 * @param data
	 * @return
	 */
	public Node findInOrderSuccessor(int data) {
		return inorderSuccessor(find(data));
	}

	public Node find(int data) {
		return find(this.root, data);
	}

	private Node find(Node root, int data) {
		if (root == null)
			return null;
		else if (root.data > data) {
			return find(root.left, data);

		} else if (root.data < data) {
			return find(root.right, data);
		} else {
			return root;
		}

	}

	/**
	 * Finds inorder successor. In order successor in a tree is a node which
	 * comes next when traversing tree in inorder fashion
	 * 
	 * @param current
	 * @return
	 */
	private Node inorderSuccessor(Node current) {

		if (current == null || root == null)
			return null;
		else {
			// If given node has right child then in order successor
			// will be in right of tree. and that too the min node
			if (current.right != null)
				return findMin(current.right);
			else {
				/**
				 * Else, inorder successor will be in left of current node. To
				 * find the inorder successor in left node we have to traverse
				 * from root to the node. because inorder successor of a node in
				 * left is immediate parent.
				 */
				Node successor = null;
				Node predecessor = this.root;

				// Keep traversing until we have not reached to current node
				while (predecessor != current) {

					// If current smaller then successor should be in left
					// subtree
					if (current.data < predecessor.data) {

						// In order successor is going to be greater than
						// current node, so probably current predecessor could
						// be successor
						successor = predecessor;

						// go left
						predecessor = predecessor.left;
					} else { // else go right
						predecessor = predecessor.right;
					}

				}

				return successor;
			}
		}

	}

	public Node inorderPredecessor(int data) {
		return inorderPredecessor(find(data));
	}

	private Node inorderPredecessor(Node current) {

		if (current == null || root == null)
			return null;
		else {
			// If given node has left child then in order predecessor
			// will be max node in left subtree
			if (current.left != null)
				return findMax(current.left);
			else {
				/**
				 */
				Node successor = this.root;
				Node predecessor = null;

				// Keep traversing until we have not reached to current node
				while (successor != current) {
					if (current.data > successor.data) {
						predecessor = successor;
						successor = successor.right;
					} else { // else go left
						successor = successor.left;
					}

				}

				return predecessor;
			}
		}

	}

}
