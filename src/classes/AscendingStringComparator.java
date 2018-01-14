package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class AscendingStringComparator implements Comparator<String> {

	@Override
	public boolean isLessThan(String x, String y) throws NotComparableException {
		try {
			if (x.compareTo(y) < 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
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
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isEqualTo(String x, String y) throws NotComparableException {
		try {
			return x.equals(y);
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isGreaterThan(String x, String y) throws NotComparableException {
		try {
			if (x.compareTo(y) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isGreaterThanOrEqualTo(String x, String y) throws NotComparableException {
		try {
			if (x.compareTo(y) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new NotComparableException("Value is not comparable");
		}
	}

	@Override
	public boolean isComparable(String x) {
		return x != null;
	}
}
