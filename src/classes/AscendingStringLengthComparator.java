package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class AscendingStringLengthComparator implements Comparator<String> {

	@Override
	public boolean isLessThan(String x, String y) throws NotComparableException {
		try {
			return x.length() < y.length();
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isLessThanOrEqualTo(String x, String y) throws NotComparableException {
		try {
			return x.length() <= y.length();
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isEqualTo(String x, String y) throws NotComparableException {
		try {
			return x.length() == y.length();
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isGreaterThan(String x, String y) throws NotComparableException {
		return !this.isLessThanOrEqualTo(x, y);
	}

	@Override
	public boolean isGreaterThanOrEqualTo(String x, String y) throws NotComparableException {
		return !this.isLessThan(x, y);
	}

	@Override
	public boolean isComparable(String x) {
		return x != null;
	}

}
