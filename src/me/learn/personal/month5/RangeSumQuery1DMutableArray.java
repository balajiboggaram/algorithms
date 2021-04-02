/**
 * 
 */
package me.learn.personal.month5;

import me.learn.personal.month5.SegmentTreeTemplate.NumArray.SegmentTreeNode;

/**
 * Title 307:
 * 
 * Date : Jan 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class RangeSumQuery1DMutableArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// the value in the array can keep changing

	// Concept here is SegmentTree

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

		
		/*
		 * 
		 * INTEGER ARRAY INPUT - ENTRYPOINT
		 */
		private SegmentTreeNode buildTree(int[] nums, int start, int end) {
			if (start > end) {
				return null;
			} else {
				SegmentTreeNode root = new SegmentTreeNode(start, end);
				if (start == end) {
					root.sum = nums[start];
				} else {
					int mid = start + (end - start) / 2;
					root.left = buildTree(nums, start, mid);
					root.right = buildTree(nums, mid + 1, end);
					root.sum = root.left.sum + root.right.sum;
				}
				return root;
			}
		}

		void update(int i, int val) {
			update(root, i, val);
		}

		void update(SegmentTreeNode root, int qIndex, int val) {
			if (root.start == root.end) {
				root.sum = val;
			} else {
				int mid = root.start + (root.end - root.start) / 2;
				if (qIndex <= mid) {
					update(root.left, qIndex, val);
				} else {
					update(root.right, qIndex, val);
				}
				root.sum = root.left.sum + root.right.sum;
			}
		}

		public int sumRange(int i, int j) {
			return sumRange(root, i, j);
		}

		public int sumRange(SegmentTreeNode root, int qStart, int qEnd) {
			if (root.end == qEnd && root.start == qStart) {
				return root.sum;
			} else {
				int mid = root.start + (root.end - root.start) / 2;
				if (qEnd <= mid) {
					return sumRange(root.left, qStart, qEnd);
				} else if (qStart >= mid + 1) {
					return sumRange(root.right, qStart, qEnd);
				} else {
					return sumRange(root.right, mid + 1, qEnd) + sumRange(root.left, qStart, mid);
				}
			}
		}
	}

}
