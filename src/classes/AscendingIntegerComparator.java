package classes;

import exceptions.NotComparableException;

/*
 * Comparator which orders integers ascending
 */
public class AscendingIntegerComparator extends AscendingComparator<Integer> {

	@Override
	public boolean isLessThan(Integer x, Integer y) throws NotComparableException {
		try {
			return x < y;
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}
}
