/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Title 642 :
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class AutoCompleteSystemWithFrequency {

}
/**
 *  A TRIE NODE WITH FREQUENCY
 *
 */
class TrieNode implements Comparable<TrieNode> {
	TrieNode[] children;
	String s;
	int times;
	List<TrieNode> hot; // hot list stored at each node (prefix'd)

	public TrieNode() {
		children = new TrieNode[128];
		s = null;
		times = 0;
		hot = new ArrayList<>();
	}

	public int compareTo(TrieNode o) {
		if (this.times == o.times) {
			return this.s.compareTo(o.s);
		}

		return o.times - this.times;
	}

	public void update(TrieNode node) {
		if (!this.hot.contains(node)) {
			this.hot.add(node);
		}

		Collections.sort(hot);

		if (hot.size() > 3) {
			hot.remove(hot.size() - 1);
		}
	}
}

class AutocompleteSystem {

	TrieNode root;
	TrieNode cur;
	StringBuilder sb;

	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
		cur = root;
		sb = new StringBuilder();

		for (int i = 0; i < times.length; i++) {
			insert(sentences[i], times[i]);
		}
	}

	public void insert(String sentence, int t) {
		TrieNode curNode = root;

		List<TrieNode> visited = new ArrayList<>();
		
		for (char c : sentence.toCharArray()) {
			if (curNode.children[c] == null) {
				curNode.children[c] = new TrieNode();
			}

			curNode = curNode.children[c];
			visited.add(curNode);
		}

		curNode.s = sentence;
		curNode.times += t;

		// for every intermediate node you visited in the path, add  this leaf in its hot list
		for (TrieNode node : visited) {
			node.update(curNode);
		}
	}

	// This is where the user will start typing the characters now..
	public List<String> input(char c) {
		
		List<String> res = new ArrayList<>();
		
		// as soon as they type # 
		if (c == '#') {
			insert(sb.toString(), 1);
			sb = new StringBuilder();
			cur = root;
			return res;
		}

		sb.append(c);
		if (cur != null) {
			cur = cur.children[c]; // advance to next node based on what you see in input characters
		}

		// lets If you dont see any node matching in your tree, just return the result you have.
		if (cur == null)
			return res;
		
		// add all the hot words in current node to result
		for (TrieNode node : cur.hot) {
			res.add(node.s);
		}

		return res;
	}
}