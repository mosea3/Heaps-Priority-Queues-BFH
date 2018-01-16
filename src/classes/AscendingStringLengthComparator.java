package classes;

import exceptions.NotComparableException;

/*
 * Comparator which orders string ascending to their length
 */
public class AscendingStringLengthComparator extends AscendingComparator<String> {

	@Override
	public boolean isLessThan(String x, String y) throws NotComparableException {
		try {
			return x.length() < y.length();
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

	@Override
	public boolean isEqualTo(String x, String y) throws NotComparableException {
		try {
			return x.length() == y.length();
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

}
