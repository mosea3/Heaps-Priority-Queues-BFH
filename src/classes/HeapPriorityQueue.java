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

/**
 * This Class HeapPriorityQueue implements a Priority Queue based on a Heap and its comparators.
 * @author mosea3@bfh.ch
 * @version 1.0
 * @param <K> a Key of Integer
 * @param <E> an Element
 */
public class HeapPriorityQueue <K, E> implements PriorityQueue <K, E>{

	private Map<Integer, LinkedList> elements;
	private Comparator<Integer> c;
	Heap<Integer> heap;
	private int n;
	
	public HeapPriorityQueue(Comparator<Integer> comparator){
		this.c = comparator;
		this.heap = new ArrayHeap<Integer>(c);
		this.elements = new HashMap<Integer, LinkedList>();
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
		if(!c.isComparable((Integer) key)) throw new NotComparableException();
		
		LinkedList<E> keyStore = null;
		try{
			heap.insertElement((int) key);
		}catch (NotComparableException e) {
		    throw e;
		}
		
		if(elements.containsKey(key)){
			keyStore = new LinkedList<E>(elements.get(key));
			keyStore.add(element);
		}else{
			keyStore = new LinkedList<E>();
			keyStore.add(element);
		}
		elements.put((int) key, keyStore);
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
		
		int key = (int) minKey();
		LinkedList<E> el = elements.get(key);
		E minElement = el.getLast();
		
		if(el.size()>1){ 						//if multiple elements under one min key, just dequeue the first one under that key thus it was added as first FIFO
			el.remove();						//FIFO, random dequeuing of same-high priority keys would be fair, but increases runtime-complexity	
		}else{	
			elements.remove(key);				
		}
		heap.removeMin();
		n--;
		return minElement;
	}
	
	/**
	 * returns the Key to the minimum value
	 * @throws EmptyPriorityQueueException if Queue is empty
	 */
	@Override
	public K minKey() throws EmptyPriorityQueueException {
		if(n<1){
			throw new EmptyPriorityQueueException();
		}
		K key = (K) heap.minElement();
		return key;
	}
	
	/**
	 * returns the Element with minimum Index right next on queue
	 * @throws EmptyPriorityQueueException if Queue is empty
	 */
	@Override
	public E minElement() throws EmptyPriorityQueueException {
		if(n<1) throw new EmptyPriorityQueueException();
		int key = (int) minKey();
		LinkedList<E> el = elements.get(key);
		E minEl = el.getFirst();
		return minEl;
	}

}