/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 760 :
 * 
 * Date : Jan 6, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindAnagramMappings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] anagramMappings(int[] a, int[] b) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < b.length; i++) {
			map.put(b[i], i);
		}

		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = map.get(a[i]);
		}
		return result;
	}

}
