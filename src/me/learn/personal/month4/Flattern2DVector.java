/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 251 :
 * 
 * Design and implement an iterator to flatten a 2d vector. It should support
 * the following operations: next and hasNext.
 * 
 * 
 * Example:
 * 
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * 
 * iterator.next(); // return 1 iterator.next(); // return 2 iterator.next(); //
 * return 3 iterator.hasNext(); // return true iterator.hasNext(); // return
 * true iterator.next(); // return 4 iterator.hasNext(); // return false
 * 
 * 
 * Notes:
 * 
 * Please remember to RESET your class variables declared in Vector2D, as
 * static/class variables are persisted across multiple test cases. Please see
 * here for more details. You may assume that next() call will always be valid,
 * that is, there will be at least a next element in the 2d vector when next()
 * is called.
 * 
 * 
 * @author bramanarayan
 * @date Jul 27, 2020
 */
public class Flattern2DVector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Vector2D solution = new Vector2D(new int[][] { { 1, 2 }, { 3 }, { 4 } });
		System.out.println(solution.next());
		System.out.println(solution.next());

		System.out.println(solution.next());

		System.out.println(solution.hasNext());
		System.out.println(solution.hasNext());
		System.out.println(solution.next());

		System.out.println(solution.hasNext());

	}

}

// TWO POINTERS
// OUTER pointer
// INNER Pointer
class Vector2D {

	int outer = 0;
	int inner = 0;

	int[][] v;

	public Vector2D(int[][] v) {

		this.v = v;
	}

	// you have the pointers ready, you know the next element already. 
	// so you just need to read and return the value.
	// Notice this diff in all iterator problems.
	public int next() {
		if (hasNext()) {
			return v[outer][inner++];

		}
		return -1;
	}

	// Remember to do all sort of computation in hasNext
	public boolean hasNext() {

		// == if the end is detected
		// while is needed if the next one is an empty array ?
		while (outer < v.length && inner == v[outer].length) {
			outer++;
			inner = 0;
		}

		return outer < v.length;
	}
}