package classes;

/*
 * Comparator which orders doubles descending
 */
public class DescendingDoubleComparator extends DescendingComparator<Double> {

	public DescendingDoubleComparator() {
		super(new AscendingDoubleComparator());
	}

}