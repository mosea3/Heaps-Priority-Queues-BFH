package classes;

import java.util.Arrays;

import exceptions.EmptyHeapException;
import exceptions.NotComparableException;
import interfaces.Comparator;
import interfaces.Heap;

public class ArrayHeap<E> implements Heap<E> {

	private E[] elements;
	private Comparator<E> c;
	private int n;

	@SuppressWarnings("unchecked")
	public ArrayHeap(Comparator<E> comparator) {
		this.c = comparator;
		n = 0;
		elements = (E[]) new Object[1];
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n > 0;
	}

	@Override
	public void insertElement(E element) throws NotComparableException {
		/// Check if comparable MISSING
		ensureExtraCapacity();
		elements[n + 1] = element;
		n++;
		upHeap();
	}

	@Override
	/*
	 * poll
	 * @see interfaces.Heap#removeMin()
	 */
	public E removeMin() throws EmptyHeapException {
		if (n == 0) throw new EmptyHeapException();
		E element = elements[1];
		elements[1] = elements[n];
		n--;
		downHeap();
		return element;
	}

	@Override
	/*
	 * peek
	 * @see interfaces.Heap#minElement()
	 */
	public E minElement() throws EmptyHeapException {
		if (n == 0) throw new EmptyHeapException();
		return elements[1];
		
	}

	private void downHeap() {
		downHeap(1);	
	}
	private void downHeap(int index) {
		int j;
		if (index <= n) { // left child exists
			if (getRightChildIndex(index) <= n) { // right child exists
				if (c.isLessThan(leftChild(index), rightChild(index))) {
					j = getLeftChildIndex(index);
				}
				else {
					j = getRightChildIndex(index);
				}
			}
			else {
				j = getLeftChildIndex(index);
			}
			if (c.isLessThan(leftChild(index), rightChild(index))) {
				swap(index, j);
				downHeap(j);
			}
		}
	}

	private void upHeap() {
		int index = n;
		while (hasParent(index) && c.isGreaterThan(parent(index), elements[index] )) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2;
	}
	private int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}
	private int getParentIndex(int childIndex) {
		return childIndex / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < n;
	}
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < n;
	}
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 1;
	}

	private E leftChild(int index) {
		return elements[getLeftChildIndex(index)];
	}
	private E rightChild(int index) {
		return elements[getRightChildIndex(index)];
	}
	private E parent(int index) {
		return elements[getParentIndex(index)];
	}

	private void swap(int index1, int index2) {
		E temp = elements[index1];
		elements[index1] = elements[index2];
		elements[index2] = temp;
	}

	private void ensureExtraCapacity() {
		if (n == elements.length - 1)
			elements = Arrays.copyOf(elements, elements.length * 2);
	}
}
