/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Title 734 :
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class SentenceSimilarity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SentenceSimilarity solution = new SentenceSimilarity();

		String[] s1 = new String[] { "an", "extraordinary", "meal" };
		String[] s2 = new String[] { "one", "good", "dinner" };

		String[][] s3 = new String[][] { { "great", "good" }, { "extraordinary", "good" }, { "well", "good" },
				{ "wonderful", "good" }, { "excellent", "good" }, { "fine", "good" }, { "nice", "good" },
				{ "any", "one" }, { "some", "one" }, { "unique", "one" }, { "the", "one" }, { "an", "one" },
				{ "single", "one" }, { "a", "one" }, { "truck", "car" }, { "wagon", "car" }, { "automobile", "car" },
				{ "auto", "car" }, { "vehicle", "car" }, { "entertain", "have" }, { "drink", "have" },
				{ "eat", "have" }, { "take", "have" }, { "fruits", "meal" }, { "brunch", "meal" },
				{ "breakfast", "meal" }, { "food", "meal" }, { "dinner", "meal" }, { "super", "meal" },
				{ "lunch", "meal" }, { "possess", "own" }, { "keep", "own" }, { "have", "own" },
				{ "extremely", "very" }, { "actually", "very" }, { "really", "very" }, { "super", "very" } };

		List<List<String>> pairs = new ArrayList<>();
		for (int i = 0; i < s3.length; i++) {
			List<String> temp = new ArrayList<String>();
			temp.add(s3[i][0]);
			temp.add(s3[i][1]);
			pairs.add(temp);
		}

		System.out.println(solution.areSentencesSimilar(s1, s2, pairs));

	}

	// Transitive words are NOT Allowed. that makes hashmap and hashset a perfect combination
	public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

		if (similarPairs.size() == 0)
			return true;

		int m = sentence1.length;
		int n = sentence2.length;
		if (m != n)
			return false;

		Map<String, HashSet<String>> map = new HashMap<>();

		for (List<String> pairs : similarPairs) {

			String w1 = pairs.get(0);
			String w2 = pairs.get(1);

			// map do not containe both words. so add them
			map.putIfAbsent(w1, new HashSet<String>());
			map.putIfAbsent(w2, new HashSet<String>());
			map.get(w1).add(w2);
			map.get(w2).add(w1);

		}

		for (int i = 0; i < m; i++) {
			if(sentence1[i].equals(sentence2[i])) continue;
			if(!map.containsKey(sentence1[i])) return false;
			if ((!map.get(sentence1[i]).contains(sentence2[i])))
				return false;
		}

		return true;

	}

}
