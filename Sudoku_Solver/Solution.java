public class Solution {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length !=9)
			return;
		helper(board, 0, 0);
	}

	private boolean helper(char[][] board, int i, int j) {
		if (j >= 9)  //When j overflow, jump to next line
			return helper(board, i + 1, 0);
		if (i == 9)  //When i overflow, means matrix valid till last element
			return true;
		if (board[i][j] == '.') {  //Starts to fill board[i][j]
			for (int k = 1; k <= 9; k++) {  //Try each digit from 1 ~ 9
				board[i][j] = (char)(k + '0');
				if (isValid(board, i, j ) && helper(board, i, j + 1))
					return true;  //Succeed if this digit and the furture matrix all valid
				board[i][j] = '.'; //If failed, recover to original state
			}
		}
		else
			return helper(board, i, j + 1);
		return false;
	}

	private boolean isValid(char[][] board, int i, int j) {
		//Validate row
		for	(int k = 0; k < 9; k++)
			if (k != j && board[i][j] == board[i][k])
				return false;

		//Validate column
		for (int k = 0; k < 9; k++)
			if (k != i && board[i][j] == board[k][j])
				return false;

		//Validate sub-box
		for (int k = 0; k < 9; k++) {
			int row = (i / 3) * 3 + k / 3;
			int col = (j / 3) * 3 + k % 3;
			if ((row != i || col != j) && board[i][j] == board[row][col])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
						  {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
						  {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
						  {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
						  {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
						  {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
						  {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
						  {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
						  {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		for (char[] arr : board) {
			for (char c : arr)
				System.out.print(c + ", ");
			System.out.println();
		}
		
		solution.solveSudoku(board);
		System.out.println();

		for (char[] arr : board) {
			for (char c : arr)
				System.out.print(c + ", ");
			System.out.println();
		}
	}
}
