package classes;

import exceptions.NotComparableException;

/*
 * Comparator which orders strings ascending
 */
public class AscendingStringComparator extends AscendingComparator<String> {

	@Override
	public boolean isLessThan(String x, String y) throws NotComparableException {
		try {
			if (x.compareTo(y) < 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}
}
