package classes;

public class DescendingDoubleComparator extends InvertedComparator<Double> {

	public DescendingDoubleComparator() {
		super(new AscendingDoubleComparator());
	}

}