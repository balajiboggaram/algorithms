/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 420 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */

/**
 * If the length of string is 3 or less, only insertion is needed;
If the length is 4, two insertions and might one replacement are needed;
if the length is 5, one insertion and might two replacements are needed.
So it's easy to solve for the case that length is less than 6: Math.Max(requiredChar, 6 - s.Length); The requiredChar is at most 3.

For the case, 6<=length<=20, only replacements are needed.

If length is greater than 20, only replacements and deletions are needed.
For the case of a repeated substring which length is mutiple of 3 (note 3n, e.g. "aaa"), then one deletion will save a replacement to fix it;
For the case of a repeated substring which length is mutiple of 3 plus 1 (note 3n+1, e.g. "aaaa"), then two deletions will save a replacement to fix it;
For the case of a repeated substring which length is mutiple of 3 plus 2 (note 3n+2, e.g. "aaaaa"), then three deletions will save a replacement to fix it;

That is.

"aaaaaaaaaaaaAsaxqwd1aaaa"

answer is 7:

"  aa*aa*aa*aAsaxqwd1aa  "

At first 12 a,
replace = 0 + 12/3 = 4
oned = 1
twod = 0

At last 4 a,
replace = 4+ 4/3 = 5
oned = 1
twod = 1

the source stirng length is 24
deleteCount is 24- 20 = 4;

replace = replace - Math.Min(deleteCount, oned) = 5 - Math.Min(4,1)= 4;
replace = replace - Math.Min(Math.Max(deleteCount - oned, 0), twod) / 2 = 4 - Math.Min(Math.Max(4 - 1, 0), 1) / 2 = 4;
replace = replace - Math.Max(deleteCount - oned - twod, 0) / 3 = 4 - Math.max(4 - 1 - 1, 0) / 3 = 4;

return deleteCount + Math.Max(requiredChar, replace) = 4 + Math.Max(0,4) = 8;



 *
 */
public class StrongPasswordChecker {

	public int strongPasswordChecker(String s) {
		
		// get total number of lowercase, uppercase or digit
		int requiredChar = getRequiredCharacters(s);
		
		if (s.length() < 6)
			return Math.max(requiredChar, 6 - s.length());

		// only need replacement and deletion now when s.Length >= 6
		int replace = 0; // total replacements for repeated chars. e.g. "aaa" needs 1 replacement to fix
		int oned = 0; // total deletions for 3n repeated chars. e.g. "aaa" needs 1 deletion to fix
		int twod = 0; // total deletions for 3n+1 repeated chars. e.g. "aaaa" needs 2 deletions to fix.

		// FIND OUT NUMBER OF REPLACE, DELETIONS
		for (int i = 0; i < s.length();) {
			
			int len = 1; // repeated len
			while (i + len < s.length() && s.charAt(i + len) == s.charAt(i + len - 1)) {
				len++;
			}
			
			if (len >= 3) {
				replace += len / 3;
				if (len % 3 == 0)
					oned += 1;
				if (len % 3 == 1)
					twod += 2;
			}
			i += len;
		}

		// no need deletion when s.Length <= 20
		if (s.length() <= 20)
			return Math.max(requiredChar, replace);

		int deleteCount = s.length() - 20;

		// deleting 1 char in (3n) repeated chars will save one replacement
		replace -= Math.min(deleteCount, oned);

		// deleting 2 chars in (3n+1) repeated chars will save one replacement
		replace -= Math.min(Math.max(deleteCount - oned, 0), twod) / 2;

		// deleting 3 chars in (3n+2) repeated chars will save one replacement
		replace -= Math.max(deleteCount - oned - twod, 0) / 3;

		return deleteCount + Math.max(requiredChar, replace);
	}

	int getRequiredCharacters(String s) {
		int lowercase = 1, uppercase = 1, digit = 1;
		for (var c : s.toCharArray()) {
			if (Character.isLowerCase(c))
				lowercase = 0;
			else if (Character.isUpperCase(c))
				uppercase = 0;
			else if (Character.isDigit(c))
				digit = 0;
		}

		return lowercase + uppercase + digit;
	}
}
