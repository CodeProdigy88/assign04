package assign04;

import java.util.Comparator;

public class AnagramChecker {

	/**
	 * Sorts input lexicographically, ignoring captials
	 * 
	 * @param input - string to be sorted
	 * @return lexicographically sorted string
	 */
	public static String sort(String input) {

		Character[] charArray = new Character[input.length()];
		String lowerCase = input.toLowerCase();
		char[] chars = lowerCase.toCharArray();

		for (int i = 0; i < input.length(); i++) {
			charArray[i] = chars[i];
		}
		Comparator<Character> myComparator = (s1, s2) -> s1.compareTo(s2);
		insertionSort(charArray, myComparator);
		String newArray = "";
		for (int i = 0; i < charArray.length; i++) {
			newArray += charArray[i];
		}
		return newArray;
	}

	/**
	 * Uses insertion sort to sort an array
	 * 
	 * @param unsortArray - the unsorted array to be sorted
	 * @param cmp         - The comparator to be used for sorting
	 */
	public static <T> void insertionSort(T[] unsortArray, Comparator<? super T> cmp) {
		for (int i = 1; i < unsortArray.length; i++) {
			T key = unsortArray[i];
			int j = i - 1;

			while (j >= 0 && cmp.compare(unsortArray[j], key) > 0) {
				unsortArray[j + 1] = unsortArray[j];
				j--;
			}
			unsortArray[j + 1] = key;
		}
	}

	/**
	 * Checks if 2 strings are anagrams
	 * 
	 * @param first   - The first word to be compared
	 * @param second- The second word to be compared
	 * @return - true if strings are anagrams, false if not
	 */
	public static boolean areAnagrams(String first, String second) {
		return sort(first).equals(sort(second));
	}

	public static String[] getLargestAnagramGroup(String[] largestGroup) {
		String[] sortedArray = new String[largestGroup.length];
		for (int i = 0; i < largestGroup.length; i++) {
			sortedArray[i] = sort(largestGroup[i]);
		}
		// Finds the highest amount in a row
		int highestAmount = 0;
		int amount = 0;
		String anagramCurrent = "";
		for (int i = 1; i < sortedArray.length; i++) {
			if (sortedArray[i].compareTo(sortedArray[i - 1]) == 0) {
				amount++;
			}
			if (amount > highestAmount) {
				highestAmount = amount;
				anagramCurrent = sortedArray[i];
			}
		}
		return null;
	}

	public static String[] getLargestAnagramGroup(String filename) {
		return null;
	}

	private static String[] fileReader(String filename) {
		return null;
	}

	private static String[] anagramLister(String[] sortedList) {
		return null;
	}

	private static String getOriginal(String altered) {
		return altered;
	}

}