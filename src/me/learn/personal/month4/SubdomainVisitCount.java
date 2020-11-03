/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Title 811 :
 * 
 * A website domain like "discuss.leetcode.com" consists of various subdomains.
 * At the top level, we have "com", at the next level, we have "leetcode.com",
 * and at the lowest level, "discuss.leetcode.com". When we visit a domain like
 * "discuss.leetcode.com", we will also visit the parent domains "leetcode.com"
 * and "com" implicitly.
 * 
 * Now, call a "count-paired domain" to be a count (representing the number of
 * visits this domain received), followed by a space, followed by the address.
 * An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * 
 * We are given a list cpdomains of count-paired domains. We would like a list
 * of count-paired domains, (in the same format as the input, and in any order),
 * that explicitly counts the number of visits to each subdomain.
 * 
 * Example 1: Input: ["9001 discuss.leetcode.com"] Output: ["9001
 * discuss.leetcode.com", "9001 leetcode.com", "9001 com"] Explanation: We only
 * have one website domain: "discuss.leetcode.com". As discussed above, the
 * subdomain "leetcode.com" and "com" will also be visited. So they will all be
 * visited 9001 times.
 * 
 * Example 2: Input: ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com",
 * "5 wiki.org"] Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5
 * wiki.org","5 org","1 intel.mail.com","951 com"] Explanation: We will visit
 * "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and
 * "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 =
 * 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class SubdomainVisitCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubdomainVisitCount solution = new SubdomainVisitCount();
		System.out.println(solution.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
	}

	// Easy when implemented reverse traversal character by character.
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<>();
		for(String domain : cpdomains) {
			String[] params = domain.split("\\s+");
			int count = Integer.parseInt(params[0]);
			
			
			String[] tokens = params[1].split("\\.");
			StringBuilder sb = new StringBuilder();
			for(int i = tokens.length-1; i >=0; i--) {
				//sb.append(tokens[i]);
				sb.insert(0, tokens[i] + ".");
				String key = sb.toString().substring(0, sb.toString().length()-1);
				map.put(key, map.getOrDefault(key, 0) + count);
				System.out.println(sb.toString());
			}
		
		}
		
		List<String> result = new ArrayList<String>();
		for(Entry e : map.entrySet()) {
			result.add(e.getValue() + " " + e.getKey());
		}
		
		return result;
	}

}
