package classes;

import java.util.ArrayList;
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

	private K[] keys;
	private Map<Integer, ArrayList> elements;
	private Comparator<Integer> c;
	
	Comparator<Integer> comparator = null;
	Heap<Integer> heap;
	private int n;
	
	public HeapPriorityQueue(Comparator<Integer> comparator){
		this.c = comparator;
		this.heap = new ArrayHeap<Integer>(c);
		this.elements = new HashMap<Integer, ArrayList>();
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
	 * Returns, wheteher Queue is empty
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
	//TODO find better var name for 2nd level element storage
	@Override
	public void insertItem(K key, E element) throws NotComparableException {
		if(!c.isComparable((Integer) key)){
			throw new NotComparableException();
		}
		
		ArrayList<String> keyStore = null;
		try{
			heap.insertElement((int) key);
		}catch (NotComparableException e) {
		    throw e;
		}
		
		if(elements.containsKey(key)){
			keyStore = new ArrayList<String>(elements.get(key));
			keyStore.add((String) element);
		}else{
			keyStore = new ArrayList<String>();
			//System.out.println("Key:" + key + " not previously recorded");
			keyStore.add((String) element);
		}
		elements.put((int) key, keyStore);
		n++;
		//System.out.println(this.size() + " is the new PQ size.");
	}

	/**
	 * dequeues an Element and returns it
	 * @return <b>E</b>: returns an Element of Type E, which is to be removed of the Queue (eg. dequeued)
	 * @throws EmptyPriorityQueueException if there is nothing left to be dequeued
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E removeMin() throws EmptyPriorityQueueException {
		if(n<1) throw new EmptyPriorityQueueException(); //short notation for big effects
		int key = (int) minKey();
		ArrayList<String> el = elements.get(key);
		String minElement = el.get(el.size()-1);
		
		if(el.size()>1){ 						//if multiple elements under one min key, just dequeue the first one under that key thus it was added as first FIFO
			el.remove(0);	
		}else{	
			elements.remove(key);				//remove entire element under key
		}
		heap.removeMin();
		n--;
		return (E) minElement;
	}
	
	/**
	 * returns the Key to the minimum value
	 * @throws EmptyPriorityQueueException if Queue is empty
	 */
	@SuppressWarnings("unchecked")
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
		if(n<1){
			throw new EmptyPriorityQueueException();
		}
		int key = (int) minKey();
		ArrayList<String> el = elements.get(key);
		String minEl = el.get(0);
		return (E) minEl;
	}

}
