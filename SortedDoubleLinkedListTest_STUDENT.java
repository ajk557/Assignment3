/*
 * Alex Kim
 * Professor Eivazi
 * Due Date: 3/15/25
 * Class: BasicDoubleLinkedListTest_STUDENT
 */
/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedListTest_STUDENT {
    SortedDoubleLinkedList<String> strList;
    SortedDoubleLinkedList<Integer> intList;
    
    Comparator<String> strComparator = String::compareTo;
    Comparator<Integer> intComparator = Integer::compare;
    
    @BeforeEach
	void setUp() throws Exception {
    	strList = new SortedDoubleLinkedList<>(strComparator);
    	intList = new SortedDoubleLinkedList<>(intComparator);

    	strList.add("CCC");
		strList.add("DDD");
		strList.add("BBB");
		strList.add("FFF");
		// BBB CCC DDD FFF

		intList.add(3);
		intList.add(5);
		intList.add(2);
		// 2 3 5
    }

	@AfterEach
	void tearDown() throws Exception {
		strList = null;
		intList = null;
	}

	@Test
	void testIterator() {
        ListIterator<String> strIterator = strList.iterator();
        assertTrue(strIterator.hasNext());
        assertEquals("BBB", strIterator.next());
        assertEquals("CCC", strIterator.next());
        
        ListIterator<Integer> intIterator = intList.iterator();
        assertTrue(intIterator.hasNext());
        assertEquals(2, intIterator.next());
        assertEquals(3, intIterator.next());
	}

	@Test
	void testRemove() {
		strList.remove("CCC", strComparator);
		assertEquals("BBB", strList.getFirst());
		
		strList.remove("BBB", strComparator);
		assertEquals("DDD", strList.getFirst());

		strList.remove("FFF", strComparator);
        assertEquals("DDD", strList.getLast());
        
        assertEquals(1, strList.getSize());

        intList.remove(3, intComparator);
		
		assertEquals(2, intList.getFirst());
        assertEquals(5, intList.getLast());
        assertEquals(2, intList.getSize());
	}

	@Test
	void testAdd() {
		strList.add("AAA");
		strList.add("EEE");

		assertEquals("AAA", strList.getFirst());
        assertEquals("FFF", strList.getLast());
        assertEquals(6, strList.getSize());

        intList.add(4);
		intList.add(1);

		assertEquals(1, intList.getFirst());
        assertEquals(5, intList.getLast());
        assertEquals(5, intList.getSize());
	}
	
	@Test
	void testAddToFront() {
		assertThrows(UnsupportedOperationException.class, () -> strList.addToFront("AAA"));
	}

	@Test
	void testAddToEnd() {
		assertThrows(UnsupportedOperationException.class, () -> intList.addToEnd(7));
	}
}
