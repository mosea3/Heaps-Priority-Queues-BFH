package classes;

/*
 * Comparator which orders integers descending
 */
public class DescendingIntegerComparator extends DescendingComparator<Integer> {

	public DescendingIntegerComparator() {
		super(new AscendingIntegerComparator());
	}

}
