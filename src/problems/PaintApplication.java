package problems;


public class PaintApplication {

	public static void main(String[] args) {
		Color newColor = Color.YELLOW;
		Color[][] canvas = new Color[10][10];
		for(int r=0;r<10;r++) {
			for(int c=0; c<10;c++) {
				canvas[r][c] = Color.WHITE;
			}
		}
		canvas[4][5] = Color.GREEN;
		canvas[4][6] = Color.GREEN;
		canvas[4][7] = Color.GREEN;
		canvas[4][8] = Color.GREEN;
		canvas[4][9] = Color.GREEN;
		int r = 5;
		int c = 6;
		System.out.println(fillPaint(r, c, canvas, newColor));
		for(r=0;r<10;r++) {
			for(c=0; c<10;c++) {
				System.out.print(canvas[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean fillPaint(int r, int c, Color[][] canvas, Color newColor) {
		if(canvas[r][c] == newColor) {
			return false;
		}
		return fillPaint(r, c, canvas, newColor, canvas[r][c]);
	}
	
	public static boolean fillPaint(int r, int c, Color[][] canvas, Color newColor, Color oldColor) {
		if(r>=canvas.length || c>=canvas[0].length || r<0 || c<0 ) {
			return false;
		}
		
		if(canvas[r][c] == oldColor) {
			canvas[r][c] = newColor;
			fillPaint(r-1, c, canvas, newColor, oldColor);
			fillPaint(r+1, c, canvas, newColor, oldColor);
			fillPaint(r, c-1, canvas, newColor, oldColor);
			fillPaint(r, c+1, canvas, newColor, oldColor);
		}
		return true;
	}
}

enum Color {
	RED, GREEN, YELLOW, BLACK, WHITE;
}