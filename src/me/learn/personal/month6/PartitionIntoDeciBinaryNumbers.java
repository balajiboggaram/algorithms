/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 1689 :
 * 
 * Date : Feb 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class PartitionIntoDeciBinaryNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPartitions(String n) {
		if (n == null)
			return 0;
		int res = 0;
		for (int i = 0; i < n.length(); i++) {
			res = Math.max(res, n.charAt(i) - '0');
		}
		return res;
	}

}
