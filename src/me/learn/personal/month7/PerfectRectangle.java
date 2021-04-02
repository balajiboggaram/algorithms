/**
 * 
 */
package me.learn.personal.month7;

import java.util.HashSet;
import java.util.Set;

/**
 * Title :
 * 
 * Date : Mar 8, 2021
 * 
 * @author bramanarayan
 *
 */
public class PerfectRectangle {

	public boolean isRectangleCover(int[][] rectangles) {
		Set<String> set = new HashSet<>();
		for (int[] rec : rectangles) {
			// b = bottom, l = left, r = right, t = top
			// create corners with type
			int x1 = rec[0], y1 = rec[1], x2 = rec[2], y2 = rec[3];
			String bl = x1 + "," + y1 + "bl";
			String br = x2 + "," + y1 + "br";
			String tl = x1 + "," + y2 + "tl";
			String tr = x2 + "," + y2 + "tr";
			// if these corners already exist, return false
			if (!set.add(bl) || !set.add(br) || !set.add(tl) || !set.add(tr))
				return false;
			// if these 4 corners and previously added corners form a line, remove them
			if (set.remove(x1 + "," + y1 + "tl"))
				set.remove(bl);
			else if (set.remove(x1 + "," + y1 + "br"))
				set.remove(bl);

			if (set.remove(x2 + "," + y1 + "bl"))
				set.remove(br);
			else if (set.remove(x2 + "," + y1 + "tr"))
				set.remove(br);

			if (set.remove(x1 + "," + y2 + "tr"))
				set.remove(tl);
			else if (set.remove(x1 + "," + y2 + "bl"))
				set.remove(tl);

			if (set.remove(x2 + "," + y2 + "tl"))
				set.remove(tr);
			else if (set.remove(x2 + "," + y2 + "br"))
				set.remove(tr);
		}
		// a perfect rectangle contains 4 corners
		return set.size() == 4;
	}
}
