package edu.frcc.csc1061j.MyAVLTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import edu.frcc.csc1061j.MyAVLTree.MyAVLTree.Node;

public class MyAVLTree<K extends Comparable<K>, V>
		implements Map<K, V>, Iterable<edu.frcc.csc1061j.MyAVLTree.MyAVLTree.Node> {

	private int size = 0;
	private Node root = null;
	private ArrayList<Node> path;

	protected class Node {
		private K key;
		private V value;
		private Node left = null;
		private Node right = null;
		private int height;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.height = 0;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public int getHeight() {
			return height;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Comparable<? super K> k = (Comparable<? super K>) key;
		Node current = root;

		while (current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				current = current.right;
			} else {
				return current.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {

		if (root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			path = new ArrayList<Node>();
			updateHeight(root);
			return value;
		}

		Node parent = null;
		Node current = root;
		path.clear();

		while (current != null) {
			path.add(current);
			if (key.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			} else if (key.compareTo(current.key) > 0) {
				parent = current;
				current = current.right;
			} else {
				return null;
			}
		}

		Node newNode = new Node(key, value);
		if (key.compareTo(parent.key) < 0) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		size++;

		updateHeight(newNode);
		balancePath();
		return value;
	}

	private void updateHeight(Node node) {
		if (node.left == null && node.right == null) {
			node.height = 0;
		} else if (node.left == null) {
			node.height = 1 + node.right.height;
		} else if (node.right == null) {
			node.height = 1 + node.left.height;
		} else {
			node.height = 1 + Math.max(node.left.height, node.right.height);
		}
	}

	private int balanceFactor(Node current) {
		int balanceFactor = 0;
		if (current.right == null) {
			balanceFactor = -current.height;
		} else if (current.left == null) {
			balanceFactor = current.height;
		} else {
			balanceFactor = current.right.height - current.left.height;
		}
		return balanceFactor;
	}

	private void balancePath() {
		for (int i = path.size() - 1; i >= 0; i--) {
			Node current = path.get(i);
			updateHeight(current);
			Node parent = null;
			if (i > 0) {
				parent = path.get(i - 1);
			}
			switch (balanceFactor(current)) {
				case -2:
					if (balanceFactor(current.left) <= 0) {
						balanceLL(current, parent); // LL rotation
					} else {
						balanceLR(current, parent); // LR rotation
					}
					break;
				case 2:
					if (balanceFactor(current.right) >= 0) {
						balanceRR(current, parent); // RR rotation
					} else {
						balanceRL(current, parent); // RL rotation
					}
					break;
			}

		}
	}

	private void balanceLL(Node node, Node parent) {
		Node leftNode = node.left;
		if (node == root) {
			root = leftNode;
		} else {
			if (parent.left == node) {
				parent.left = leftNode;
			} else {
				parent.right = leftNode;
			}
		}
		node.left = leftNode.right;
		leftNode.right = node;

		updateHeight(node);
		updateHeight(leftNode);
	}

	private void balanceLR(Node node, Node parent) {
		Node leftNode = node.left;
		Node childNode = leftNode.right;

		if (node == root) {
			root = childNode;
		} else {
			if (parent.left == node) {
				parent.left = childNode;
			} else {
				parent.right = childNode;
			}
		}
		node.left = childNode.right;
		leftNode.right = childNode.left;

		childNode.left = leftNode;
		childNode.right = node;

		updateHeight(node);
		updateHeight(leftNode);
		updateHeight(childNode);
	}

	private void balanceRR(Node node, Node parent) { // If right-right rotation is needed...
		// Local variables.
		Node rightNode = node.right;

		// Checks nodes.
		if (node == root) {
			root = rightNode;
		} else {
			if (parent.right == node) {
				parent.right = rightNode;
			} else {
				parent.left = rightNode;
			}
		}
		node.right = rightNode.left;
		rightNode.left = node;

		// Update heights.
		updateHeight(node);
		updateHeight(rightNode);
	}

	private void balanceRL(Node node, Node parent) { // If right-left rotation is needed...
		// Local variables.
		Node rightNode = node.right;
		Node childNode = rightNode.left;

		// Checks nodes.
		if (node == root) {
			root = childNode;
		} else {
			if (parent.right == node) {
				parent.right = childNode;
			} else {
				parent.left = childNode;
			}
		}
		node.right = childNode.left;
		rightNode.left = childNode.right;

		childNode.right = rightNode;
		childNode.left = node;

		// Update heights.
		updateHeight(node);
		updateHeight(rightNode);
		updateHeight(childNode);
	}

	@Override
	public V remove(Object key) {
		Comparable<? super K> k = (Comparable<? super K>) key;
		V value = null;

		path.clear();

		// Find node
		Node current = root;
		Node parent = null;
		while (current != null) {
			path.add(current);
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			} else if (k.compareTo(current.key) > 0) {
				parent = current;
				current = current.right;
			} else {
				value = current.value;
				break;
			}
		}

		// Case 1: No children
		if (current.left == null && current.right == null) {
			if (parent.left == current) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 3: One child
		else if (current.left == null) {
			if (parent.left == current) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.right == null) {
			if (parent.left == current) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		}

		if (current.left != null && current.right != null) {
			Node rightMostNode = current.left;
			Node parentOfRightMost = current;
			while (rightMostNode.right != null) {
				parentOfRightMost = rightMostNode;
				rightMostNode = rightMostNode.right;
			}

			current.key = rightMostNode.key;
			current.value = rightMostNode.value;

			if (parentOfRightMost == current) {
				current.left = rightMostNode.left;
			} else {
				parentOfRightMost.right = null;
			}
		}

		balancePath();
		return value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		return new InOrderIterator();
	}

	private class InOrderIterator implements Iterator<Node> {
		private ArrayList<Node> list = new ArrayList<>();
		private int currentIndex = 0;

		public InOrderIterator() {
			inorder(root);
		}

		private void inorder(Node node) {
			if (node == null) {
				return;
			}
			inorder(node.left);
			list.add(node);
			inorder(node.right);
		}

		@Override
		public boolean hasNext() {
			return (currentIndex < list.size());
		}

		@Override
		public Node next() {
			return list.get(currentIndex++);
		}

	}
}
