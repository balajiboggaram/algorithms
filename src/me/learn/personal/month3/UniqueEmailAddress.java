/**
 * 
 */
package me.learn.personal.month3;

import java.util.HashSet;
import java.util.Set;

/**
 * Title 929 :
 * 
 * Every email consists of a local name and a domain name, separated by the @
 * sign.
 * 
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com
 * is the domain name.
 * 
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * 
 * If you add periods ('.') between some characters in the local name part of an
 * email address, mail sent there will be forwarded to the same address without
 * dots in the local name. For example, "alice.z@leetcode.com" and
 * "alicez@leetcode.com" forward to the same email address. (Note that this rule
 * does not apply for domain names.)
 * 
 * If you add a plus ('+') in the local name, everything after the first plus
 * sign will be ignored. This allows certain emails to be filtered, for example
 * m.y+name@email.com will be forwarded to my@email.com. (Again, this rule does
 * not apply for domain names.)
 * 
 * It is possible to use both of these rules at the same time.
 * 
 * Given a list of emails, we send one email to each address in the list. How
 * many different addresses actually receive mails?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2 Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com"
 * actually receive mails
 * 
 * 
 * @author bramanarayan
 * @date Jul 12, 2020
 */
public class UniqueEmailAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public int numUniqueEmails(String[] emails) {
		Set<String> unique = new HashSet<String>();
		for(String email: emails) {
			unique.add(parseEmail(email));
		}
		return unique.size();
	}

	private String parseEmail(String email) {
		String[] token = email.split("@");
		String local = null;
		String domain = null;
		if(token.length == 2) {
			local = token[0];
			domain = token[1];
			
			// replace all the . dots
			local = local.replaceAll("\\.", "");
			
			// Fetch anything before first +
			local = local.split("\\+")[0];
			
		}
		
		return local + "@" + domain;
	}
	
	

}
