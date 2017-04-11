/**
 * An ArrayList-like class which implements a variable length array that holds
 * int values.
 * 
 * Your Name Here
 *
 */
public class IntArray {
	private int[] a;
	private int length;

	/**
	 * Create a new empty IntArray.
	 */
	public IntArray() {
		length = 0;
		a = new int[8];
	}

	/**
	 * Get the element at index i in this IntArray.
	 * 
	 * @param i
	 *            Valid existing index
	 * @return Element
	 * @throws ArrayIndexOutOFBoundsException
	 *             if i is not valid
	 */
	public int get(int i) {
		if (i < 0 || i >= length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		return a[i];
	}

	/**
	 * Get the number of elements in this IntArray.
	 * 
	 * @return number of elements
	 */
	public int size() {
		return length;
	}

	/**
	 * Modify an element at an existing index in the IntArray.
	 * 
	 * @param i
	 *            Valid existing index
	 * @param x
	 *            New value
	 * @throws ArrayIndexOutOFBoundsException
	 *             if i is not valid
	 */
	public void set(int i, int x) {
		if (i < 0 || i >= length) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		a[i] = x;
	}

	/**
	 * Add an element to the end of the IntArray, expanding the underlying array
	 * if necessary.
	 * 
	 * @param x
	 *            Value to add
	 */
	public void add(int x) {
		if (length >= a.length) {
			// Create new array of double the length.
			int[] b = new int[a.length * 2];
			// Copy the elements of a into their corresponding indexes of b.
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
			// Reassign a reference to b.
			a = b;
		}
		// Place x at the end of the IntArray
		a[length] = x;
		// Increase length by 1
		length = length + 1;
	}

	/**
	 * Add an element to the beginning of the IntArray, moving forward the
	 * existing elements by 1 each and expanding the underlying array if
	 * necessary.
	 * 
	 * @param x
	 *            Value to add
	 */
	public void prepend(int x) {
		// TODO Remove this comment and implement according to the handout.
	}
}