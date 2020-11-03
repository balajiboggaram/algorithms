
package me.learn.personal.monthlychallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Title : Given an array of strings, group anagrams together.
 * 
 * We will use Map of Maps to solve this problem in O(NM).
 * 
 * The inner map will be used to track the frequencies where as the outer map
 * will be used to track if an existence of frequency map.
 * 
 * @author bramanarayan
 * @date Apr 29, 2020
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();
		solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> resultSet = new ArrayList<>();
		HashMap<HashMap<Character, Integer>, ArrayList<String>> globalMap = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();

		for (String s : strs) {
			HashMap<Character, Integer> tempMap = populateTempMap(s);
			if (globalMap.containsKey(tempMap)) {
				globalMap.get(tempMap).add(s);
			} else {
				ArrayList<String> anagramList = new ArrayList<String>();
				anagramList.add(s);
				globalMap.put(tempMap, anagramList);
			}
		}

		// Formulate the resultset from globalMap
		resultSet.addAll(globalMap.values());

		return resultSet;
	}

	private HashMap<Character, Integer> populateTempMap(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

	/**
	 * LC submission
	 * 
	 * In this example, The person has taken the integer 26 count array 
	 * repeatations (with incremented) as the key in the hashMap. So, the key will be 
	 * 0103.... i.e 0-As, 1-B, 0-C, 3 -Ds and so on..
	 * 
	 * Unique perspective to think on. Instead of  maps of map. we can use 
	 * Map of <String and list>
	 */
	public List<List<String>> groupAnagramsLC(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (String word : strs) {
			char[] hash = new char[26];
			for (char ch : word.toCharArray()) {
				hash[ch - 'a']++;
			}
			String key = new String(hash);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(word);
		}
		for (String key : map.keySet()) {
			res.add(map.get(key));
		}
		return res;
	}

}
