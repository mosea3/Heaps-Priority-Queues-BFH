package classes;

public class DescendingStringComparator extends InvertedComparator<String> {

	public DescendingStringComparator() {
		super(new AscendingStringComparator());
	}

}