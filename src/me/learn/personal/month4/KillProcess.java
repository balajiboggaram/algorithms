/**
 * 
 */
package me.learn.personal.month4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Title 582 :
 * 
 * Given n processes, each process has a unique PID (process id) and its PPID
 * (parent process id).
 * 
 * Each process only has one parent process, but may have one or more children
 * processes. This is just like a tree structure. Only one process has PPID that
 * is 0, which means this process has no parent process. All the PIDs will be
 * distinct positive integers.
 * 
 * We use two list of integers to represent a list of processes, where the first
 * list contains PID for each process and the second list contains the
 * corresponding PPID.
 * 
 * Now given the two lists, and a PID representing a process you want to kill,
 * return a list of PIDs of processes that will be killed in the end. You should
 * assume that when a process is killed, all its children processes will be
 * killed. No order is required for the final answer.
 * 
 * Example 1:
 * 
 * Input: pid = [1, 3, 10, 5] ppid = [3, 0, 5, 3] kill = 5 Output: [5,10]
 * Explanation: 3 / \ 1 5 / 10 Kill 5 will also kill 10.
 * 
 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class KillProcess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		// prepare a map of process to its direct children
		Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();

		// add process with their children as value
		for (int i = 0; i < ppid.size(); i++) {
			m.computeIfAbsent(ppid.get(i), f -> new ArrayList<Integer>()).add(pid.get(i));
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(kill);
		List<Integer> result = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int killed = q.remove();
			result.add(killed);
			
			if(m.get(killed) != null) {
				// add children of killed now to queue
				for(int toKill : m.get(killed)) {
					q.add(toKill);
				}				
			}
			
		}
		
		return result;
	}

}
