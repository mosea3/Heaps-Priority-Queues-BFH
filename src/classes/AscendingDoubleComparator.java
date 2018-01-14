package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class AscendingDoubleComparator implements Comparator<Double> {

	@Override
	public boolean isLessThan(Double x, Double y) throws NotComparableException {
		try {
			return x < y;
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isLessThanOrEqualTo(Double x, Double y) throws NotComparableException {
		try {
			return x <= y;
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isEqualTo(Double x, Double y) throws NotComparableException {
		try {
			return (Double.compare(x, y) == 0) ? true : false;
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isGreaterThan(Double x, Double y) throws NotComparableException {
		return !this.isLessThanOrEqualTo(x, y);
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Double x, Double y) throws NotComparableException {
		return !this.isLessThan(x, y);
	}

	@Override
	public boolean isComparable(Double x) {
		return x != null;
	}

}
