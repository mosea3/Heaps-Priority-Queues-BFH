package classes;

/*
 * Comparator which orders integers descending
 */
public class DescendingIntegerComparator extends InvertedComparator<Integer> {

	public DescendingIntegerComparator() {
		super(new AscendingIntegerComparator());
	}

}
