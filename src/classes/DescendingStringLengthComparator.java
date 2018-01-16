package classes;

public class DescendingStringLengthComparator extends InvertedComparator<String> {

	public DescendingStringLengthComparator() {
		super(new AscendingStringLengthComparator());
	}

}