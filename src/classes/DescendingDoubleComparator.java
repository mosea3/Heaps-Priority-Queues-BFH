package classes;

import exceptions.NotComparableException;
import interfaces.Comparator;

public class DescendingDoubleComparator implements Comparator<Double> {

	@Override
	public boolean isLessThan(Double x, Double y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLessThanOrEqualTo(Double x, Double y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqualTo(Double x, Double y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThan(Double x, Double y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThanOrEqualTo(Double x, Double y) throws NotComparableException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComparable(Double x) {
		// TODO Auto-generated method stub
		return false;
	}

}
