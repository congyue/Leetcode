public class Solution {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length !=9)
			return false;

		boolean[][] rowMatrix = new boolean[9][10]; //rowMatrix[N][i]: Number i appeared before at row N?
		boolean[][] colMatrix = new boolean[9][10]; //colMatrix[N][i]: Number i appeared before at column N?
		boolean[][] subMatrix = new boolean[9][10]; //subMatrix[N][i]: Number i appeared before at sub-box N?
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')
					continue;
				//System.out.println("Validating " + board[i][j]);
				int digit = board[i][j] - '0';
				//Validate row
				if (rowMatrix[i][digit] == false)
					rowMatrix[i][digit] = true;
				else
					return false;
				//Validate column
				if (colMatrix[j][digit] == false)
					colMatrix[j][digit] = true;
				else
					return false;
				//Validate sub-box
				if (subMatrix[(i / 3) * 3 + j / 3][digit] == false)
					subMatrix[(i / 3) * 3 + j / 3][digit] = true;
				else
					return false;
			}
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
		System.out.println(solution.isValidSudoku(board));
	}
}
