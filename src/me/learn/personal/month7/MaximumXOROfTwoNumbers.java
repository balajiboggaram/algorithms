/**
 * 
 */
package me.learn.personal.month7;

import java.util.HashMap;
import java.util.Map;

/**
 * Title 421 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class MaximumXOROfTwoNumbers {

	// CHECK THIS Beautiful
	// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/1041242/Detailed-Explanation-(Trie-Java)

	/**
	 * Solution is purely based on Trie as data structure. check if the bit differs
	 * and then keep adding to your curResult;
	 * 
	 */

	class TrieNode {
		//	for this problem members like isWord or word is not needed.
		// Every number will lengthen to the longest number in the list.
		Map<Integer, TrieNode> children;
		public TrieNode() {
			children = new HashMap<>();
		}
	}
	

class Trie {
    // Some coder make this depth to 31. As the range of the number is an int.
    int depth;
    TrieNode root;
    public Trie(int d) {
        depth = d;
        root = new TrieNode();
    }
    
    // add the binary form of a number to trie
    public void add(int num) {
        TrieNode currNode = root;
        for (int i = depth; i >= 0; i--) {
            
        	// this line tells your whether the i-th bit is 0 or 1. 
            // >> means num move i many bits to the right. e.g. 1000 >> 3 == 0001
            int bit = (num>>i) & 1;
            
            // add bit to the tree due to its value.
            if (bit == 0) {
                if (!currNode.children.containsKey(0)) {
                    currNode.children.put(0,new TrieNode());
                }
                currNode = currNode.children.get(0);
            }else {
                if (!currNode.children.containsKey(1)) {
                    currNode.children.put(1,new TrieNode());
                }
                currNode = currNode.children.get(1);
            }
        }
    }
    
    // for a given num, find the max XOR value
    public int findMaximumXORValue(int num) {
        int ans = 0;
        TrieNode currNode = root;
        //At this point, the Trie had been built. 
        //We try to find the max XOR this num can get from the Trie.
        for (int i = depth; i >= 0; i--) {
        	
        	// is this current bit 1 or 0 ?
            int bit = (num >> i) & 1;
            
            if (bit == 0) {
                //when bit is 0, we check if there is a 1 branch. 
                //cuz, 0 ^ 1 == 1, apparently, 1 larger than 0. 
                
                if (currNode.children.containsKey(1)) {
                    //this currNode act like a pointer. Always trying to find the bit which
                    // is opposite to the current bit of number, to make the XOR max.
                    currNode = currNode.children.get(1);
                    //1<<i means 1 moves i steps to the left. e.g. 1<< 3 == 100(binary)
                    //we can get an 1 for this bit, so we make i-th bit to be 1
                    //we add up the ans bit by bit.
                    ans += (1<<i);
                }else {
                    // when the XOR result can not be 1, we add up nothing to the answer
                    currNode = currNode.children.get(0);
                }
            }else {
                if (currNode.children.containsKey(0)) {
                    currNode = currNode.children.get(0);
                    ans += (1<<i);
                }else {
                    currNode = currNode.children.get(1);
                }
            }
        }
        
        return ans;
        
    }
} // END OF TRIE
    
    /**
     * ACTUAL SOLUTION
     */
    public int findMaximumXOR(int[] nums) {
        //The longest num
        int maxDepth = maxDepth(nums);
        int ans = 0;
        
        Trie trie = new Trie(maxDepth);
        
        //first round , add all the num to Trie
        for (int num : nums) {
            trie.add(num);
        }
        
        // second round , check maxXOR for each num
        for (int num : nums) {
            ans = Math.max(ans,trie.findMaximumXORValue(num));
        }
        
        return ans;
        
    }
    
    // find the max depth of binary number, inturn which means max of decimal number
    public int maxDepth(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max,num);
        }
        return Integer.toBinaryString(max).length();
    }
}

