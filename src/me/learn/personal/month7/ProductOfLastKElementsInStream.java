/**
 * 
 */
package me.learn.personal.month7;

import java.util.ArrayList;
import java.util.List;

/**
 * Title 1352 :
 * 
 * Date : Feb 26, 2021
 * 
 * @author bramanarayan
 *
 */
public class ProductOfLastKElementsInStream {

	

}

// keep adding the product to list
// when you get 0 -> then initialize - back to sqaure arrayList
// now, when someone retrieves for different k -> lastProduct / k-1thLastProduct
class ProductOfNumbers{
	

	static List<Integer> productList;
	static int p;

	public ProductOfNumbers() {
	        productList = new ArrayList<>();
	        p = 1;
	    }

	public void add(int num) {
		if (num == 0) {
			productList = new ArrayList<>();
			p = 1;
			return;
		}
		p *= num;
		productList.add(p);
	}

	public int getProduct(int k) {
		if (productList.size() < k)
			return 0;
		int ans = productList.get(productList.size() - 1);
		if (productList.size() == k)
			return ans;
		return (ans / productList.get(productList.size() - 1 - k));
	}
}
