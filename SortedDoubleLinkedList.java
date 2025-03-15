/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 3/15/25
 * Class: SortedDoubleLinkedList
 */

import java.util.NoSuchElementException;

//import BasicDoubleLinkedList.Node;

import java.util.ListIterator;
import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

	/*
	 * Creates an empty list that is associated with the specified comparator.
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		this.comparator = compareableObject;
	}
	
	/*Inserts the specified element at the correct position in the sorted list
	 * (depends on the Comparator).
	 */
	public void add(T data) {
		Node myNode = new Node(data);
		Node current = head;
		
		while (current != null) {
			 // equal or smaller than head. 
			 // insert at the front
			 if (comparator.compare(data, head.data) <= 0) {
				 myNode.next = head;
				 head.prev = myNode;
				 head = myNode;
				 break;
			 }
			 // equal or bigger than tail. 
			 // insert at the end
			 else if (comparator.compare(data, tail.data) >= 0) {
				 myNode.prev = tail;
				 tail.next = myNode;
				 tail = myNode;
				 break;
			 }
			 // compare then insert at correct position
			 // insert in the middle
			 else if (comparator.compare(data, current.data) <= 0) {
				 myNode.next = current;
				 myNode.prev = current.prev;
				 
				 current.prev.next = myNode;
				 current.prev = myNode;
	             break;
			 }
			 
			 current = current.next;
		}
		
		// cover case when list is empty
		if (current == null) {
			head = myNode;
			tail = myNode;
		}
		size++;
	}
	
	/*
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated using
	 * the message "Invalid operation for sorted list."
	 */
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/*
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated
	 * using the message "Invalid operation for sorted list."
	 */
	@Override
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/*
	 * Implements the iterator by calling the super class iterator method.
	 */
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	/*
	 * Implements the remove operation by calling the super class remove method.
	 */
	@Override
	public BasicDoubleLinkedList<T>.Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
}
