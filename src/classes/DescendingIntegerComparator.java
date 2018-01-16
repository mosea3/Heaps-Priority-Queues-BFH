package classes;

public class DescendingIntegerComparator extends InvertedComparator<Integer> {

	public DescendingIntegerComparator() {
		super(new AscendingIntegerComparator());
	}

}
