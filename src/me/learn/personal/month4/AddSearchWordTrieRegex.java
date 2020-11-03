/**
 * 
 */
package me.learn.personal.month4;

import me.learn.utli.TrieNode;

/**
 * Title 211 :
 * 
 * ou should design a data structure that supports adding new words and finding
 * if a string matches any previously added string.
 * 
 * Implement the WordDictionary class:
 * 
 * WordDictionary() Initializes the object. void addWord(word) adds word to the
 * data structure, it can be matched later. bool search(word) returns true if
 * there is any string in the data structure that matches word or false
 * otherwise. word may contain dots '.' where dots can be matched with any
 * letter.
 * 
 * 
 * 
 * @author bramanarayan
 * @date Aug 23, 2020
 */
public class AddSearchWordTrieRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordDictionary solution = new WordDictionary();
		solution.search("a");
		
		solution.addWord("bad");
		System.out.println(solution.search("b.e"));
		System.out.println(solution.search("bad"));
		System.out.println(solution.search("e.d"));
		System.out.println(solution.search("ba."));

	}

}

class WordDictionary {
	
	TrieNode head;

	public WordDictionary() {
		this.head = new TrieNode('#');
	}
	
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchUtil(word, 0, head);
    }
    
    private boolean searchUtil(String w, int index, TrieNode cur) {

    	if(index == w.length())  return true;// we found the word
    	if(cur == null) return false;
    	char ch = w.charAt(index);
    	
    	if(ch == '.') {
    		// a dot, so we need to traverse all the matching characters.
    		// try all other combinations here
    		TrieNode[] children = cur.nodes;

    		for(int i = 0;i< children.length;i++) {
    			if(cur.nodes[i] != null) {
        			return searchUtil(w,index+1, cur.nodes[i]);
    			}
    		}
    	} else {
    		
    		if(cur.nodes[ch -'a'] == null) return false;
    		//there cannot be a null here nor the value mismatch
    		if(cur.nodes[ch - 'a'] != null && cur.nodes[ch-'a'].c != ch) return false;
    		cur = cur.nodes[ch - 'a'];
			return searchUtil(w,index+1, cur);

    	}
    	return false;
    
    }
}
