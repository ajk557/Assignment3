/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 3/15/25
 * Class: BasicDoubleLinkedListTest_STUDENT
 */
/**
 * You must implement the following test case methods
 */
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Integer> linkedInteger;

	@BeforeEach
	void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<>();
		linkedString.addToEnd("C");
		linkedString.addToFront("B");
		linkedString.addToEnd("D");
		linkedString.addToEnd("E");
		// B C D E
		
		linkedInteger = new BasicDoubleLinkedList<>();
		linkedInteger.addToFront(3);
		linkedInteger.addToEnd(4);
		linkedInteger.addToFront(2);
		// 2 3 4 
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedString = null;
		linkedInteger = null;
	}

	@Test
	void testGetSize() {
		assertEquals(4,linkedString.getSize());
		assertEquals(3,linkedInteger.getSize());
	}

	@Test
	void testAddToEnd() {
	    linkedString.addToEnd("F");
	    assertEquals("F", linkedString.getLast());
	    assertEquals(5, linkedString.getSize());

	    linkedInteger.addToEnd(5);
	    assertEquals(5, linkedInteger.getLast());
	    assertEquals(4, linkedInteger.getSize());
	}

	@Test
	void testAddToFront() {
	    linkedString.addToFront("A");
	    assertEquals("A", linkedString.getFirst());
	    assertEquals(5, linkedString.getSize());

	    linkedInteger.addToFront(1);
	    assertEquals(1, linkedInteger.getFirst());
	    assertEquals(4, linkedInteger.getSize());
	}

	@Test
	void testGetFirst() {
		assertEquals("B",linkedString.getFirst());
		assertEquals(2,linkedInteger.getFirst());
	}

	@Test
	void testGetLast() {
		assertEquals("E",linkedString.getLast());
		assertEquals(4,linkedInteger.getLast());
	}

	@Test
	void testIterator() {
	    ListIterator<String> strIterator = linkedString.iterator();
	    assertTrue(strIterator .hasNext());
	    assertEquals("B", strIterator .next());
	    assertEquals("C", strIterator .next());

	    ListIterator<Integer> intIterator = linkedInteger.iterator();
	    assertEquals(2, intIterator.next());
	    assertEquals(3, intIterator.next());
	    assertTrue(intIterator.hasPrevious());
	}

	@Test
	void testRemove() {
	    linkedString.remove("B", String::compareTo);
	    assertEquals(3, linkedString.getSize());
	    assertEquals("C", linkedString.getFirst());
	    
	    linkedInteger.remove(4, Integer::compare);
	    assertEquals(2, linkedInteger.getSize());
	    assertEquals(3, linkedInteger.getLast());
	}

	@Test
	void testRetrieveFirstElement() {
	    assertEquals("B", linkedString.retrieveFirstElement());
	    assertEquals(3, linkedString.getSize());

	    assertEquals(2, linkedInteger.retrieveFirstElement());
	    assertEquals(2, linkedInteger.getSize());
	}

	@Test
	void testRetrieveLastElement() {
	    assertEquals("E", linkedString.retrieveLastElement());
	    assertEquals(3, linkedString.getSize());

	    assertEquals(4, linkedInteger.retrieveLastElement());
	    assertEquals(2, linkedInteger.getSize());
	}

	@Test
	void testToArrayList() {
	    ArrayList<String> stringList = linkedString.toArrayList();
	    assertEquals(4, stringList.size());
	    assertEquals("B", stringList.get(0));
	    assertEquals("C", stringList.get(1));
	    assertEquals("D", stringList.get(2));
	    assertEquals("E", stringList.get(3));

	    ArrayList<Integer> intList = linkedInteger.toArrayList();
	    assertEquals(3, intList.size());
	    assertEquals(2, intList.get(0));
	    assertEquals(3, intList.get(1));
	    assertEquals(4, intList.get(2));
	}

}
