package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import classes.ArrayHeap;
import classes.AscendingIntegerComparator;
import classes.DescendingIntegerComparator;
import exceptions.EmptyHeapException;
import exceptions.NotComparableException;
import interfaces.Comparator;
import interfaces.Heap;

public class ArrayHeapTest {

	@Test
	public void test1() {

		Comparator<Integer> comparator = new AscendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(comparator);

		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());

		// 5
		heap.insertElement(5);
		assertEquals(1, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(5, (int) heap.minElement());

		// 5 8
		heap.insertElement(8);
		assertEquals(2, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(5, (int) heap.minElement());

		// 5 6 8
		heap.insertElement(6);
		assertEquals(3, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(5, (int) heap.minElement());

		// 5 6 6 8
		heap.insertElement(6);
		assertEquals(4, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(5, (int) heap.minElement());

		// 2 5 6 6 8
		heap.insertElement(2);
		assertEquals(5, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(2, (int) heap.minElement());

		// 2 2 5 6 6 8
		heap.insertElement(2);
		assertEquals(6, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(2, (int) heap.minElement());

		// 1 2 2 5 6 6 8
		heap.insertElement(1);
		assertEquals(7, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(1, (int) heap.minElement());

		// 1 2 2 5 6 6 8 9
		heap.insertElement(9);
		assertEquals(8, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(1, (int) heap.minElement());

		// 1 2 2 3 5 6 6 8 9
		heap.insertElement(3);
		assertEquals(9, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(1, (int) heap.minElement());

		// 2 2 3 5 6 6 8 9
		assertEquals(1, (int) heap.removeMin());
		assertEquals(8, heap.size());
		assertFalse(heap.isEmpty());

		// 2 3 5 6 6 8 9
		assertEquals(2, (int) heap.removeMin());
		assertEquals(7, heap.size());
		assertFalse(heap.isEmpty());

		// 3 5 6 6 8 9
		assertEquals(2, (int) heap.removeMin());
		assertEquals(6, heap.size());
		assertFalse(heap.isEmpty());

		// 5 6 6 8 9
		assertEquals(3, (int) heap.removeMin());
		assertEquals(5, heap.size());
		assertFalse(heap.isEmpty());

		// 6 6 8 9
		assertEquals(5, (int) heap.removeMin());
		assertEquals(4, heap.size());
		assertFalse(heap.isEmpty());

		// 6 8 9
		assertEquals(6, (int) heap.removeMin());
		assertEquals(3, heap.size());
		assertFalse(heap.isEmpty());

		// 8 9
		assertEquals(6, (int) heap.removeMin());
		assertEquals(2, heap.size());
		assertFalse(heap.isEmpty());

		// 9
		assertEquals(8, (int) heap.removeMin());
		assertEquals(1, heap.size());
		assertFalse(heap.isEmpty());

		//
		assertEquals(9, (int) heap.removeMin());
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
	}

	@Test
	public void test2() {

		Comparator<Integer> comparator = new DescendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(comparator);

		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());

		// 5
		heap.insertElement(5);
		assertEquals(1, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(5, (int) heap.minElement());

		// 8 5
		heap.insertElement(8);
		assertEquals(2, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.minElement());

		// 8 6 5
		heap.insertElement(6);
		assertEquals(3, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.minElement());

		// 8 6 6 5
		heap.insertElement(6);
		assertEquals(4, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.minElement());

		// 8 6 6 5 2
		heap.insertElement(2);
		assertEquals(5, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.minElement());

		// 8 6 6 5 2 2
		heap.insertElement(2);
		assertEquals(6, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.minElement());

		// 8 6 6 5 2 2 1
		heap.insertElement(1);
		assertEquals(7, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.minElement());

		// 9 8 6 6 5 2 2 1
		heap.insertElement(9);
		assertEquals(8, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(9, (int) heap.minElement());

		// 9 8 6 6 5 3 2 2 1
		heap.insertElement(3);
		assertEquals(9, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(9, (int) heap.minElement());

		// 8 6 6 5 3 2 2 1
		assertEquals(9, (int) heap.removeMin());
		assertEquals(8, heap.size());
		assertFalse(heap.isEmpty());

		// 6 6 5 3 2 2 1
		assertEquals(8, (int) heap.removeMin());
		assertEquals(7, heap.size());
		assertFalse(heap.isEmpty());

		// 6 5 3 2 2 1
		assertEquals(6, (int) heap.removeMin());
		assertEquals(6, heap.size());
		assertFalse(heap.isEmpty());

		// 5 3 2 2 1
		assertEquals(6, (int) heap.removeMin());
		assertEquals(5, heap.size());
		assertFalse(heap.isEmpty());

		// 3 2 2 1
		assertEquals(5, (int) heap.removeMin());
		assertEquals(4, heap.size());
		assertFalse(heap.isEmpty());

		// 2 2 1
		assertEquals(3, (int) heap.removeMin());
		assertEquals(3, heap.size());
		assertFalse(heap.isEmpty());

		// 2 1
		assertEquals(2, (int) heap.removeMin());
		assertEquals(2, heap.size());
		assertFalse(heap.isEmpty());

		// 1
		assertEquals(2, (int) heap.removeMin());
		assertEquals(1, heap.size());
		assertFalse(heap.isEmpty());

		//
		assertEquals(1, (int) heap.removeMin());
		assertEquals(0, heap.size());
		assertTrue(heap.isEmpty());
	}

	@Test
	public void test3() {

		Comparator<Integer> comparator = new AscendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(comparator);
		Random random = new Random();

		for (int i = 1; i < 1000000; i++) {
			heap.insertElement(random.nextInt(10000));
			assertEquals(i, heap.size());
		}
		int lastValue = heap.minElement();
		for (int i = 1; i < 1000000; i++) {
			int newValue = heap.removeMin();
			assertTrue(lastValue <= newValue);
			lastValue = newValue;
		}
		assertEquals(0, heap.size());
	}

	@Test
	public void test4() {

		Comparator<Integer> comparator = new DescendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(comparator);
		Random random = new Random();

		for (int i = 1; i < 1000000; i++) {
			heap.insertElement(random.nextInt(10000));
			assertEquals(i, heap.size());
		}
		int lastValue = heap.minElement();
		for (int i = 1; i < 1000000; i++) {
			int newValue = heap.removeMin();
			assertTrue(lastValue >= newValue);
			lastValue = newValue;
		}
		assertEquals(0, heap.size());
	}

	@Test
	public void test5() {

		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 1; i < 1000; i++) {
			list.add(random.nextInt(100));
		}
		ArrayHeap.heapSort(list, new AscendingIntegerComparator());
		int lastValue = list.get(0);
		for (Integer newValue : list) {
			assertTrue(lastValue <= newValue);
			lastValue = newValue;
		}
		assertEquals(999, list.size());
		ArrayHeap.heapSort(list, new DescendingIntegerComparator());
		lastValue = list.get(0);
		for (Integer newValue : list) {
			assertTrue(lastValue >= newValue);
			lastValue = newValue;
		}
		assertEquals(999, list.size());
	}

	@Test(expected = EmptyHeapException.class)
	public void test6() {
		Comparator<Integer> comparator = new DescendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(comparator);
		heap.minElement();
	}

	@Test(expected = EmptyHeapException.class)
	public void test7() {
		Comparator<Integer> comparator = new DescendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(comparator);
		heap.removeMin();
	}

	@Test(expected = NotComparableException.class)
	public void test8() {
		Comparator<Integer> comparator = new DescendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(comparator);
		heap.insertElement(null);
	}

}
