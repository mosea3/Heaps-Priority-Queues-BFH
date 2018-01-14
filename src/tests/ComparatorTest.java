package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.AscendingDoubleComparator;
import classes.AscendingIntegerComparator;
import classes.AscendingStringComparator;
import classes.AscendingStringLengthComparator;
import classes.DescendingDoubleComparator;
import classes.DescendingIntegerComparator;
import classes.DescendingStringComparator;
import classes.DescendingStringLengthComparator;

public class ComparatorTest {

	@Test
	public void testAscendingDouble() {
		AscendingDoubleComparator c = new AscendingDoubleComparator();
		assertTrue(c.isComparable(1.0));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo(1.0, 1.0));
		assertFalse(c.isEqualTo(1.0, 1.1));
		assertTrue(c.isGreaterThan(1.1, 1.0));
		assertFalse(c.isGreaterThan(1.1, 1.1));
		assertTrue(c.isGreaterThanOrEqualTo(1.1, 1.0));
		assertTrue(c.isGreaterThanOrEqualTo(1.1, 1.1));
		assertTrue(c.isGreaterThanOrEqualTo(1.1, 1.0));
		assertTrue(c.isLessThan(1.0, 1.1));
		assertFalse(c.isLessThan(1.1, 1.1));
		assertTrue(c.isLessThanOrEqualTo(1.0, 1.1));
		assertTrue(c.isLessThanOrEqualTo(1.1, 1.1));
		assertFalse(c.isLessThanOrEqualTo(1.1, 1.0));
	}

	@Test
	public void testDescendingDouble() {
		DescendingDoubleComparator c = new DescendingDoubleComparator();
		assertTrue(c.isComparable(1.0));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo(1.0, 1.0));
		assertFalse(c.isEqualTo(1.0, 1.1));
		assertTrue(c.isLessThan(1.1, 1.0));
		assertFalse(c.isLessThan(1.1, 1.1));
		assertTrue(c.isLessThanOrEqualTo(1.1, 1.0));
		assertTrue(c.isLessThanOrEqualTo(1.1, 1.1));
		assertTrue(c.isLessThanOrEqualTo(1.1, 1.0));
		assertTrue(c.isGreaterThan(1.0, 1.1));
		assertFalse(c.isGreaterThan(1.1, 1.1));
		assertTrue(c.isGreaterThanOrEqualTo(1.0, 1.1));
		assertTrue(c.isGreaterThanOrEqualTo(1.1, 1.1));
		assertFalse(c.isGreaterThanOrEqualTo(1.1, 1.0));
	}

	@Test
	public void testAscendingInteger() {
		AscendingIntegerComparator c = new AscendingIntegerComparator();
		assertTrue(c.isComparable(1));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo(10, 10));
		assertFalse(c.isEqualTo(10, 11));
		assertTrue(c.isGreaterThan(11, 10));
		assertFalse(c.isGreaterThan(11, 11));
		assertTrue(c.isGreaterThanOrEqualTo(11, 10));
		assertTrue(c.isGreaterThanOrEqualTo(11, 11));
		assertTrue(c.isGreaterThanOrEqualTo(11, 10));
		assertTrue(c.isLessThan(10, 11));
		assertFalse(c.isLessThan(11, 11));
		assertTrue(c.isLessThanOrEqualTo(10, 11));
		assertTrue(c.isLessThanOrEqualTo(11, 11));
		assertFalse(c.isLessThanOrEqualTo(11, 10));
	}

	@Test
	public void testDescendingInteger() {
		DescendingIntegerComparator c = new DescendingIntegerComparator();
		assertTrue(c.isComparable(1));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo(10, 10));
		assertFalse(c.isEqualTo(10, 11));
		assertTrue(c.isLessThan(11, 10));
		assertFalse(c.isLessThan(11, 11));
		assertTrue(c.isLessThanOrEqualTo(11, 10));
		assertTrue(c.isLessThanOrEqualTo(11, 11));
		assertTrue(c.isLessThanOrEqualTo(11, 10));
		assertTrue(c.isGreaterThan(10, 11));
		assertFalse(c.isGreaterThan(11, 11));
		assertTrue(c.isGreaterThanOrEqualTo(10, 11));
		assertTrue(c.isGreaterThanOrEqualTo(11, 11));
		assertFalse(c.isGreaterThanOrEqualTo(11, 10));
	}

	@Test
	public void testAscendingString() {
		AscendingStringComparator c = new AscendingStringComparator();
		assertTrue(c.isComparable("Hello"));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo("Hello", "Hello"));
		assertFalse(c.isEqualTo("Hello", "World"));
		assertTrue(c.isGreaterThan("World", "Hello"));
		assertFalse(c.isGreaterThan("World", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "Hello"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "Hello"));
		assertTrue(c.isLessThan("Hello", "World"));
		assertFalse(c.isLessThan("World", "World"));
		assertTrue(c.isLessThanOrEqualTo("Hello", "World"));
		assertTrue(c.isLessThanOrEqualTo("World", "World"));
		assertFalse(c.isLessThanOrEqualTo("World", "Hello"));
	}

	@Test
	public void testDescendingString() {
		DescendingStringComparator c = new DescendingStringComparator();
		assertTrue(c.isComparable("Hello"));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo("Hello", "Hello"));
		assertFalse(c.isEqualTo("Hello", "World"));
		assertTrue(c.isLessThan("World", "Hello"));
		assertFalse(c.isLessThan("World", "World"));
		assertTrue(c.isLessThanOrEqualTo("World", "Hello"));
		assertTrue(c.isLessThanOrEqualTo("World", "World"));
		assertTrue(c.isLessThanOrEqualTo("World", "Hello"));
		assertTrue(c.isGreaterThan("Hello", "World"));
		assertFalse(c.isGreaterThan("World", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("Hello", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "World"));
		assertFalse(c.isGreaterThanOrEqualTo("World", "Hello"));
	}
	
	@Test
	public void testAscendingStringLength() {
		AscendingStringLengthComparator c = new AscendingStringLengthComparator();
		assertTrue(c.isComparable("Hell"));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo("Hell", "Hell"));
		assertFalse(c.isEqualTo("Hell", "World"));
		assertTrue(c.isGreaterThan("World", "Hell"));
		assertFalse(c.isGreaterThan("World", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "Hell"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "Hell"));
		assertTrue(c.isLessThan("Hell", "World"));
		assertFalse(c.isLessThan("World", "World"));
		assertTrue(c.isLessThanOrEqualTo("Hell", "World"));
		assertTrue(c.isLessThanOrEqualTo("World", "World"));
		assertFalse(c.isLessThanOrEqualTo("World", "Hell"));
	}


	@Test
	public void testDescendingStringLength() {
		DescendingStringLengthComparator c = new DescendingStringLengthComparator();
		assertTrue(c.isComparable("Hell"));
		assertFalse(c.isComparable(null));
		assertTrue(c.isEqualTo("Hell", "Hell"));
		assertFalse(c.isEqualTo("Hell", "World"));
		assertTrue(c.isLessThan("World", "Hell"));
		assertFalse(c.isLessThan("World", "World"));
		assertTrue(c.isLessThanOrEqualTo("World", "Hell"));
		assertTrue(c.isLessThanOrEqualTo("World", "World"));
		assertTrue(c.isLessThanOrEqualTo("World", "Hell"));
		assertTrue(c.isGreaterThan("Hell", "World"));
		assertFalse(c.isGreaterThan("World", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("Hell", "World"));
		assertTrue(c.isGreaterThanOrEqualTo("World", "World"));
		assertFalse(c.isGreaterThanOrEqualTo("World", "Hell"));
	}

}
