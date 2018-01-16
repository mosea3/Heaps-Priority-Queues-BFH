package classes;

/*
 * Comparator which orders doubles descending
 */
public class DescendingDoubleComparator extends InvertedComparator<Double> {

	public DescendingDoubleComparator() {
		super(new AscendingDoubleComparator());
	}

}