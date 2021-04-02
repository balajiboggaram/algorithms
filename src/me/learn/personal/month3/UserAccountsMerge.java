/**
 * 
 */
package me.learn.personal.month3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Title :
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class UserAccountsMerge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		
		// parents are themselves to start with
		int[] parents = new int[accounts.size()];
		for (int i = 0; i < accounts.size(); i++) {
			parents[i] = i;
		}
		
		//  email address -> id of owner
		Map<String, Integer> owners = new HashMap<>();
		
		for (int id = 0; id < accounts.size(); id++) {
			// iterate all the emails
			for (int j = 1; j < accounts.get(id).size(); j++) {
				
				String email = accounts.get(id).get(j);
				
				if (owners.containsKey(email)) { // there is already a person with this email. so we need to consider this person as 
					int existPersonId = owners.get(email);
					int p1 = findParent(parents, id);
					int p2 = findParent(parents, existPersonId);
					if (p1 != p2) {
						parents[p2] = p1;
					}
				} else {
					owners.put(email, id);
				}
			}
		}

		// account ID -> set of emails
		Map<Integer, TreeSet<String>> users = new HashMap<>();
		for (int i = 0; i < accounts.size(); i++) {
			int parent = findParent(parents, i);
			List<String> emails = accounts.get(i);
			
			// use computeIfAbsent
			users.putIfAbsent(parent, new TreeSet<String>());
			users.get(parent).addAll(emails.subList(1, emails.size())); // add all ith emais to its parent
		}

		// list of <username -> list of emails>
		List<List<String>> res = new ArrayList<List<String>>();
		for (Integer idx : users.keySet()) { // these are the only parent account with unique persons
			String name = accounts.get(idx).get(0);
			ArrayList<String> emails = new ArrayList<>(users.get(idx));
			emails.add(0, name);
			res.add(emails);
		}
		return res;
	}

	private int findParent(int[] parents, int idx) {
		while (idx != parents[idx]) {
			parents[idx] = parents[parents[idx]];
			idx = parents[idx];
		}
		return idx;
	}

}
