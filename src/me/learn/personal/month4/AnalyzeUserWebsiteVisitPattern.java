/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Title 1152 :
 * 
 * We are given some website visits: the user with name username[i] visited the
 * website website[i] at time timestamp[i].
 * 
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by
 * the time of their visits. (The websites in a 3-sequence are not necessarily
 * distinct.)
 * 
 * Find the 3-sequence visited by the largest number of users. If there is more
 * than one solution, return the lexicographically smallest such 3-sequence.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: username =
 * ["joe","joe","joe","james","james","james","james","mary","mary","mary"],
 * timestamp = [1,2,3,4,5,6,7,8,9,10], website =
 * ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"] Explanation: The tuples in this example
 * are: ["joe", 1, "home"] ["joe", 2, "about"] ["joe", 3, "career"] ["james", 4,
 * "home"] ["james", 5, "cart"] ["james", 6, "maps"] ["james", 7, "home"]
 * ["mary", 8, "home"] ["mary", 9, "about"] ["mary", 10, "career"] The
 * 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 * 
 * @author bramanarayan
 * @date Aug 22, 2020
 */
public class AnalyzeUserWebsiteVisitPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AnalyzeUserWebsiteVisitPattern solution = new AnalyzeUserWebsiteVisitPattern();

		/*
		 * String[] users = new String[]
		 * {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
		 * String[] pages = new String[]
		 * {"home","about","career","home","cart","maps","home","home","about","career"}
		 * ; int[] time = new int[] {1,2,3,4,5,6,7,8,9,10};
		 */
		String[] users = new String[] { "u1", "u1", "u1", "u2", "u2", "u2" };
		String[] pages = new String[] { "a", "b", "c", "a", "b", "a" };
		int[] time = new int[] { 1, 2, 3, 4, 5, 6 };
		/**
		 * ["u1","u1","u1","u2","u2","u2"] [1,2,3,4,5,6] ["a","b","c","a","b","a"]
		 */

		solution.mostVisitedPattern(users, time, pages);
	}

	class Visit {
		String userName;
		int timestamp;
		String website;

		Visit(String u, int t, String w) {
			userName = u;
			timestamp = t;
			website = w;
		}

		Visit() {
		}
	}

	// Entry point
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

		// Convert all the entry as visit object to ease of understand
		List<Visit> visitList = new ArrayList<>();
		for (int i = 0; i < username.length; i++) {

			visitList.add(new Visit(username[i], timestamp[i], website[i]));
		}

		// Sort all the visit entries using their timestamp -> ADOPT IT !!!!
		Comparator<Visit> cmp = (v1, v2) -> {
			return v1.timestamp - v2.timestamp;
		};
		Collections.sort(visitList, cmp);

		// Collect list of websites for each user
		Map<String, List<String>> userWebSitesMap = new HashMap<>();
		for (Visit v : visitList) {
			userWebSitesMap.putIfAbsent(v.userName, new ArrayList<>());
			userWebSitesMap.get(v.userName).add(v.website);
		}

		Map<List<String>, Integer> seqUserFreMap = new HashMap<>();
		// Now get all the values of all the users
		for (List<String> websitesList : userWebSitesMap.values()) {
			if (websitesList.size() < 3)
				continue; // no need to consider less than 3 entries of web site visited by user

			// if its more than or equal to 3.
			Set<List<String>> sequencesSet = generate3Seq(websitesList);
			// Now update the frequency of the sequence ( increment by 1 for 1 user)
			for (List<String> seq : sequencesSet) {
				seqUserFreMap.putIfAbsent(seq, 0);
				seqUserFreMap.put(seq, seqUserFreMap.get(seq) + 1);
			}
		}

		List<String> res = new ArrayList<>();
		int MAX = 0;
		for (Map.Entry<List<String>, Integer> entry : seqUserFreMap.entrySet()) {
			if (entry.getValue() > MAX) {
				MAX = entry.getValue();
				res = entry.getKey();
			} else if (entry.getValue() == MAX) {
				// for lexicographic sort requirement
				if (entry.getKey().toString().compareTo(res.toString()) < 0) {
					res = entry.getKey();
				}
			}
		}
		return res;
	}

	// It will not return duplicate seq for each user that why we are using Set
	private Set<List<String>> generate3Seq(List<String> websitesList) {
		Set<List<String>> setOfListSeq = new HashSet<>();
		for (int i = 0; i < websitesList.size(); i++) {
			for (int j = i + 1; j < websitesList.size(); j++) {
				for (int k = j + 1; k < websitesList.size(); k++) {
					List<String> list = new ArrayList<>();
					list.add(websitesList.get(i));
					list.add(websitesList.get(j));
					list.add(websitesList.get(k));
					setOfListSeq.add(list);
				}
			}
		}
		return setOfListSeq;
	}

	// MY sol

	public List<String> mostVisitedPatternMy(String[] username, int[] timestamp, String[] website) {

		// user -> pages visited
		Map<String, List<String>> map = new HashMap<>();

		// pattern 3 tuple -> count
		TreeMap<String, Integer> count = new TreeMap<>();

		int n = username.length;
		for (int i = 0; i < n; i++) {
			String user = username[i];
			String page = website[i];
			int time = timestamp[i];

			map.computeIfAbsent(user, x -> new ArrayList<String>()).add(page);
			if (map.get(user).size() >= 3) {
				String pattern = get3Tuple(map.get(user));
				count.put(pattern, count.getOrDefault(pattern, 0) + 1);
			}

		}

		int max = Collections.max(count.values());

		List<String> resultSet = count.entrySet().stream().filter(e -> e.getValue() == max).map(e -> e.getKey())
				.collect(Collectors.toList());
		Collections.sort(resultSet);
		String maxPattern = resultSet.get(0);

		String[] websites = maxPattern.split("#");

		List<String> result = new ArrayList<String>();
		result.add(websites[0]);
		result.add(websites[1]);
		result.add(websites[2]);

		return result;
	}

	private String get3Tuple(List<String> list) {
		int n = list.size();
		return String.format("%s#%s#%s", list.get(n - 3), list.get(n - 2), list.get(n - 1));
	}

}
