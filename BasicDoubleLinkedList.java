/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 3/15/25
 * Class: BasicDoubleLinkedList
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> extends Object implements Iterable<T> {
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	/*
	 * Constructor to set to initialize head, tail and size to null, null and 0
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/*
	 * Node inner class
	 */
	public class Node {
		public T data;
		public Node next;
		public Node prev;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	/*
	 * DoubleLinkedListIterator inner class
	 */
	private class DoubleLinkedListIterator implements ListIterator<T> {
		private Node current;
		
		DoubleLinkedListIterator() {
			this.current = head;
		}
		
		public boolean hasNext() {
			if (current != null && current.next != null) {
				return true;
			}
			return false;
		}
		
		public T next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = current.data;
			current = current.next;
			return data;
		}
		
		public boolean hasPrevious() {
			if (current != null && current.prev != null) {
				return true;
			}
			return false;
		}
		
		public T previous() throws NoSuchElementException {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			T data = current.data;
			current = current.next;
			return data;
		}
		
		// Throw exception
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public void add(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public void set(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}

	
	/*
	 * Returns the number of nodes in the list.
	 */
	public int getSize() {
		return size;
	}
	
	/*
	 * Adds an element to the end of the list and updated the size of the list
	 */
	public void addToEnd(T data) {
		Node myNode = new Node(data);
		if (tail != null) {
			tail.next = myNode;
			myNode.prev = tail;
			tail = myNode;
		}
		else {
			head = myNode;
			tail = myNode;
		}
		size++;
	}
	
	/*
	 * Adds element to the front of the list and updated the size of the list
	 */
	public void addToFront(T data) {
		Node myNode = new Node(data);
		if (head != null) {
			head.prev = myNode;
			myNode.next = head;
			head = myNode;
		}
		else {
			head = myNode;
			tail = myNode;
		}
		size++;
	}
	
	/*
	 * Returns but does not remove the first element from the list.
	 * If there are no elements the method returns null.
	 */
	public T getFirst() {
		if (head != null) {
			return head.data;
		}
		else {
			return null;
		}
	}

	/*
	 * Returns but does not remove the last element from the list.
	 * If there are no elements the method returns null. 
	 */
	public T getLast() {
		if (tail != null) {
			return tail.data;
		}
		else {
			return null;
		}
	}
	
	/*
	 * This method returns an object of the DoubleLinkedListIterator. 
	 * (the inner class that implements java's ListIterator interface)
	 */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator();
	}
	
	/*
	 * Removes the first instance of the targetData from the list. 
	 * Notice that you must remove the elements by performing a 
	 * single traversal over the list. 
	 * You may not use any of the other retrieval methods associated
	 *  with the class in order to complete the removal process.
	 */
	public Node remove(T targetData, Comparator<T> comparator) {
		Node current = head;
		while (current != null) {
			if (comparator.compare(current.data, targetData) == 0) {
				if (current == head) {
					head = head.next;
					
					if (head != null) {
						head.prev = null;
					}
				}
				else if (current == tail) {
					tail = tail.prev;
					
					if (tail != null) {
						tail.next = null;
					}
				}
				else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				size--;
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	/*
	 * Removes and returns the first element from the list. 
	 * If there are no elements the method returns null. 
	 */
	public T retrieveFirstElement() {
		if (head == null) {
			return null;
		}
		
		T myData = head.data;
		head = head.next;
		
		if (head != null) {
			head.prev = null;
		}
		else {
			tail = null;
		}
		
		size--;
		return myData;
	}
	
	/*
	 * Removes and returns the last element from the list. 
	 * If there are no elements the method returns null. 
	 */
	public T retrieveLastElement() {
		if (tail == null) {
			return null;
		}
		
		T myData = tail.data;
		tail = tail.prev;
		
		if (tail != null) {
			tail.next = null;
		}
		else {
			head = null;
		}
		
		size--;
		return myData;		
	}
	
	/*
	 * Returns an arraylist of all the items in the Double Linked list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> myList = new ArrayList<>();
		Node current = head;
		while (current != null) {
			myList.add(current.data);
			current = current.next;
		}
		return myList;
	}

}
