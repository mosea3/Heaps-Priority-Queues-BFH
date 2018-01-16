package classes;

/*
 * Comparator which orders strings descending
 */
public class DescendingStringComparator extends InvertedComparator<String> {

	public DescendingStringComparator() {
		super(new AscendingStringComparator());
	}

}