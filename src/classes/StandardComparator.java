package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public abstract class StandardComparator<E> implements Comparator<E> {
	
	@Override
	public boolean isGreaterThan(E x, E y) throws NotComparableException {
		return !this.isLessThanOrEqualTo(x, y);
	}

	@Override
	public boolean isGreaterThanOrEqualTo(E x, E y) throws NotComparableException {
		return !this.isLessThan(x, y);
	}

	@Override
	public boolean isComparable(E x) {
		return x != null;
	}
}
