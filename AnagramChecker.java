package assign04;

import java.util.Comparator;
import java.util.Map;

public class AnagramChecker {

	public static String sort(String input) {
		char[] charArray = input.toCharArray();
		return insertionSort(charArray, Comparator<? super T> cmp);
	}

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

	public static boolean areAnagrams(String first, String second) {
		return false;
	}

	public static String[] getLargestAnagramGroup(String[] largestGroup) {
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
