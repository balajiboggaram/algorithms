package me.learn.personal.month1;

import me.learn.utli.TrieNode;

/**
 * 
 * Title 208 : Implement a trie with insert, search, and startsWith methods.
 * 
 * @author bramanarayan
 * @date May 16, 2020
 */
public class Trie {

	TrieNode head;

	public static void main(String args[]) {
		Trie trie = new Trie();
		// trie.insert("apple");
		// System.out.println(trie.search("apple"));
		// System.out.println(trie.search("app"));
		// System.out.println(trie.startsWith("app"));
		// trie.insert("apples");
		// System.out.println(trie.startsWith("apple"));

		trie.insert("a");
		System.out.println(trie.search("a"));
		System.out.println(trie.startsWith("a"));
	}

	/** Initialize your data structure here. */
	public Trie() {
		this.head = new TrieNode('#');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (word == null)
			return;
		TrieNode cur = head;
		for (char c : word.toCharArray()) {
			if (cur.nodes[c - 'a'] == null) {
				TrieNode temp = new TrieNode(c);
				cur.nodes[c - 'a'] = temp;
			}
			cur = cur.nodes[c - 'a'];
		}
		cur.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		if (word == null || word.length() == 0)
			return true;
		TrieNode cur = head;
		for (char c : word.toCharArray()) {
			if (cur.nodes[c - 'a'] == null)
				return false;
			cur = cur.nodes[c - 'a'];
		}
		return cur.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0)
			return true;
		TrieNode cur = head;
		for (char c : prefix.toCharArray()) {
			if (cur.nodes[c - 'a'] == null)
				return false;
			cur = cur.nodes[c - 'a'];
		}
		return true;
		// return checkAnyChild(cur);
	}

	/**
	 * A word can be a prefix of other words. Ex : apple vs apples.
	 * 
	 * a strict prefix is not a word or we can assume a prefix is also a word. then
	 * this method is not useful.
	 * 
	 */
	private boolean checkAnyChild(TrieNode cur) {
		TrieNode[] nodes = cur.nodes;
		for (TrieNode n : nodes) {
			if (n != null && n.c != '\u0000')
				return true;
		}
		return false;
	}

}
