/**
 * 
 */
package me.learn.personal.month5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title 1114 : 
 * 
 * Date : Dec 30, 2020
 * 
 * @author bramanarayan
 *
 */
public class PrintInOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Foo {
	
	AtomicInteger isFirstDone = new AtomicInteger(0);
	AtomicInteger isSecondDone = new AtomicInteger(0);
	
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        isFirstDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
    	while(isFirstDone.get() != 1) {
    		wait();
    	}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        isSecondDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
    	while(isSecondDone.get() != 1) {
    		wait();
    	}
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        
    }
}