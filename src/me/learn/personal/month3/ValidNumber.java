/**
 * 
 */
package me.learn.personal.month3;

/**
 * Title 65 :
 * 
 *  Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

    Numbers 0-9
    Exponent - "e"
    Positive/negative sign - "+"/"-"
    Decimal point - "."

 * 
 * @author bramanarayan
 * @date Jul 21, 2020
 */
public class ValidNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// BS Question for interviews
	public boolean isNumber(String s) {
		s = s.trim();
		int n = s.length();

		if(s.length() == 0) return false;
		
		boolean pointSeen = false;
		boolean eSeen = false;
		boolean nSeen = false;
		
		for(int i = 0;i< n;i++) {
			char ch = s.charAt(i);
			
			if(ch >= '0' && ch <= '9') {
				nSeen = true;
			} else if(ch == '.') {
				// . and e cannot exist any same time
				// duplicate point cannot exist same time
				if(eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			} else if (ch == 'e') {
				
				// you should see a number before e for sure
				// you cannot have two e's in one number
				if(eSeen || !nSeen) {
					return false;
				}
				eSeen = true;
				nSeen = false; // reset to find after e 
				pointSeen = false; // e is nothing but a point
			} else if(ch == '-' || ch == '+') {
				// you cannot have a - or  + unless its beginning or i-1 is a e character
				if(pointSeen || nSeen) {
					return false;
				}
				nSeen = false; // reset
			} else {
				return false;
			}
 		}
		return nSeen;
	}

}
