package edu.frcc.csc1061j;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyTreeMap<K extends Comparable<K>, V> implements Map<K, V>, Iterable<V> {
    private Node root = null;

    private int size = 0;

    private class Node {
        private K key;
        private V value;

        private Node left = null;
        private Node right = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
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
        return false;
    }

    // @Override
    // public boolean containsValue(Object value) {
    // // TODO Auto-generated method stub
    // return super.containsValue(value);
    // }

    @Override
    public V get(Object key) {
        Comparable<K> k = (Comparable<K>) key;

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
            return value;

        }
        Node parent = null;
        Node current = root;
        while (current != null) {
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
        return value;
    }

    @Override
    public V remove(Object key) {
        remove(root, key);
        // If there is one child, reassign to

        // TODO Auto-generated method stub
        return null;
    }

    private Node remove(Node node, Object key) {
        Comparable<K> k = (Comparable<K>) key;
        if (node == null) {
            return node;
        } else if (k.compareTo(node.key) < 0) { // Key is less than current node key.
            node.left = remove(node.left, key);
        } else if (k.compareTo(node.key) > 0) { // Key is greater than current node key.
            node.right = remove(node.right, key);
        } else {
            // Found it.
            if (node.right == null && node.left == null) { // If both children aren't there, set to null.
                node = null;
            }
            else if (node.left == null) { // If left is null, set node to right.
                node = node.right;
            }
            else if (node.right == null) { // If right is null, set node to left.
                node = node.left;
            }
            else {
                // 2 children.
                node.key = node.right.key;
                node.value = node.right.value;
                node.right = remove(node.right, node.right.key);
            }
        }
        return node;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public Iterator<V> iterator() {
        return new InOrderInterator();
    }

    private class InOrderInterator implements Iterator<V> {

        private Queue<V> list = new ArrayDeque<>();

        public InOrderInterator() {
            inOrder(root);
        }

        private void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            list.add(node.value);
            inOrder(node.right);
        }

        @Override
        public boolean hasNext() {
            if (!list.isEmpty()) {
                return true;
            }
            return false;
        }

        @Override
        public V next() {
            return list.remove();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsValue'");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAll'");
    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }

    @Override
    public Collection<V> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entrySet'");
    }
}