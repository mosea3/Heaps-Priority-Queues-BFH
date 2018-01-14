package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class AscendingIntegerComparator implements Comparator<Integer> {

	@Override
	public boolean isLessThan(Integer x, Integer y) throws NotComparableException {
		return x < y;
	}

	@Override
	public boolean isLessThanOrEqualTo(Integer x, Integer y) throws NotComparableException {
		try {
			return x <= y;
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

	@Override
	public boolean isEqualTo(Integer x, Integer y) throws NotComparableException {
		return x == y;
	}

	@Override
	public boolean isGreaterThan(Integer x, Integer y) throws NotComparableException {
		return x > y;
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Integer x, Integer y) throws NotComparableException {
		return x >= y;
	}

	@Override
	public boolean isComparable(Integer x) {
		return x != null;
	}

}
