/**
 * 
 */
package me.learn.personal.month6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Title 588 :
 * 
 * Date : Feb 7, 2021
 * 
 * @author bramanarayan
 *
 */
public class InMemoryFileSystem {

}

class TreeNode {
	HashMap<String, TreeNode> directories = new HashMap<>();
	HashMap<String, String> files = new HashMap<>();
}

class FileSystem {

	TreeNode root;

	public FileSystem() {
		root = new TreeNode();
	}

	/**
	 * List all the files and directories. (no nested)
	 */
	public List<String> ls(String path) {

		TreeNode cur = root;
		
		List<String> files = new ArrayList<>();

		if (!path.equals("/")) {
			
			String[] tokens = path.split("/");
			
			// traverse until the (last-1) directory path
			for (int i = 1; i < tokens.length - 1; i++) {
				cur = cur.directories.get(tokens[i]);
			}
			
			
			// Handle last'th ->  If the last token is actually the file name, then just add it and return
			if (cur.files.containsKey(tokens[tokens.length - 1])) {
				files.add(tokens[tokens.length - 1]);
				return files;
			} else {
				// else go one more level deep to leaf directory
				cur = cur.directories.get(tokens[tokens.length - 1]);
			}
		}

		files.addAll(new ArrayList<>(cur.directories.keySet())); // add all directories

		files.addAll(new ArrayList<>(cur.files.keySet())); // add all files

		Collections.sort(files); // since if you need in lexico graphic order

		return files;
	}

	public void mkdir(String path) {
		TreeNode cur = root;
		
		String[] tokens = path.split("/");
		
		for (int i = 1; i < tokens.length; i++) {
			if (!cur.directories.containsKey(tokens[i])) {
				cur.directories.put(tokens[i], new TreeNode());				
			}
			cur = cur.directories.get(tokens[i]);
		}
	}

	public void addContentToFile(String filePath, String content) {
		TreeNode cur = root;
		String[] tokens = filePath.split("/");
		
		for (int i = 1; i < tokens.length - 1; i++) {
			cur = cur.directories.get(tokens[i]);
		}
		
		cur.files.put(tokens[tokens.length - 1], cur.files.getOrDefault(tokens[tokens.length - 1], "") + content);
	}

	public String readContentFromFile(String filePath) {
		TreeNode cur = root;
		String[] tokens = filePath.split("/");
		for (int i = 1; i < tokens.length - 1; i++) {
			cur = cur.directories.get(tokens[i]);
		}
		return cur.files.get(tokens[tokens.length - 1]);
	}
}

/**
 * Your FileSystem object will be instantiated and called as such: FileSystem
 * obj = new FileSystem(); List<String> param_1 = obj.ls(path); obj.mkdir(path);
 * obj.addContentToFile(filePath,content); String param_4 =
 * obj.readContentFromFile(filePath);
 */
