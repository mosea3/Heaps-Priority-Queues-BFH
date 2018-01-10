package interfaces;

import exceptions.EmptyPriorityQueueException;
import exceptions.NotComparableException;

public interface PriorityQueue<K, E> extends BasicCollection<E> {

	public void insertItem(K key, E element) throws NotComparableException;

	public E removeMin() throws EmptyPriorityQueueException;

	public K minKey() throws EmptyPriorityQueueException;

	public E minElement() throws EmptyPriorityQueueException;

}
