/**
 * 
 */
package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import me.learn.utli.TreeNode;

/**
 * Title 863 : 
 * 
 * Date : Feb 28, 2021
 * 
 * @author bramanarayan
 *
 */
public class FindAllNodesAtDistanceK {

	// node to parent node map - MINE
	Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

	// BLOOD FLOW BFS
	// map, queue
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
			
			// populate all the parent nodes
			DFS(root, null);

			// Now, run the BFS
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(target);
			Set<TreeNode> visited = new HashSet<>();
			visited.add(target);
			
			int level = -1;
			while(!q.isEmpty()) {
				int size = q.size();
				level++;
				
				// if k level, then we add to result and return
				if(level == K) {
					List<Integer> result = new ArrayList<Integer>();
					while(!q.isEmpty()) {
						result.add(q.poll().val);
					}
                    return result;
				}
				
				// process the current level, and prepare the next level.
				for(int i  = 0 ;i< size; i++) {
					TreeNode temp = q.poll();
					
					// add left and right nodes
					if(temp.left != null && !visited.contains(temp.left)) {
						q.offer(temp.left);
						visited.add(temp.left);
					}
					
					if(temp.right != null && !visited.contains(temp.right)) {
						q.offer(temp.right);
						visited.add(temp.right);
					}
					
					// now parent 
					if(map.get(temp) != null && !visited.contains(map.get(temp))) {
						q.offer(map.get(temp));
						visited.add(map.get(temp));
					}
				}
			}

			return new ArrayList<Integer>();
		
	}

	private void DFS(TreeNode root, TreeNode parent) {
		if (root == null)
			return;
		map.put(root, parent); // add node to parent

		DFS(root.left, root);
		DFS(root.right, root);

	}
}
