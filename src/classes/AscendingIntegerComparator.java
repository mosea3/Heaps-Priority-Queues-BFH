package classes;

import exceptions.NotComparableException;

/*
 * Comparator which orders integers ascending
 */
public class AscendingIntegerComparator extends StandardComparator<Integer> {

	@Override
	public boolean isLessThan(Integer x, Integer y) throws NotComparableException {
		try {
			return x < y;
		} catch (Exception e) {
			throw new NotComparableException();
		}
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
		try {
			return x == y;
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}
}
