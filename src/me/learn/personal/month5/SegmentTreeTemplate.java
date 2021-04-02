/**
 * 
 */
package me.learn.personal.month5;

/**
 * Title :
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 * 
 *         ref
 *         https://github.com/mission-peace/interview/blob/94be5deb0c0df30ade2a569cf3056b7cc1e012f4/src/com/interview/tree/SegmentTreeMinimumRangeQuery.java#L37
 *
 */
public class SegmentTreeTemplate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * CREATES A SEGMENT TREE for INPUT Array
	 */
	public int[] createSegmentTree(int input[]) {

		// if input len is pow of 2 then size of segment tree is 2*len - 1, otherwise
		// size of segment tree is next (pow of 2 for len)*2 - 1.
		int nextPowOfTwo = nextPowerOf2(input.length);

		int segmentTree[] = new int[nextPowOfTwo * 2 - 1]; // to allocate the size of segment tree array

		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = Integer.MAX_VALUE;
		}

		constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0); // this logic depends on application

		return segmentTree;

	}

	// here pos point to index in segment tree
	// low -> points to start of input array
	// high -> points to end of input array
	public void constructMinSegmentTree(int[] segTree, int[] input, int low, int high, int pos) {

		// single element in recursion - imagine the merge step
		if (low == high) {
			segTree[pos] = input[low];
			return;
		}

		int mid = low + (high - low) / 2;
		constructMinSegmentTree(segTree, input, low, mid, 2 * pos + 1);
		constructMinSegmentTree(segTree, input, low, mid, 2 * pos + 2);
		segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]); // minimum of left and right child

	}

	// qlow -> start index i of input array
	// qhigh -> end index j of input array
	// len -> total length of input array
	// example : st.rangeMinimumQuery(segTree, 1, 5, input.length); get minimum in
	// range from 1 to 5
	public int rangeMinimumQuery(int[] segTree, int qlow, int qhigh, int len) {
		return rangeMinimumQuery(segTree, 0, len - 1, qlow, qhigh, 0);
	}

	// low, high is the segment of tree
	// qlow,qhigh - input range of our query
	// pos -> start search point in the segment tree. its always '0'.
	int rangeMinimumQuery(int segmentTree[], int low, int high, int qlow, int qhigh, int pos) {

		// total coverage [qlow, low ----> high , qHigh]
		if (low >= qlow && high <= qhigh) {
			return segmentTree[pos];
		}

		// No coverage [ qlow, qhigh, low, high or low high ?? qlow qhigh ]
		if (qlow > high || low > qhigh) {
			return Integer.MAX_VALUE; // just return the maximum possible as you need the minimum in anser
		}

		int mid = low + (high - low) / 2;
		return Math.min(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
				rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 2));
	}

	// give the next power of 2 for a given number.
	public int nextPowerOf2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

	// update segment tree for certain index by delta
	// tc is still O logn)

	void updateSegmentTree(int[] input, int[] segTree, int index, int delta) {
		input[index] += delta;// add this delta to the input array

		// update in the segment tree too
		updateUtil(segTree, index, delta, 0, input.length - 1, 0);

	}

	// Update the delta for only SINGLE index
	private void updateUtil(int[] segTree, int index, int delta, int low, int high, int pos) {

		if (index < low || index > high)
			return;
		; // invalid range

		// if low and high become equal, then index will be also equal to them and
		// update
		// that value in segment tree at pos
		if (low == high) {
			segTree[pos] += delta;
			return;
		}

		// otherwise keep going left and right to find index to be updated
		// and then update current tree position if min of left or right has
		// changed.
		int mid = low + (high - low) / 2;
		updateUtil(segTree, index, delta, low, mid, 2 * pos + 1);
		updateUtil(segTree, index, delta, mid + 1, high, 2 * pos + 2);
		segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
	}

	// Update delta for a range qlow, qhigh
	private void updateSegmentTreeRange(int segmentTree[], int qlow, int qhigh, int delta, int low, int high, int pos) {
		if (low > high || qlow > high || qhigh < low) {
			return;
		}

		if (low == high) {
			segmentTree[pos] += delta;
			return;
		}

		int middle = (low + high) / 2;
		updateSegmentTreeRange(segmentTree, qlow, qhigh, delta, low, middle, 2 * pos + 1);
		updateSegmentTreeRange(segmentTree, qlow, qhigh, delta, middle + 1, high, 2 * pos + 2);
		segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}
	
	
	
	
	
	// TREE BASED REP - its lot better to understand ;) 
	// convert array to actual Tree

class NumArray {

	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int sum;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}

	SegmentTreeNode root = null;

	public NumArray(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		} else {
			SegmentTreeNode ret = new SegmentTreeNode(start, end);
			if (start == end) {
				ret.sum = nums[start];
			} else {
				int mid = start + (end - start) / 2;
				ret.left = buildTree(nums, start, mid);
				ret.right = buildTree(nums, mid + 1, end);
				ret.sum = ret.left.sum + ret.right.sum;
			}
			return ret;
		}
	}

	void update(int i, int val) {
		update(root, i, val);
	}

	void update(SegmentTreeNode root, int pos, int val) {
		if (root.start == root.end) {
			root.sum = val;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (pos <= mid) {
				update(root.left, pos, val);
			} else {
				update(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	public int sumRange(SegmentTreeNode root, int start, int end) {
		if (root.end == end && root.start == start) {
			return root.sum;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (end <= mid) {
				return sumRange(root.left, start, end);
			} else if (start >= mid + 1) {
				return sumRange(root.right, start, end);
			} else {
				return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
			}
		}
	}
}
}

