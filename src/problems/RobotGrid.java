package problems;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class RobotGrid {

	public static void main(String[] args) {
		int n = 3;
		boolean maze[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n ; j++) {
				maze[i][j] = true;
			}
		}
		maze[0][1] = false;
		//maze[1][1] = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		ArrayList<Point> path = getPath(maze);
		System.out.println(path);
		path = getPathDP(maze);
		System.out.println(path);
	
	}

	public static ArrayList<Point> getPath(boolean[][] maze) {

		if ((maze == null) || (maze.length == 0)) {
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();

		if (getPath(path, maze, maze.length - 1, maze[0].length - 1)) {
			return path;
		}

		return null;
	}

	private static boolean getPath(ArrayList<Point> path, boolean[][] maze,
			int row, int col) {

		System.out.println("row : " + row + " col: " + col);
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}

		boolean isOrigin = (row == col && col == 0);

		if (isOrigin || getPath(path, maze, row - 1, col)
				|| getPath(path, maze, row, col - 1)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		System.out.println("Returned false for " + "row : " + row + " col: "
				+ col);
		return false;
	}

	public static ArrayList<Point> getPathDP(boolean[][] maze) {

		if ((maze == null) || (maze.length == 0)) {
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> map = new HashMap<Point, Boolean>();
		if (getPathDP(path, maze, maze.length - 1, maze[0].length - 1, map)) {
			System.out.println(map);
			return path;
		}

		return null;
	}

	private static boolean getPathDP(ArrayList<Point> path, boolean[][] maze,
			int row, int col, HashMap<Point, Boolean> map) {
		Point p = new Point(row, col);
		
		if (map.containsKey(p) && map.get(p)) {
			System.out.println("Returned from memo");
			return true;
		}
		System.out.println("row : " + row + " col: " + col);
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}

		boolean isOrigin = (row == col && col == 0);
		boolean success = false;
		if (isOrigin || getPathDP(path, maze, row - 1, col, map)
				|| getPathDP(path, maze, row, col - 1, map)) {

			path.add(p);
			success = true;			
		}
		System.out.println("Returned "+  success + " for " + "row : " + row + " col: "
				+ col);
		map.put(p, success);
		return success;
	}
}
