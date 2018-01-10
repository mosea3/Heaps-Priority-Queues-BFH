package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class AscendingIntegerComparator implements Comparator<Integer> {

	@Override
	public boolean isLessThan(Integer x, Integer y) throws NotComparableException {
		return Integer.compare(x, y);
	}

	@Override
	public boolean isLessThanOrEqualTo(Integer x, Integer y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqualTo(Integer x, Integer y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThan(Integer x, Integer y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Integer x, Integer y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComparable(Integer x) {
		// TODO Auto-generated method stub
		return false;
	}

}
