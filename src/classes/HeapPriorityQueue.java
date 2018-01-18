package classes;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import exceptions.EmptyPriorityQueueException;
import exceptions.NotComparableException;
import interfaces.Comparator;
import interfaces.Heap;
import interfaces.PriorityQueue;
import classes.Item;

/**
 * This Class HeapPriorityQueue implements a Priority Queue based on a Heap and its comparators.
 * *
 * since 1.1 - overall generic types used (Hint: Haenni)
 * since 1.2 - using LinkedList datastructure instead of ArrayList
 * since 1.3 - implemented Item<E> and ItemComparator for making Map and LinkedList obsolete
 * 
 * @author mosea3@bfh.ch
 * @version 1.3
 * @param <K> a Key
 * @param <E> an Element
 */
public class HeapPriorityQueue <K, E> implements PriorityQueue <K, E>{

	private Comparator<E> c; //do not use ArrayHeap comparator, use own ItemComparator
	private Comparator<Item> ci;
	Heap<Item> heap;
	private int n;
	
	public HeapPriorityQueue(Comparator<Integer> comparator){
		this.c = (Comparator<E>) comparator;
		this.ci = new ItemComparator();
		this.heap = new ArrayHeap<Item>(ci);
		n = 0;
	}
	
	/**
	 * Returns the current cardinal size of the Queue
	 * @return <b>Integer</b>: size of the Queue
	 */ 
	@Override
	public int size() {
		return n;
	}

	/**
	 * Returns, whether Queue is empty
	 * @return <b>boolean</b>: true if empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * enqueues an Item
	 * @param key key of Integer
	 * @param element an element
	 * @throws NotComparableException if key not Comparable
	 * @see interfaces.PriorityQueue#insertItem(java.lang.Object, java.lang.Object)
	 **/
	@Override
	public void insertItem(K key, E element) throws NotComparableException {
		if(!c.isComparable( element)) throw new NotComparableException();
		
		try{
			heap.insertElement(new Item<E>((int) key, element));
		}catch (NotComparableException e) {
		    throw e;
		}
		n++;
	}
	
	/**
	 * dequeues an Element and returns it
	 * @return E - returns an Element of Type E, which is to be removed of the Queue (eg. dequeued)
	 * @throws EmptyPriorityQueueException if there is nothing left to be dequeued
	 */
	@Override
	public E removeMin() throws EmptyPriorityQueueException {
		if(n<1) throw new EmptyPriorityQueueException(); //short notation for big effects
		Item minElement = heap.removeMin();
		n--;
		return (E) minElement.element;
	}
	
	/**
	 * returns the Key to the minimum value
	 * @throws EmptyPriorityQueueException if Queue is empty
	 */
	@Override
	public K minKey() throws EmptyPriorityQueueException {
		if(n<1) throw new EmptyPriorityQueueException();
		Item min = heap.minElement();
		Integer minKey;
		minKey = min.key;
		return (K) minKey;
	}
	
	/**
	 * returns the Element with minimum Index right next on queue
	 * @throws EmptyPriorityQueueException if Queue is empty
	 */
	@Override
	public E minElement() throws EmptyPriorityQueueException {
		if(n<1) throw new EmptyPriorityQueueException();
		Item minItem = heap.minElement();
		return (E) minItem.element;
	}

	
}