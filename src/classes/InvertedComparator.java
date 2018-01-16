package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

/*
 * Inverts a given comparator
 */
public abstract class InvertedComparator<E> extends StandardComparator<E> {

	/*
	 * Comparator to invert
	 */
	Comparator<E> c;
	
	public InvertedComparator(Comparator<E> c) {
		this.c = c;
	}
	
	public boolean isLessThan(E x, E y) throws NotComparableException{
		return c.isGreaterThan(x, y);
	}
	
	public boolean isLessThanOrEqualTo(E x, E y) throws NotComparableException{
		return c.isGreaterThanOrEqualTo(x, y);	
	}

	public boolean isEqualTo(E x, E y) throws NotComparableException{
		return c.isEqualTo(x, y);
	}

}
