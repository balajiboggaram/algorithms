package me.learn.personal.month4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Title 36 :
 * 
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the 9 3x3 sub-boxes of the
 * grid must contain the digits 1-9 without repetition.
 * 
 * 
 * @author bramanarayan
 * @date Aug 21, 2020
 */
public class ValidSudoku {
	
	public static void main(String args[]) {
		ValidSudoku solution = new ValidSudoku();
		
		
		
		
		char[][] b = new char[][]
				{{'8','3','.','.','7','.','.','.','.'},
				 {'6','.','.','1','9','5','.','.','.'},
				 {'.','9','8','.','.','.','.','6','.'},
				 {'8','.','.','.','6','.','.','.','3'},
				 {'4','.','.','8','.','3','.','.','1'},
				 {'7','.','.','.','2','.','.','.','6'},
				 {'.','6','.','.','.','.','2','8','.'},
				 {'.','.','.','4','1','9','.','.','5'},
				 {'.','.','.','.','8','.','.','7','9'}};
				System.out.println(solution.isValidSudoku(b));
		
		
		char[][] a = new char[][] {
		
			
{'5','3','.','.','7','.','.','.','.'},
{'6','.','.','1','9','5','.','.','.'},
{'.','9','8','.','.','.','.','6','.'},
{'8','.','.','.','6','.','.','.','3'},
{'4','.','.','8','.','3','.','.','1'},
{'7','.','.','.','2','.','.','.','6'},
{'.','6','.','.','.','.','2','8','.'},
{'.','.','.','4','1','9','.','.','5'},
{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(solution.isValidSudoku(a));
	}
	

	public boolean isValidSudoku(char[][] a) {
		int m = a.length;
		int n = a[0].length;
		
		if(m != 9 || n != 9) return false;
		
		Map<Integer, Set<Integer>> row = new HashMap<>();
		Map<Integer, Set<Integer>> col = new HashMap<>();
		Map<Integer, Set<Integer>> box = new HashMap<>();
		
		for(int i = 0;i<m; i++) {
			for(int j = 0;j<n;j++) {
				
				if(a[i][j] == '.') continue;
				
				if(row.get(i) != null && row.get(i).contains(a[i][j] - '0')) {
					return false;
				}
				
				if(col.get(j) != null && col.get(j).contains(a[i][j] - '0')) {
					return false;
				}
				
				int r = i/3;
				int c = j/3;
				
				int index = (r *3) + c;
				if(box.get(index) != null && box.get(index).contains(a[i][j] - '0')) {
					return false;
				}
				
				System.out.println(a[i][j]);
				
				// now add the element to all the three sets
				row.computeIfAbsent(i, x -> new HashSet<Integer>()).add(a[i][j] - '0');
				col.computeIfAbsent(j, x -> new HashSet<Integer>()).add(a[i][j] - '0');
				box.computeIfAbsent(index, x -> new HashSet<Integer>()).add(a[i][j]- '0');
				
			}
		}
		
		return true;
		
	}
	
	
}
