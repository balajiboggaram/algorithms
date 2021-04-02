/**
 * 
 */
package me.learn.personal.month5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title 737 :
 * 
 * Date : Jan 4, 2021
 * 
 * @author bramanarayan
 *
 */
public class SentenceSimilarityTransitiveAllowed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Transitive allowed - a pure find and union disjoint set based solution
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
		
		
		if(words1.length != words2.length) return false;

		// prepare the parent map - each node is a word
		// initially every work is a parent of themself
		Map<String, String> parent = new HashMap<String, String>();
		for (List<String> pair : pairs) {
			parent.put(pair.get(0), pair.get(0));
			parent.put(pair.get(1), pair.get(1));

		}

		// now, enumerate the relations
		for (List<String> pair : pairs) {
			union(pair.get(0), pair.get(1), parent);
		}

		// at this point, we have the all disjoint sets ready.
		// all disjoint set information is populated via parentMap.

		for (int i = 0; i < words1.length; i++) {
			
			String word1 = parent.get(words1[i]);
			String word2 = parent.get(words2[i]);
			
			
			// this is application specific. ensure the parents of words1 and words2 match -
			// this indicates both are related. if not false
			//if(parent.get(words1[i]) == null) return false;
			
			
			if(!getParent(word1, parent).equals(getParent(word2,parent))) {
				return false;
			}
			
		}
		return true;

	}

	private void union(String x, String y, Map<String, String> parentMap) {
		String parentX = getParent(x, parentMap);
		String parentY = getParent(y, parentMap);

		parentMap.put(parentX, parentY);
	}

	// zig zag on parent map until you find a node who is itself a parent. That is
	// the terminating. root node in that disjoint set.
	private String getParent(String word, Map<String, String> parentMap) {
		
		if(parentMap.get(word) == null) return word;

		while (parentMap.get(word) != word) {
			word = parentMap.get(word);
		}
		return word;

	}

}
