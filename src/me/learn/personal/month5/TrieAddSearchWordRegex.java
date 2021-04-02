/**
 * 
 */
package me.learn.personal.month5;

import me.learn.utli.TreeNode;
import me.learn.utli.TrieNode;

/**
 * Title 211 : 
 * 
 * Date : Dec 18, 2020
 * 
 * @author bramanarayan
 *
 */
public class TrieAddSearchWordRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class WordDictionary {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    
    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("");   
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


// FIx it
class WordDictionary1 {
	
	TrieNode head;

    /** Initialize your data structure here. */
    public WordDictionary1() {
        this.head = new TrieNode('#');
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
    	if(word == null) {
    		return;
    	}
    	TrieNode cur = head;
    	for(char c : word.toCharArray()) {
    		if(cur.nodes[c-'a'] == null) {
    			TrieNode temp = new TrieNode(c);
    			cur.nodes[c-'a'] = temp;
    		}
    		cur = cur.nodes[c-'a'];
    	}
    	cur.isWord = true;
    	
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchUtil(word, 0, head);
    }

	private boolean searchUtil(String s, int i, TrieNode cur) {

		if(i == s.length()) {
			return true;
		}
		
		if(cur == null) {
			return false;
		}
		
		if(i < s.length()) {
			char ch = s.charAt(i);
			if(ch == '.') {
				TrieNode[] child = cur.nodes;
				for(int j = 0;j<child.length;j++) {
					if(cur.nodes[j] != null) {
						return searchUtil(s, j+1, cur.nodes[j]);
					}
				}
			} else {
				
				if(cur.nodes[ch-'a'] == null) return false;
				if(cur.nodes[ch-'a'] != null && cur.nodes[ch - 'a'].c != ch) return false;
				cur = cur.nodes[ch-'a'];
				return searchUtil(s, i+1, cur);
				
			}
			
		}
	return false;
	}
	
	
}