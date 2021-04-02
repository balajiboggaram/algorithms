/**
 * 
 */
package me.learn.personal.month6;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 246 :
 * 
 * Date : Jan 12, 2021
 * 
 * @author bramanarayan
 *
 */
public class StroboGrammaticNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StroboGrammaticNumber solution = new StroboGrammaticNumber();
		System.out.println(solution.isStrobogrammatic("69"));
	}

	// almost same as ConfusingNumberWithDifferentValue
	// this number looks same when rotated in 180 degrees
	public boolean isStrobogrammatic(String num) {

		long n = Long.parseLong(num);

		Map<Long, Long> map = new HashMap<>();

		map.put((long) 0, (long) 0);
		map.put((long) 1, (long) 1);
		map.put((long) 6, (long) 9);
		map.put((long) 9, (long) 6);
		map.put((long) 8, (long) 8);

		long copyN = n;
		long res = 0;
		while (n != 0) {
			System.out.println(n);
			if (map.get(n % 10) == null)
				return false;
			res = res * 10 + map.get(n % 10);
			n = n / 10;
		}
		System.out.println(res);
		return res == copyN;
	}
	
	// OR if its a string
	// maintain a map of character to character mapping
	// Iterate from last character of String
		// if ch is not in map -> false
		// if ch is in map -> append its mapping in string builder
	// finally do string equals on input and stringbuilder
	
	// or 
	
	// more interlligent to avoid stringbuilder
	public boolean isStrobogrammaticBEST(String num) {
	    Map<Character, Character> map = new HashMap<Character, Character>();
	    map.put('6', '9');
	    map.put('9', '6');
	    map.put('0', '0');
	    map.put('1', '1');
	    map.put('8', '8');
	   
	    int l = 0, r = num.length() - 1;
	    while (l <= r) {
	        if (!map.containsKey(num.charAt(l))) return false;
	        if (map.get(num.charAt(l)) != num.charAt(r))
	            return false;
	        l++;
	        r--;
	    }
	    
	    return true;
	}

}
