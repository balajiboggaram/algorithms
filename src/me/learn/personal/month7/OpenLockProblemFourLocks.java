/**
 * 
 */
package me.learn.personal.month7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Title 752 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class OpenLockProblemFourLocks {

	private static final String START = "0000";

	public int openLock(String[] deadends, String target) {
		
		if (target == null || target.length() == 0)
			return -1;
		
		// add all the deadends to visited
		Set<String> visited = new HashSet<>(Arrays.asList(deadends));
		
		
		Queue<String> queue = new LinkedList<>();
		
		int level = 0;
		queue.offer(START);

		while (!queue.isEmpty()) {
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentLock = queue.poll();
				
				// Add the current lock to visited.
				// if the current lock exists in visited already, then just continue with next lock processing...
                if (!visited.add(currentLock)) continue;
				
				if (currentLock.equals(target))
					return level;

				// add all the next states 
				for (String nextLock : getNextStates(currentLock)) {
					if (!visited.contains(nextLock))
						queue.offer(nextLock);
				}

			}
			level++;
		}

		return -1;
	}

	private List<String> getNextStates(String lock) {
		
		List<String> locks = new LinkedList<>();
		
		char[] arr = lock.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			
			// 9 -> 0 ?
			arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
			locks.add(String.valueOf(arr));
			
			
			// 0 -> 9 ?
			arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
			locks.add(String.valueOf(arr));
			
			arr[i] = c;
		}
		return locks;
	}

}
