public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null)
			return;

		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][col - 1 - j];
				matrix[i][col - 1 - j] = temp;
			}
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println("Input:");
		for(int[] arr : matrix) {
			for(int i : arr)
				System.out.print(i + ", ");
			System.out.println();
		}

		solution.rotate(matrix);
		
		System.out.println("Output:");
		for(int[] arr : matrix) {
			for(int i : arr)
				System.out.print(i + ", ");
			System.out.println();
		}
	}
}
