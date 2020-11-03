package me.learn.personal.month2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Title 621 :Given a char array representing tasks CPU need to do. It contains
 * capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one
 * interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * @author bramanarayan
 * @date May 24, 2020
 */
public class TaskScheduler {

	/**
	 * 1. Get count of all tasks counts in a PriorityQueue in decreasing order
	 * 
	 * 2. Now, Keep polling until the difference (n) from queue and add to another
	 * temp list.
	 * 
	 * 3. After the time interval 'n' is passed, Add the temp list elements back in
	 * to the queue
	 * 
	 * Note : When adding to temp list, you decrement the count as that task was
	 * executed.
	 * 
	 * We are done with algorithm when queue is empty. Between we keep a timer to
	 * track the tasks
	 */
	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks)
			map[c - 'A']++;
		PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
		for (int f : map) {
			if (f > 0)
				queue.add(f);
		}
		int time = 0;
		while (!queue.isEmpty()) {
			int i = 0;
			List<Integer> temp = new ArrayList<>();
			while (i <= n) {
				if (!queue.isEmpty()) {
					if (queue.peek() > 1)
						temp.add(queue.poll() - 1);
					else
						queue.poll();
				}
				time++; // Tracks both idle and actual task
				if (queue.isEmpty() && temp.size() == 0)
					break;
				i++;
			}
			for (int l : temp)
				queue.add(l);
		}
		return time;
	}

}
