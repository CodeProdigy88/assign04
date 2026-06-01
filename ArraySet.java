package assign03;

import java.util.Collection;
import java.util.Comparator;

/**
 * A set with operations to add, remove, and query elements.
 *
 * @author Daler Turyssov and Cameron McKay
 * @version 2026-05-24
 *
 * @param <E> - the type of elements contained in this set
 */
public class ArraySet<E> implements Set<E> {
	private E array[];
	private int size;
	private Comparator<? super E> cmp;

	/**
	 * The constructor of the ArraySet object without a comparator
	 */
	public ArraySet() {
		int size = 0;
		@SuppressWarnings("unchecked")
		E[] array = (E[]) new Object[10];
		this.array = array;
		this.size = size;
	}

	/**
	 * The constructor of the ArraySet object with a comparator
	 */
	public ArraySet(Comparator<? super E> cmp) {
		int size = 0;
		@SuppressWarnings("unchecked")
		E[] array = (E[]) new Object[10];
		this.array = array;
		this.size = size;
		this.cmp = cmp;
	}

	/**
	 * A helper method to compare
	 * 
	 * Compares 2 objects. If comparator is null uses default ordering. Otherwise
	 * uses provided comparator.
	 * 
	 * @param item1 - Left Item to compare
	 * @param item2 - Right Item to compare
	 * @return positive integer if left is greater, negative integer if less than, 0
	 *         if eqauls
	 */
	@SuppressWarnings("unchecked")
	private int compare(E item1, E item2, Comparator<? super E> cmp) {
		if (cmp == null) {
			return ((Comparable<? super E>) item1).compareTo(item2);
		}
		return cmp.compare(item1, item2);
	}

	/**
	 * Finds the correct location of target object, helper method to add, remove,
	 * and contains
	 * 
	 * @param array  - The array to search
	 * @param target - The object being searched with
	 * @return The correct sorting location if not in array, -1 if it is in the
	 *         array
	 */
	private int binarySearch(E[] array, E target) {
		int lowIndex = 0;
		int highIndex = this.size - 1;
		int targetIndex = lowIndex + (highIndex - lowIndex) / 2;

		while (highIndex >= lowIndex) {

			// Find middle cautiously to avoid too high numbers
			targetIndex = lowIndex + (highIndex - lowIndex) / 2;

			// Gets the compare result (less than 0 target is less, greater than 0 index is
			// less, 0 if equals
			int compareResult = this.compare(target, array[targetIndex], this.cmp);

			if (compareResult > 0) {
				lowIndex = targetIndex + 1;
			} else if (compareResult < 0) {
				highIndex = targetIndex - 1;
			}
			// Returns -1 once found in the array
			else if (compareResult == 0)
				return (targetIndex * -1) - 1;
		}
		// Returns lower bound if not found in the array
		return lowIndex;
	}

	/**
	 * Adds an element to the set in the correct location.
	 *
	 * @param item - the element to add
	 */
	@Override
	public void add(E item) {
		if (this.size == this.array.length - 1) {
			this.increaseSize();
		}
		// Call search for correct placement
		// Move forward every entry after
		int changeLocation = binarySearch(this.array, item);
		if (changeLocation < 0) {
			return;
		}
		for (int i = this.size - 1; i >= changeLocation; i--) {
			this.array[i + 1] = this.array[i];
		}
		size++;
		this.array[changeLocation] = item;
	}

	/**
	 * Helper Method to double array length and copy elements Used in add and remove
	 *
	 */
	private void increaseSize() {
		{
			@SuppressWarnings("unchecked")
			E[] arrayNew = (E[]) new Object[this.array.length * 2];
			for (int i = 0; i < this.array.length; i++) {
				arrayNew[i] = this.array[i];
			}
			this.array = arrayNew;
		}
	}

	/**
	 * Removes and returns an element equal to the given item if such an element is
	 * present.
	 *
	 * @param item - the element to be removed
	 * @return the element that was removed if present; otherwise null
	 */
	@Override
	public E remove(E item) {
		int changeLocation = binarySearch(this.array, item);
		if (changeLocation > 0) {
			return null;
		}
		if (this.isEmpty())
			return null;

		changeLocation++;
		changeLocation *= -1;
		this.array[changeLocation] = item;
		for (int i = changeLocation + 1; i < this.array.length; i++) {
			this.array[i - 1] = this.array[i];
		}
		this.array[size - 1] = null;
		size--;
		return item;
	}

	/**
	 * Indicates whether this set contains an element equal to the given item.
	 *
	 * @param item - the object to be checked for containment in this set
	 * @return true if the item is contained in this set; otherwise false
	 */
	@Override
	public boolean contains(E item) {
		if (binarySearch(this.array, item) < 0) {
			return true;
		}
		return false;
	}

	/**
	 * Indicates whether this set contains all the elements in the collection. If
	 * the collection is empty, this returns true.
	 *
	 * @param items - a collection of objects to be checked for containment in this
	 *              set
	 * @return true if all items are contained in this set; otherwise false
	 */
	@Override
	public boolean containsAll(Collection<? extends E> items) {
		for (E item : items) {
			if (!contains(item)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns all the elements of the set in an array.
	 *
	 * @return array containing all elements of the set
	 */
	@Override
	public E[] toArray() {
		@SuppressWarnings("unchecked")
		E[] arrayNew = (E[]) new Object[this.size];
		for (int i = 0; i < this.size; i++) {
			arrayNew[i] = this.array[i];
		}
		return arrayNew;
	}

	/**
	 * @return the number of elements in the set
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * @return true if this set is empty; otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Removes all the elements from this set, resulting in an empty set.
	 */
	@Override
	public void clear() {
		@SuppressWarnings("unchecked")
		E[] arrayNew = (E[]) new Object[10];
		this.array = arrayNew;
		size = 0;

	}

}
