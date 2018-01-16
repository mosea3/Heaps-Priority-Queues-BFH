package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public abstract class InvertedComparator<E> implements Comparator<E> {

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

	public boolean isGreaterThan(E x, E y) throws NotComparableException{
		return c.isLessThan(x, y);
	}

	public boolean isGreaterThanOrEqualTo(E x, E y) throws NotComparableException{
		return c.isLessThanOrEqualTo(x, y);	
	}

	public boolean isComparable(E x) {
		return c.isComparable(x);	
	}
}
