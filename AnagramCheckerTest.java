package assign04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for UofUStudent.
 * 
 * @author Cameron McKay and Daler Turyssov
 * @version 2025-05-15
 */

public class AnagramCheckerTest {

	@Test
	public void testAreAnagrams() {
		assertTrue(AnagramChecker.areAnagrams("Same", "Same"));
	}

	@Test
	public void testAreNotAnagrams() {
		assertFalse(AnagramChecker.areAnagrams("Same", "NotSame"));
	}

	@Test
	public void testActualAnagrams() {
		assertTrue(AnagramChecker.areAnagrams("cat", "act"));
	}

	@Test
	public void testActualAnagramsUpperCase() {
		assertTrue(AnagramChecker.areAnagrams("Cat", "act"));
	}

	@Test
	public void testInsertionSort() {
		String words[] = { "june", "july", "august" };
		Comparator<String> myComparator = (s1, s2) -> s1.compareTo(s2);
		AnagramChecker.insertionSort(words, myComparator);
		String[] excpectedWords = { "august", "july", "june" };
		assertArrayEquals(excpectedWords, words);
	}

	@Test
	public void testInsertionSortIntegers() {
		Integer numbers[] = { 5, 7, 3 };
		Comparator<Integer> myComparator = (s1, s2) -> s1.compareTo(s2);
		AnagramChecker.insertionSort(numbers, myComparator);
		Integer[] excpectedWords = { 3, 5, 7 };
		assertArrayEquals(excpectedWords, numbers);
	}

	// Only works with original file path, but did work
//	@Test
//	public void testgetLargestAnagramGroupFile() {
//		String[] check = AnagramChecker.getLargestAnagramGroup("");
//		String[] actual = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };
//		assertArrayEquals(actual, check);
//	}

	@Test
	public void testgetLargestAnagramGroupEmpty() {
		String[] empty = {};
		String[] check = AnagramChecker.getLargestAnagramGroup(empty);
		String[] actual = {};
		assertArrayEquals(actual, check);
	}

	@Test
	public void testgetLargestAnagramGroupStringsSame() {
		String[] actual = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };
		String[] check = AnagramChecker.getLargestAnagramGroup(actual);
		String[] expected = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };
		assertArrayEquals(expected, check);
	}

	@Test
	public void testgetLargestAnagramGroupNoAnagrams() {
		String[] actual = { "april", "august", "december", "february", "january", "july", "june", "march", "may",
				"november", "october", "september" };
		String[] check = AnagramChecker.getLargestAnagramGroup(actual);
		String[] expected = {};
		assertArrayEquals(expected, check);
	}

	@Test
	public void testgetLargestAnagramGroupNormal() {
		String[] actual = { "april", "august", "december", "April", "february", "january", "july", "june", "arpil",
				"march", "may", "november", "october", "september" };
		String[] check = AnagramChecker.getLargestAnagramGroup(actual);
		String[] expected = { "april", "April", "arpil" };
		assertArrayEquals(expected, check);
	}

}