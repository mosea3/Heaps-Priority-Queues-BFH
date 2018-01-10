package interfaces;

import exceptions.EmptyHeapException;
import exceptions.NotComparableException;

public interface Heap<E> extends BasicCollection<E> {
	
	public void insertElement(E element) throws NotComparableException;
	
	public E removeMin() throws EmptyHeapException;
	
	public E minElement() throws EmptyHeapException;
	
}
