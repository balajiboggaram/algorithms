/**
 * 
 */
package me.learn.personal.month4;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Title 636 :
 * 
 * On a single threaded CPU, we execute some functions. Each function has a
 * unique id between 0 and N-1.
 * 
 * We store logs in timestamp order that describe when a function is entered or
 * exited.
 * 
 * Each log is a string with this format: "{function_id}:{"start" |
 * "end"}:{timestamp}". For example, "0:start:3" means the function with id 0
 * started at the beginning of timestamp 3. "1:end:2" means the function with id
 * 1 ended at the end of timestamp 2.
 * 
 * A function's exclusive time is the number of units of time spent in this
 * function. Note that this does not include any recursive calls to child
 * functions.
 * 
 * The CPU is single threaded which means that only one function is being
 * executed at a given time unit.
 * 
 * Return the exclusive time of each function, sorted by their function id.
 * 
 * Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time. 
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 * 
 * @author bramanarayan
 * @date Jul 29, 2020
 */
public class ExclusiveTimeOfFunctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExclusiveTimeOfFunctions solution = new ExclusiveTimeOfFunctions();
		System.out.println(Arrays.toString(solution.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"))));
	}

	// Repeat candidate
	public int[] exclusiveTime(int n, List<String> logs) {

		int[] res = new int[n];

		Stack<Integer> tasks = new Stack<Integer>();
		
		// First log entry
		String[] s = logs.get(0).split(":");
		tasks.push(Integer.parseInt(s[0]));
		int start = Integer.parseInt(s[2]);
		
		for (int i = 0; i < logs.size(); i++) {
			
			s = logs.get(i).split(":");
			int newtask = Integer.parseInt(s[0]);
			int newtaskTime = Integer.parseInt(s[2]);
			
			if(s[1].equals("start")) {
				res[tasks.peek()] +=  newtaskTime - start; // priorTaskStart - curTaskStart
				start = newtaskTime;
				tasks.push(newtask); // push the new task
			} else {
				// if its end
				res[tasks.peek()] += (newtaskTime - start + 1);
				tasks.pop(); // done with this task as I received end tag of it.
				start = newtaskTime+1;
			}
			
		}
		return res;
	}
}
