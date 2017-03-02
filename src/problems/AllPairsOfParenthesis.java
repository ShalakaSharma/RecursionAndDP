package problems;

import java.util.ArrayList;

public class AllPairsOfParenthesis {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		int n=3;
		char str[] = new char[n*2];
		getAllValidPairs(0, list, n, n, str);
		System.out.println(list);
	}
	
	public static void getAllValidPairs(int index, ArrayList<String> list, int leftRemaining, int rightRemaining, char[] str) {
		
		if(leftRemaining < 0 || rightRemaining < leftRemaining) {
			return;
		}
		
		if(leftRemaining == 0 && rightRemaining == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			if(leftRemaining>0) {
				str[index] = '(';
				getAllValidPairs(index+1, list, leftRemaining-1, rightRemaining, str);
			} 
			
			if(rightRemaining > leftRemaining) {
				str[index] = ')';
				getAllValidPairs(index+1, list, leftRemaining, rightRemaining-1, str);
			}
		}
	}
}
