package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import classes.AscendingIntegerComparator;
import classes.DescendingIntegerComparator;
import classes.HeapPriorityQueue;
import classes.Item;
import classes.ItemComparator;
import exceptions.EmptyPriorityQueueException;
import exceptions.NotComparableException;
import interfaces.Comparator;
import interfaces.PriorityQueue;

public class HeapPriorityQueueTest {

	@Test
	public void test1(){
		Comparator<Integer> comparator = new AscendingIntegerComparator();
		PriorityQueue<Integer, String> pq = new HeapPriorityQueue<Integer, String>(comparator);
		
		assertEquals(0, pq.size());		
		assertTrue(pq.isEmpty());

		// 5
		pq.insertItem(5, "5");
		assertEquals(1, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(5, (int) pq.minKey());
		assertEquals("5", pq.minElement());

		// 5 8
		pq.insertItem(8, "8");
		assertEquals(2, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(5, (int) pq.minKey());	
		assertEquals("5", pq.minElement());

		// 5 6 8
		pq.insertItem(6, "6");
		assertEquals(3, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(5, (int) pq.minKey());
		assertEquals("5", pq.minElement());

		// 5 6 6 8
		pq.insertItem(6, "6");
		assertEquals(4, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(5, (int) pq.minKey());
		assertEquals("5", pq.minElement());

		// 2 5 6 6 8
		pq.insertItem(2, "2");
		assertEquals(5, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(2, (int) pq.minKey());
		assertEquals("2", pq.minElement());

		// 2 2 5 6 6 8
		pq.insertItem(2, "2");
		assertEquals(6, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(2, (int) pq.minKey());
		assertEquals("2", pq.minElement());

		// 1 2 2 5 6 6 8
		pq.insertItem(1, "1");
		assertEquals(7, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(1, (int) pq.minKey());
		assertEquals("1", pq.minElement());

		// 1 2 2 5 6 6 8 9
		pq.insertItem(9, "9");
		assertEquals(8, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(1, (int) pq.minKey());
		assertEquals("1", pq.minElement());
		
		

		// 1 2 2 3 5 6 6 8 9
		pq.insertItem(3, "3");
		assertEquals(9, pq.size());
		assertFalse(pq.isEmpty());
		assertEquals(1, (int) pq.minKey());
		assertEquals("1", pq.minElement());

		// 2 2 3 5 6 6 8 9
		assertEquals("1", pq.removeMin());
		assertEquals(8, pq.size());
		assertFalse(pq.isEmpty());
	
		// 2 3 5 6 6 8 9
		assertEquals("2", pq.removeMin());
		assertEquals(7, pq.size());
		assertFalse(pq.isEmpty());

		// 3 5 6 6 8 9
		assertEquals("2", pq.removeMin());
		assertEquals(6, pq.size());
		assertFalse(pq.isEmpty());

		// 5 6 6 8 9
		assertEquals("3", pq.removeMin());
		assertEquals(5, pq.size());
		assertFalse(pq.isEmpty());

		// 6 6 8 9
		assertEquals("5", pq.removeMin());
		assertEquals(4, pq.size());
		assertFalse(pq.isEmpty());

		// 6 8 9
		assertEquals("6", pq.removeMin());
		assertEquals(3, pq.size());
		assertFalse(pq.isEmpty());

		// 8 9
		assertEquals("6", pq.removeMin());
		assertEquals(2, pq.size());
		assertFalse(pq.isEmpty());

		// 9
		assertEquals("8", pq.removeMin());
		assertEquals(1, pq.size());
		assertFalse(pq.isEmpty());

		
		assertEquals("9", pq.removeMin());
		assertEquals(0, pq.size());
		assertTrue(pq.isEmpty());
	}

	@Test
	public void test2() {
		
		Comparator<Integer> comparator = new AscendingIntegerComparator();
		PriorityQueue<Integer, String> pq = new HeapPriorityQueue<Integer, String>(comparator);
		Random random = new Random();
		
		for (int i=1; i<1000000; i++) {
			pq.insertItem(random.nextInt(10000), "Hello");
			assertEquals("Hello", pq.minElement());
			assertEquals(i, pq.size());
		}
		for (int i=1; i<1000000; i++) {
			assertEquals("Hello", pq.removeMin());
		}
		assertEquals(0, pq.size());
	}
	
	
	@Test(expected = EmptyPriorityQueueException.class)
	public void test3() {
		Comparator<Integer> comparator = new AscendingIntegerComparator();
		PriorityQueue<Integer, String> pq = new HeapPriorityQueue<Integer, String>(comparator);
		pq.removeMin();
	}
	
	@Test(expected = EmptyPriorityQueueException.class)
	public void test4() {
		Comparator<Integer> comparator = new AscendingIntegerComparator();
		PriorityQueue<Integer, String> pq = new HeapPriorityQueue<Integer, String>(comparator);
		pq.minElement();
	}
	
	@Test(expected = NotComparableException.class)
	public void test8() {
		Comparator<Integer> comparator = new DescendingIntegerComparator();
		PriorityQueue<Integer, String> pq = new HeapPriorityQueue<Integer, String>(comparator);
		pq.insertItem(null, null);
	}
	
	
}
