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

}