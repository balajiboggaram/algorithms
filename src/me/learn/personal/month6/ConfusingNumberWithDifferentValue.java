/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 1056 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class ConfusingNumberWithDifferentValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConfusingNumberWithDifferentValue solution = new ConfusingNumberWithDifferentValue();
		System.out.println(solution.confusingNumber(6));

	}

	public boolean confusingNumber(int n) {

		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 0);
		map.put(1, 1);
		map.put(6, 9);
		map.put(9, 6);
		map.put(8, 8);

		int copyN = n;
		int res = 0;
		while (n != 0) {
			if(map.get(n%10) == null) return false;
			res = res * 10 + map.get(n % 10);
			n = n / 10;
		}
		return res != copyN;

	}

}
