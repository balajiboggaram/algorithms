/**
 * 
 */
package me.learn.personal.month4;

import java.util.LinkedList;

/**
 * Title 353 : 
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)


 * @author bramanarayan
 * @date Jul 30, 2020
 */
public class DesignSnakeGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class SnakeGame {

	int width;
	int height;
	int[][] food;
	
	int k = 0; // food count - how many food did snake eat so far
	Point cur;
	LinkedList<Point> shake;
	
	
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food  = food;
        
        this.k = 0;
        this.shake = new LinkedList<>();
        shake.addFirst(new Point(0,0)); // add where snake starts
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
    	
        Point head = shake.getFirst(); // current snake head
        
        // the new head is based on the current head
        // the tail is removed, but can be returned back if food is found
        Point newHead = new Point(head.x, head.y);
        
        Point tail = shake.removeLast(); // remove the tail. add it back only when you find food.
        
        if(direction.equals("U")) {
        	newHead.x--;
        } else if(direction.equals("D")) {
        	newHead.x++;
        } else if(direction.equals("L")) {
        	newHead.y--;
        } else if(direction.equals("R")) {
        	newHead.y++;
        }
        
        
        // check if new head goes out of boundary
        if( newHead.x < 0 || newHead.x == height ||
        	newHead.y < 0 || newHead.y == width ||
        	shake.contains(newHead)) { // new head eats the tail - kind of circle
        	return -1;
        }
        
        shake.addFirst(newHead); //insert at front
        
        // check if we got the food
        if(k< food.length && food[k][0] == newHead.x && food[k][1] == newHead.y) {
        	k++;
        	shake.addLast(tail);
        }
        
        return k;
        
    }
}


// a point in a 2D plane
class Point {
	 int x;
     int y;
     Point(int i, int j){
         this.x=i;
         this.y=j;
     }
     
     // compare 2 points - when their x and y co-ordinates are same.
     @Override
     public boolean equals(Object o) {
         if(o == this) return true;
         if(! (o instanceof Point)) return false;
         
         Point p = (Point) o;
         if(p.x == this.x && p.y == this.y)  return true;
         
         return false;
     } 
     
}
