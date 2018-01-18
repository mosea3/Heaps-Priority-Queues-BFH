package classes;

import exceptions.NotComparableException;

public class ItemComparator extends AscendingComparator<Item> {

	@Override
	public boolean isLessThan(Item x, Item y) throws NotComparableException {
		try {
			return x.key < y.key;
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}

	@Override
	public boolean isEqualTo(Item x, Item y) throws NotComparableException {
		try {
			return x.key == y.key && x.element.equals(y.element);
		} catch (Exception e) {
			throw new NotComparableException();
		}
	}
}
