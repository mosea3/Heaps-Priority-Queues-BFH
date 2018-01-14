package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class DescendingIntegerComparator implements Comparator<Integer> {

	private AscendingIntegerComparator c;

	public DescendingIntegerComparator() {
		c = new AscendingIntegerComparator();
	}

	@Override
	public boolean isLessThan(Integer x, Integer y) throws NotComparableException {
		return c.isGreaterThanOrEqualTo(x, y);
	}

	@Override
	public boolean isLessThanOrEqualTo(Integer x, Integer y) throws NotComparableException {
		return c.isGreaterThan(x, y);
	}

	@Override
	public boolean isEqualTo(Integer x, Integer y) throws NotComparableException {
		return c.isEqualTo(x, y);
	}

	@Override
	public boolean isGreaterThan(Integer x, Integer y) throws NotComparableException {
		return c.isLessThanOrEqualTo(x, y);
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Integer x, Integer y) throws NotComparableException {
		return c.isLessThan(x, y);
	}

	@Override
	public boolean isComparable(Integer x) {
		return c.isComparable(x);
	}

}
