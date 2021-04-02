/**
 * 
 */
package me.learn.personal.month7;

/**
 * Title 1515 :
 * 
 * Date : Mar 6, 2021
 * 
 * @author bramanarayan
 *
 */
/*
 * currentPrecission decreases like this : 
 * 
 * 
 * currentPrecision :100.0
currentPrecision :50.0
currentPrecision :25.0
currentPrecision :12.5
currentPrecision :6.25
currentPrecision :3.125
currentPrecision :1.5625
currentPrecision :1.5625
currentPrecision :1.5625
currentPrecision :0.78125
currentPrecision :0.78125
currentPrecision :0.78125
currentPrecision :0.390625
currentPrecision :0.390625
currentPrecision :0.390625
currentPrecision :0.1953125
currentPrecision :0.1953125
currentPrecision :0.1953125
currentPrecision :0.09765625
currentPrecision :0.048828125
currentPrecision :0.0244140625
currentPrecision :0.0244140625
currentPrecision :0.0244140625
currentPrecision :0.01220703125
currentPrecision :0.006103515625
currentPrecision :0.0030517578125
currentPrecision :0.00152587890625
currentPrecision :0.00152587890625
currentPrecision :0.00152587890625
currentPrecision :7.62939453125E-4
currentPrecision :7.62939453125E-4
currentPrecision :7.62939453125E-4
currentPrecision :3.814697265625E-4
currentPrecision :3.814697265625E-4
currentPrecision :3.814697265625E-4
currentPrecision :1.9073486328125E-4
currentPrecision :1.9073486328125E-4
currentPrecision :1.9073486328125E-4
currentPrecision :9.5367431640625E-5
currentPrecision :4.76837158203125E-5
currentPrecision :2.384185791015625E-5
currentPrecision :2.384185791015625E-5
currentPrecision :2.384185791015625E-5
currentPrecision :1.1920928955078125E-5
currentPrecision :5.9604644775390625E-6
currentPrecision :2.9802322387695312E-6
currentPrecision :1.4901161193847656E-6
currentPrecision :1.4901161193847656E-6
currentPrecision :1.4901161193847656E-6
currentPrecision :7.450580596923828E-7
currentPrecision :7.450580596923828E-7
currentPrecision :7.450580596923828E-7
currentPrecision :3.725290298461914E-7
currentPrecision :3.725290298461914E-7
currentPrecision :3.725290298461914E-7
currentPrecision :1.862645149230957E-7
currentPrecision :1.862645149230957E-7
currentPrecision :1.862645149230957E-7


 * 
 */
public class GeometricMedianDistanceServiceCenter {
	
	public static final int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	public static final double error = 0.0000001;

	public double getMinDistSum(int[][] positions) {
		double x = 0;
		double y = 0;
		double currentPrecision = 100; // some good approximation number to run the algorithm so many times
		double res = distSum(x, y, positions);
		
		while (currentPrecision > error) {
		
			boolean found = false;
			for (int[] dir : dirs) {
				double nx = x + dir[0] * currentPrecision;
				double ny = y + dir[1] * currentPrecision;
				double cur = distSum(nx, ny, positions);
				if (cur < res) {
					res = cur;
					x = nx;
					y = ny;
					found = true;
					break;
				}
			}
			
			if(!found)
				currentPrecision = currentPrecision /2;
		}
		return res;
	}

	private double distSum(double x0, double y0, int[][] positions) {
		double res = 0.0;
		for (int[] position : positions) {
			res += Math.sqrt((x0 - position[0]) * (x0 - position[0]) + (y0 - position[1]) * (y0 - position[1]));
		}
		return res;
	}
}
