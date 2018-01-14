package classes;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.EmptyPriorityQueueException;
import exceptions.NotComparableException;
import interfaces.Comparator;
import interfaces.Heap;
import interfaces.PriorityQueue;

/**
 * 
 * @author andy.moser
 *
 * @description This Class HeapPriorityQueue implements a Priority Queue based on a Heap class and its comparators.
 * @param <K> a Key of Integer
 * @param <E> an Element
 */
public class HeapPriorityQueue <K, E> implements PriorityQueue <K, E>{

	private E[] elements;
	private K[] keys;
	private ArrayList elements2;
	
	Comparator<Integer> comparator = null;
	Heap<Integer> heap =null;
	private int n;
	
	public HeapPriorityQueue(Comparator<Integer> comparator){
		Comparator<Integer> c = new AscendingIntegerComparator();
		Heap<Integer> heap = new ArrayHeap<Integer>(c);
		n = 0;
	}
	
	/**
	 * Returns the size of the Queue
	 * @return <b>Integer</b>: size of the Queue
	 */
	@Override
	public int size() {
		return n;
	}

	/**
	 * Returns, if Queue is empty
	 * @return <b>boolean</b>: true if emtpy, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return n == 0;
	}
	
	/*
	 * inserts an Item (eg. queues an Item)
	 * @param K key of Integer
	 * @param E an element
	 * @throws NotComparableException if key not Comparable
	 * @see interfaces.PriorityQueue#insertItem(java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insertItem(K key, E element) throws NotComparableException {
		heap.insertElement((int) key);
		elements2.add((int) key, element);
		n++;
	}

	/**
	 * dequeues an Element and returns it
	 * @return <b>E</b>: returns an Element of Type E, which is to be removed of the Queue (eg. dequeued)
	 * @throws EmptyPriorityQueueExeption if there is nothing left to be dequeued
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E removeMin() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		if(n<1){
			throw new EmptyPriorityQueueException();
		}
		int key = (int) minKey();
		E el = (E) elements2.get(key);
		n--;
		return el;
	}

	@SuppressWarnings("unchecked")
	@Override
	public K minKey() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		K key = (K) heap.removeMin();
		return key;
	}

	@Override
	public E minElement() throws EmptyPriorityQueueException {
		// TODO Auto-generated method stub
		return null;
	}

}
