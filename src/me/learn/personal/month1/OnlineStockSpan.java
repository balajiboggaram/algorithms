/**
 * 
 */
package me.learn.personal.month1;

import java.util.Stack;

/**
 * Title 901 : Write a class StockSpanner which collects daily price quotes for
 * some stock, and returns the span of that stock's price for the current day.
 * 
 * The span of the stock's price today is defined as the maximum number of
 * consecutive days (starting from today and going backwards) for which the
 * price of the stock was less than or equal to today's price.
 * 
 * For example, if the price of a stock over the next 7 days were [100, 80, 60,
 * 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * 
 * @author bramanarayan
 * @date May 19, 2020
 */
public class OnlineStockSpan {

	public static void main(String[] args) {

	}

}

/**
 * 
 * TRICK : 
 * 
 * We see that S[i] on day i can be easily computed if we know the closest day
 * preceding i, such that the price is greater than on that day than the price
 * on day i. If such a day exists, let’s call it h(i), otherwise, we define h(i)
 * = -1.
 */
class StockSpanner {

	Stack<int[]> stack;

	public StockSpanner() {
		// int[] contains element and # of consecutive lesser
		stack = new Stack<int[]>();
	}

	public int next(int price) {
		int span = 1;
		while (!stack.isEmpty() && (price >= stack.peek()[0])) {
			int[] temp = stack.peek();
			span = span + temp[1];
			stack.pop();
		}

		// Finally insert the current element
		stack.push(new int[] { price, span });
		return span;
	}
}
