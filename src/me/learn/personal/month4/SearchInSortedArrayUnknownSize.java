/**
 * 
 */
package me.learn.personal.month4;

/**
 * Title 702 :
 * 
 * @author bramanarayan
 * @date Aug 3, 2020
 */
public class SearchInSortedArrayUnknownSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(ArrayReader reader, int target) {

		if (target == reader.get(0))
			return 0;

		// define the boundaries, Stretch on right side only. thats enough
		int l = 0;
		int h = 1;
		while(reader.get(h) < target) {
			l = h;
			h = h * 2;
		}

		return findBSIndex(reader, target, l, h);
	}

	private int findBSIndex(ArrayReader reader, int target, int l, int h) {
		while (l <= h) {
			int mid = l + (h - l) / 2;
			int x = reader.get(mid);
			if (x == target) {
				return mid;
			} else if (x < target) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}

}

// Mocker
class ArrayReader {

	public int get(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
