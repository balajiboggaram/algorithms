/**
 * 
 */
package me.learn.personal.month6;

/**
 * Title 780 :
 * 
 * Date : Feb 27, 2021
 * 
 * @author bramanarayan
 *
 */
public class ReachingPointsCanReach {
	
	// Bottom up approach - from tx, ty climb u to sx, sy
		// As (x ,y ) can move to ( x, x+y) or ( x+y , y) , tx = sx + k.sy or ty = sy + k .sx
		// tx = sx + k.sy ==> k = (tx-sx )/sy ty = sy + k .sx ==> k = (ty-sy)/sx
		
		public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
			
			// Keep moving from bottom to up to reach at ( sx , sy)
			while (tx > sx && ty > sy)
				if (ty > tx) // whichever greater - keep decrement the same .
					ty = ty - tx;
				else
					tx = tx - ty;
			
			
			
			// if we reach where sx == tx or ty == sy
			if (sx == tx && sy == ty)
				return true;
			
			// sy < ty
			if (sx == tx && sy < ty && (ty - sy) % tx == 0)
				return true;
			
	        // sx < tx
			return sy == ty && sx < tx && (tx - sx) % ty == 0;
		}

}
