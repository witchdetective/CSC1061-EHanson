import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* All code in this file is untouched as it is was from class.
This file is included for its use in the MyDoubleLinkedList class. */ 

public class MyLinkedList<E> implements List<E> {
	private Node head;
	private int size;
	
	private class Node {
		private E data;
		private Node next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	public MyLinkedList() {
		head = null;
		size = 0;
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
	public boolean contains(Object o) {
		if(indexOf(o) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;
		for (Node node = head; node != null; node = node.next) {
			array[i] = node.data;
			i++;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		Node newNode = new Node(e);
		if (head == null) {
			head = newNode;
		}
		else {
			Node node = null;
			for (node = head; node.next != null; node = node.next) {
				
			}
			node.next = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public E get(int index) {
		Node node = getNode(index);
		return node.data;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		Node newNode = new Node(element);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
		else {
			Node node = getNode(index - 1);
			newNode.next = node.next;
			node.next = newNode;
		}
		size++;
		
	}

	@Override
	public E remove(int index) {
		E data = get(index);
		if (index == 0) {
			head = head.next;
		}
		else {
			Node node = getNode(index - 1);
			node.next = node.next.next;
		}
		size--;
		return data;
	}

	@Override
	public int indexOf(Object o) {
		Node node = head;
		for (int i = 0; i < size; i++) {
			if (o.equals(node.data)) {
				return i;
			}
			node = node.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node node = head;
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (o.equals(node.data)) {
				index = i;
			}
			node = node.next;
		}
		return index;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
