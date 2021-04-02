/**
 * 
 */
package me.learn.personal.month6;

import me.learn.personal.month1.ListNode;

/**
 * Title 1474 :
 * 
 * Date : Jan 10, 2021
 * 
 * @author bramanarayan
 *
 */
public class DeleteLinkedListPreserveMDeleteNPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Its easy but always try to pick example and trace in linkes list to eliminate
	// mispointing the pointers
	public ListNode deleteNodes(ListNode head, int m, int n) {

		if (n == 0)
			return head;

		ListNode cur = head;

		while (cur != null) {

			// traverse mNodes now
			ListNode mCur = cur;
			ListNode mPrev = null;
			int count = 0;
			while (mCur != null && count < m) {
				count++;
				mPrev = mCur;
				mCur = mCur.next;
			}

			// delete n nodes now
			ListNode nCur = mCur;
			count = 0;
			while (nCur != null && count < n) {
				count++;
				nCur = nCur.next;
			}

			// repeat the pattern again
			mPrev.next = nCur;
			cur = nCur;

		}
		return head;

	}

}
