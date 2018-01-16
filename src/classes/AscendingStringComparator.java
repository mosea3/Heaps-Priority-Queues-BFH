package classes;

import exceptions.NotComparableException;

/*
 * Comparator which orders strings ascending
 */
public class AscendingStringComparator extends StandardComparator<String> {

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

	@Override
	public boolean isLessThanOrEqualTo(String x, String y) throws NotComparableException {
		try {
			if (x.compareTo(y) <= 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

	@Override
	public boolean isEqualTo(String x, String y) throws NotComparableException {
		try {
			return x.equals(y);
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}
}
