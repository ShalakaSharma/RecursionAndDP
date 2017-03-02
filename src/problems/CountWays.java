package problems;

public class CountWays {

	public static void main(String[] args) {
		
		System.out.println("Recursive approach for counting ways to reach n = 4:" + countWays(4));
		int memo [] = new int[37];
		System.out.println("--------");
		System.out.println("Recursive approach for counting ways to reach n = 36:" + countWaysMemoized(36, memo));
		
	}
	
	public static int countWays(int n) {
		
		if(n<0) {
			return 0;
		}
		
		if(n == 0) {
			return 1;
		}
		
		return (countWays(n-1) + countWays(n-2) + countWays(n-3) );
	}
	
	public static int countWaysMemoized(int n, int[] memo) {
		
		if(n<0) {
			return 0;
		}
		
		if(memo[n] != 0) {
			return memo[n];
		}
		
		if(n == 0) {
			memo[n] = 1;
			return memo[n];
		}
		
		
		memo[n] = countWaysMemoized(n-1, memo) + countWaysMemoized(n-2, memo) + countWaysMemoized(n-3, memo);
		return memo[n];
	}
}
