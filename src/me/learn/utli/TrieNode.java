package me.learn.utli;

/**
 * 
 * Title : A simple POJO that represent a node in Trie/Prefix trees
 * 
 * @author bramanarayan
 * @date May 16, 2020
 */
public class TrieNode {

	public char c;
	public TrieNode[] nodes;
	public boolean isWord;

	public TrieNode(char c) {
		this.c = c;
		nodes = new TrieNode[26];
		this.isWord = false;
	}

}
