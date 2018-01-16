package classes;

/*
 * Comparator which orders strings descending to their length
 */
public class DescendingStringLengthComparator extends DescendingComparator<String> {

	public DescendingStringLengthComparator() {
		super(new AscendingStringLengthComparator());
	}

}