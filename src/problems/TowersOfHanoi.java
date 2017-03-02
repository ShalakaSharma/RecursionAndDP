package problems;

public class TowersOfHanoi {

	public static void main(String[] args) {
		towersOfHanoi(3, 'S', 'D', 'I');
	}

	public static void towersOfHanoi(int n, char source, char destination,
			char intermediate) {
		
		if(n <= 0) {
			return;
		}

		towersOfHanoi(n - 1, source, intermediate, destination);

		System.out.println("Move disk " + n + " from pole " + source
				+ " to pole " + destination);
		
		towersOfHanoi(n - 1, intermediate, destination, source);
		
	}
}
