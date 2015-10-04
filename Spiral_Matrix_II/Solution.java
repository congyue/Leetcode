import java.util.*;
public class Solution {
	public int[][] generateMatrix(int n) {
		if (n < 0)
			return null;
		if (n == 0)
			return new int[0][0];

		int[][] matrix = new int[n][n];
		
		final int RIGHT = 0;
		final int DOWN = 1;
		final int LEFT = 2;
		final int UP = 3;

		int rowStart = 0, rowEnd = matrix.length - 1;
		int colStart = 0, colEnd = matrix[0].length - 1;
		int direction = RIGHT, count = 1;

		while(rowStart <= rowEnd && colStart <= colEnd) {  //Keep looping when boundaries are valid
			switch (direction) {
				case RIGHT:  //Scan to the right and update boundary
					for (int i = colStart; i <= colEnd; i++)
						matrix[rowStart][i] = count++;
					rowStart++;
					break;
				case DOWN:
					for (int i = rowStart; i <= rowEnd; i++)
						matrix[i][colEnd] = count++;
					colEnd--;
					break;
				case LEFT:
					for (int i = colEnd; i >= colStart; i--)
						matrix[rowEnd][i] = count++;
					rowEnd--;
					break;
				case UP: 
					for (int i = rowEnd; i >= rowStart; i--)
						matrix[i][colStart] = count++;
					colStart++;
					break;
				default:
					break;
			}
			direction = (direction + 1) % 4;  //Get next direction
		}
		return matrix;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 4;
		int[][] result = solution.generateMatrix(n);
		for (int[] arr : result) {
			System.out.print("[");
			for (int i : arr) {
				System.out.print(i + ", ");
			}
			System.out.println("]");
		}
	}
}
