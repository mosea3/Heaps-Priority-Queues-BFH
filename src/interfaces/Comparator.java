package interfaces;

import exceptions.NotComparableException;

public interface Comparator<E> {
	
	public boolean isLessThan(E x, E y) throws NotComparableException;
	
	public boolean isLessThanOrEqualTo(E x, E y) throws NotComparableException;

	public boolean isEqualTo(E x, E y) throws NotComparableException;

	public boolean isGreaterThan(E x, E y) throws NotComparableException;

	public boolean isGreaterThanOrEqualTo(E x, E y) throws NotComparableException;

	public boolean isComparable(E x);

}
