/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Title 1233 :
 * 
 * Date : Jan 3, 2021
 * 
 * @author bramanarayan
 *
 */
public class RemoveSubFoldersfromFileSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RemoveSubFoldersfromFileSystem solution = new RemoveSubFoldersfromFileSystem();
		System.out.println(solution.removeSubfolders(new String[] {"/a","/a/b","/c/d","/c/d/e","/c/f"}));
	}

	public List<String> removeSubfolders(String[] folder) {
		// Sort the list - lexicographically
		Arrays.sort(folder);
		
		String temp = folder[0];
		List<String> res = new ArrayList<String>();
		res.add(temp);
		
		for (int i = 1; i < folder.length; i++) {
			// Check if the string StartsWith or not. If not, add to the result list
			if (!(folder[i]).startsWith(temp + "/")) {
				res.add(folder[i]);
				temp = folder[i];
			}
		}

		return res;
	}
	
	
	// Using Trie
	
	//->Sort the strings according to length.
	//-> Start adding strings to trie.
	//-> If any of the prefixes of a given string is already a key present in trie don't add it to the final list.

	private class TrieNode {
	        TrieNode[] children = new TrieNode[27]; // Store '/' at index 26.
	        boolean isEnd;
	    }

	    TrieNode root;

	    public List<String> removeSubfolders1(String[] folder) {
	        Arrays.sort(folder, Comparator.comparingInt(String::length));
	        root = new TrieNode();
	        List<String> result = new ArrayList<>();
	        for(String s : folder) {
	            if(insert(s,root,0)) {
	                result.add(s);
	            }
	        }
	        return result;
	    }

	    // if any of the prefixes of a string is already present, then dont add it.
	    // this function will return true, if the prefix is seen for the first time, whiuch means we need to add this result
	    private boolean insert(String key,TrieNode root,int i) {
	        if(i==key.length()) {
	            root.isEnd=true;
	            return true;
	        }
	        char c = key.charAt(i);
	        
	        if((c=='/' && root.children[26]==null) || (c!='/' && root.children[c-'a']==null)) {
	            if(c-'a'>=0) {
	                root.children[c-'a']=new TrieNode();
	            } else {
	                root.children[26] = new TrieNode();
	            }
	        } else if(c!='/' && root.children[c-'a'].isEnd
	                // For cases like /c/a,/c/ab both should exist.
	                && i<key.length()-1 && key.charAt(i+1)=='/') {
	            return false;
	        }
	        return insert(key,(c=='/'?root.children[26]:root.children[c-'a']),i+1);
	    }


}
