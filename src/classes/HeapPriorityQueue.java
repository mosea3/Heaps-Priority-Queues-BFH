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
 * @author mosea3
 * @param <K> a Key of Integer
 * @param <E> an Element
 */
public class HeapPriorityQueue <K, E> implements PriorityQueue <K, E>{

	private K[] keys;
	private Map<Integer, ArrayList> elements;
	
	Comparator<Integer> comparator = null;
	Heap<Integer> heap;
	private int n;
	
	public HeapPriorityQueue(Comparator<Integer> comparator){
		this.heap = new ArrayHeap<Integer>(comparator);
		this.elements = new HashMap<Integer, ArrayList>();
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
	 * @return <b>boolean</b>: true if empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return n == 0;
	}
	
	/**
	 * inserts an Item (eg. queues an Item)
	 * @param key key of Integer
	 * @param element an element
	 * @throws NotComparableException if key not Comparable
	 * @see interfaces.PriorityQueue#insertItem(java.lang.Object, java.lang.Object)
	 **/
	// TODO check behavior, if a multiple elements w/ same Keys are inserted
	@Override
	public void insertItem(K key, E element) throws NotComparableException {
		ArrayList<String> keyStore = null;
		
		if(key == null){
			throw new NotComparableException();
		}
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
		//System.out.println("pq size before dequeuing:"+n);
		// TODO check behavior if a duplicate key is to be removed
		//System.out.println("heap size before dequeuing:"+ heap.size());
		if(n<1){
			throw new EmptyPriorityQueueException();
		}
		int key = (int) minKey();
		//System.out.println("dequeing key:"+key);
		ArrayList<String> el = elements.get(key);
		
		//System.out.println(el);
		
		//System.out.println("number of el in that index:"+ el.size());
		String minElement = el.get(el.size()-1);
		
		if(el.size()>1){ //if multiple elements under one min key, just dequeue the last one
						//and do not remove key from heap
			int deletionIndex = (el.size()-1);
			el.remove(deletionIndex);
			//System.out.println("multiple elements found - just dequeue one");
			//System.out.println("number of el in that index after deletion of single el:"+el.size());
			
		}else{
			//System.out.println("single element - dequeue entire el and index from heap");
			//remove entire element under key
			elements.remove(key);
			
		}
		heap.removeMin();
		
		
		//System.out.println("dequeue el with key:"+key);
		//System.out.println("dequeue el:"+ el);
		
		
		
		
		
		n--;
		//System.out.println("heap size after dequeuing:"+n);
		//System.out.println("done dequeuing!");
		//System.out.println("--------------------------");
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
		String minEl = el.get((el.size()-1));
		
		
		return (E) minEl;
	}

}
