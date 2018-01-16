package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public abstract class AscendingComparator<E> implements Comparator<E> {

	@Override
	public boolean isLessThanOrEqualTo(E x, E y) throws NotComparableException {
		return isLessThan(x, y) || isEqualTo(x, y);
	}

	public boolean isEqualTo(E x, E y) throws NotComparableException {
		return x.equals(y);
	}

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
