package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class DescendingStringComparator implements Comparator<String> {
	
	private AscendingStringComparator c;

	public DescendingStringComparator() {
		c = new AscendingStringComparator();
	}

	@Override
	public boolean isLessThan(String x, String y) throws NotComparableException {
		return c.isGreaterThan(x, y);
	}

	@Override
	public boolean isLessThanOrEqualTo(String x, String y) throws NotComparableException {
		return c.isGreaterThanOrEqualTo(x, y);
	}

	@Override
	public boolean isEqualTo(String x, String y) throws NotComparableException {
		return c.isEqualTo(x, y);
	}

	@Override
	public boolean isGreaterThan(String x, String y) throws NotComparableException {
		return c.isLessThan(x, y);
	}

	@Override
	public boolean isGreaterThanOrEqualTo(String x, String y) throws NotComparableException {
		return c.isLessThanOrEqualTo(x, y);
	}

	@Override
	public boolean isComparable(String x) {
		return c.isComparable(x);
	}

}
