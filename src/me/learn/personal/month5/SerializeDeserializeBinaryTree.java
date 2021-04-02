/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.List;

import me.learn.utli.TreeNode;

/**
 * Title 297 : 
 * 
 * Date : Dec 18, 2020
 * 
 * @author bramanarayan
 *
 */
public class SerializeDeserializeBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Codec {

	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	return serialize(root, "" );
    }

    String serialize(TreeNode root, String s) {
    	if(root == null) {
    		s = s+ "null,";
    	} else {
    		s = s + String.valueOf(root.val) + ",";
    		s = serialize(root.left, s);
    		s = serialize(root.right, s) ;
    		
    	}
    	return s;
    	
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        List<String> data = new ArrayList<String>() {}; 
        for(String tok : s.split(",")) {
        	data.add(tok);
        }
        return decodeUtil(s, data);
        
    }
    
	TreeNode decodeUtil(String s, List<String> data) {

		if (data.get(0).equals("null")) {
			data.remove(0);
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
		data.remove(0);
		root.left = decodeUtil(s, data);
		root.right = decodeUtil(s, data);

		return root;
	}
}
