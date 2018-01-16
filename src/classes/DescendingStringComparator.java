package classes;

/*
 * Comparator which orders strings descending
 */
public class DescendingStringComparator extends DescendingComparator<String> {

	public DescendingStringComparator() {
		super(new AscendingStringComparator());
	}

}