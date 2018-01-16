package classes;

import exceptions.NotComparableException;

/*
 * Comparator which orders doubles ascending
 */
public class AscendingDoubleComparator extends StandardComparator<Double> {

	@Override
	public boolean isLessThan(Double x, Double y) throws NotComparableException {
		try {
			return x < y;
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

	@Override
	public boolean isLessThanOrEqualTo(Double x, Double y) throws NotComparableException {
		try {
			return x <= y;
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

	@Override
	public boolean isEqualTo(Double x, Double y) throws NotComparableException {
		try {
			return (Double.compare(x, y) == 0) ? true : false;
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

}
