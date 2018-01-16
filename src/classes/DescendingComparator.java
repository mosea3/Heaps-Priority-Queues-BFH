package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

/*
 * Inverts a given comparator
 */
public abstract class DescendingComparator<E> extends AscendingComparator<E> {

	/*
	 * Comparator to invert
	 */
	Comparator<E> c;
	
	public DescendingComparator(Comparator<E> c) {
		this.c = c;
	}
	
	public boolean isLessThan(E x, E y) throws NotComparableException{
		return c.isGreaterThan(x, y);
	}

}
