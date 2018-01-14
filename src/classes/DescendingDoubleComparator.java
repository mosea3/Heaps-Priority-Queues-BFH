package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class DescendingDoubleComparator implements Comparator<Double> {
	
	private AscendingDoubleComparator c;
	
	public DescendingDoubleComparator() {
		c = new AscendingDoubleComparator();
	}
	
	@Override
	public boolean isLessThan(Double x, Double y) throws NotComparableException {
		return c.isGreaterThan(x, y);
	}

	@Override
	public boolean isLessThanOrEqualTo(Double x, Double y) throws NotComparableException {
		return c.isGreaterThanOrEqualTo(x, y);
	}

	@Override
	public boolean isEqualTo(Double x, Double y) throws NotComparableException {
		return c.isEqualTo(x, y);
	}

	@Override
	public boolean isGreaterThan(Double x, Double y) throws NotComparableException {
		return c.isLessThan(x, y);
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Double x, Double y) throws NotComparableException {
		return c.isLessThanOrEqualTo(x, y);
	}

	@Override
	public boolean isComparable(Double x) {
		return c.isComparable(x);
	}

}
