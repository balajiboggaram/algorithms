/**
 * 
 */
package me.learn.personal.month3;

import java.util.Arrays;

/**
 * Title 604 :
 * 
 * Design and implement a data structure for a compressed string iterator. It
 * should support the following operations: next and hasNext.
 * 
 * The given compressed string will be in the form of each letter followed by a
 * positive integer representing the number of this letter existing in the
 * original uncompressed string.
 * 
 * next() - if the original string still has uncompressed characters, return the
 * next letter; Otherwise return a white space. hasNext() - Judge whether there
 * is any letter needs to be uncompressed.
 * 
 * Note: Please remember to RESET your class variables declared in
 * StringIterator, as static/class variables are persisted across multiple test
 * cases. Please see here for more details.
 * 
 * Example:
 * 
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * 
 * iterator.next(); // return 'L' iterator.next(); // return 'e'
 * iterator.next(); // return 'e' iterator.next(); // return 't'
 * iterator.next(); // return 'C' iterator.next(); // return 'o'
 * iterator.next(); // return 'd' iterator.hasNext(); // return true
 * iterator.next(); // return 'e' iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 * 
 * 
 * @author bramanarayan
 * @date Jul 12, 2020
 */
public class DesignStringCompressedIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringIterator solution = new StringIterator("L1e2t1c1o1d1e1");
		while(solution.hasNext()) {
			System.out.println(solution.next());
		}
	}

}


class StringIterator {
    int ptr = 0;
    
    String[] chars;
    int[] nums;
    
    public StringIterator(String compressedString) {
    	
    	// split by one or more alphabets and capture in numbers
        nums = Arrays.stream(compressedString.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();;
        
        // split by numbers so that you get characters
        chars = compressedString.split("[0-9]+");
        
    }
    public char next() {
        if (!hasNext())
            return ' ';
        nums[ptr]--;
        char res=chars[ptr].charAt(0);
        if(nums[ptr]==0)
            ptr++;
        return res;
    }
    public boolean hasNext() {
        return ptr != chars.length;
    }
}

// pointer
// collapse with lengths
class StringIteratorMy {

	int ptr = 0;
	char[] c;
	int[] count;

	public StringIteratorMy(String compressedString) {

		int n = compressedString.length();
		int k = 0;
		c = new char[n];
		count = new int[n];

		for (int i = 0; i < n; i++) {
			char ch = compressedString.charAt(i);
			if (Character.isLetter(ch)) {
				System.out.println(ch);

				c[k] = ch;
			} else {
				int j = i;
				while (Character.isDigit(compressedString.charAt(j)) && j < n) {
					j++;
				}
				count[k] = Integer.parseInt(compressedString.substring(i, j));
				System.out.println(count[k]);
				k++;
			}

		}
	}

	public char next() {
		if (!hasNext())
			return ' ';

		char ch = c[ptr];
		count[ptr]--;
		if (count[ptr] == 0) {
			ptr++;
		}

		return ch;

	}

	public boolean hasNext() {
		return ptr < c.length && count[ptr] > 0;
	}
}
