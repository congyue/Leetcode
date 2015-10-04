import java.util.*;
public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;

		final int RIGHT = 0;
		final int DOWN = 1;
		final int LEFT = 2;
		final int UP = 3;

		int rowStart = 0, rowEnd = matrix.length - 1;
		int colStart = 0, colEnd = matrix[0].length - 1;
		int direction = RIGHT;

		while(rowStart <= rowEnd && colStart <= colEnd) {  //Keep looping when boundaries are valid
			switch (direction) {
				case RIGHT:  //Scan to the right and update boundary
					for (int i = colStart; i <= colEnd; i++)
						result.add(matrix[rowStart][i]);
					rowStart++;
					break;
				case DOWN:
					for (int i = rowStart; i <= rowEnd; i++)
						result.add(matrix[i][colEnd]);
					colEnd--;
					break;
				case LEFT:
					for (int i = colEnd; i >= colStart; i--)
						result.add(matrix[rowEnd][i]);
					rowEnd--;
					break;
				case UP:
					for (int i = rowEnd; i >= rowStart; i--)
						result.add(matrix[i][colStart]);
					colStart++;
					break;
				default:
					break;
			}
			direction = (direction + 1) % 4;  //Get next direction
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {{1, 2, 3},
						  {4, 5, 6},
						  {7, 8, 9},
						  {10, 11, 12}};
		System.out.println(solution.spiralOrder(matrix));
	}
}
