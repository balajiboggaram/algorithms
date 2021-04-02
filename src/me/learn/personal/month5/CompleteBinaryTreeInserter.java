package me.learn.personal.month5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.learn.utli.TreeNode;

/**
 * 
 * Title 919 :
 * 
 * Date : Dec 13, 2020
 * 
 * @author bramanarayan
 *
 */
public class CompleteBinaryTreeInserter {

}

// Basically, Convert this problem into array. 
// play with indicies parent -> i-1/2 , leftchild ->  2 * i +1, rightChild -> 2 * i +2
class CBTInserter {

	List<TreeNode> list = new ArrayList<>();

	public CBTInserter(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			list.add(cur);
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
	}

	public int insert(int v) {
		int idx = list.size();
		TreeNode child = new TreeNode(v);
		list.add(child);
		TreeNode par = list.get((idx - 1) / 2);
		if (par.left == null)
			par.left = child;
		else
			par.right = child;
		return par.val;
	}

	public TreeNode get_root() {
		return list.get(0);
	}
}
