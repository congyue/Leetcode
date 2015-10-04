//Runtime O(m*n), Space O(1)
public class Solution {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		boolean rowFlag = false;
		boolean colFlag = false;

		for (int i = 0; i < matrix.length; i++) {		//Check if there's 0 in first column
			if (matrix[i][0] == 0) {
				colFlag = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {   //Check if there's 0 in first row
			if (matrix[0][i] == 0) {
				rowFlag = true;
				break;
			}
		}

		for (int row = 1; row < matrix.length; row++) {		//When meet 0 in matrix, mark [row][0] and [0][col] to 0
			for (int col = 1; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					matrix[0][col] = 0;
					matrix[row][0] = 0;
				}
			}
		}

		for (int row = 1; row < matrix.length; row++) {		//Scan matrix again, set [row][col] digit to zero if [row][0] or [0][col] is 0
			for (int col = 1; col < matrix[0].length; col++) {
				if (matrix[row][0] == 0 || matrix[0][col] == 0)
					matrix[row][col] = 0;
			}
		}

		if (rowFlag) {	//Set first row to all 0 if needed
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}

		if (colFlag) {	//Set first col to all 0 if needed
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {{1, 1, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}};
		solution.setZeroes(matrix);
		for (int[] i : matrix) {
			for (int j : i)
				System.out.print(j + ", ");
			System.out.println();
		}
	}
}
