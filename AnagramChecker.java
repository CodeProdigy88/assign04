package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

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
		// Sorts the original array into a copy, sorts each word by letter
		String[] sortedArray = new String[largestGroup.length];
		for (int i = 0; i < largestGroup.length; i++) {
			sortedArray[i] = sort(largestGroup[i]);
		}
		// Sorts the array by words
		Comparator<String> myComparator = (s1, s2) -> s1.compareTo(s2);
		insertionSort(sortedArray, myComparator);
		// Finds the highest amount of duplicates
		int highestAmount = 0;
		int amount = 0;
		String anagramCurrent = "";
		for (int i = 1; i < sortedArray.length; i++) {
			if (sortedArray[i].compareTo(sortedArray[i - 1]) == 0) {
				amount++;
				if (amount > highestAmount) {
					highestAmount = amount;
					anagramCurrent = sortedArray[i];
				}
			} else {
				amount = 0;
			}
		}
		// We need to return the original words
		int arrayPlace = 0;
		String[] returnedArray = new String[highestAmount + 1];
		for (int i = 0; i < sortedArray.length; i++) {
			if (areAnagrams(largestGroup[i], anagramCurrent)) {
				returnedArray[arrayPlace] = largestGroup[i];
				arrayPlace++;
			}
		}
		return returnedArray;
	}

	public static String[] getLargestAnagramGroup(String filename) {
		ArrayList<String> wordList = new ArrayList<String>();
		File file = new File(filename);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String word = scan.nextLine();
				wordList.add(word);
			}
		} catch (FileNotFoundException e) {
			return new String[0];
		}
		String[] fileArray = wordList.toArray(new String[0]);
		return getLargestAnagramGroup(fileArray);
	}
}