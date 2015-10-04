public class Solution {
	public boolean exist(char[][] board, String word) {
		if (word == null)
			return true;
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;

		char[] word_array = word.toCharArray();
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++)
				if (exist(board, row, col, word_array, 0)) 
					return true;
		return false;
	}
	private boolean exist(char[][] board, int row, int col, char[] word_array, int index) {
		if (index == word_array.length)  //All words have been found in the board
			return true;
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)  //Give up searching when out of bound
			return false;
		if (board[row][col] != word_array[index])  //Word at current board position does not match the word looking for
			return false;
		board[row][col] ^= 256;  //Set flag bit in place to make word invalid to use again
		boolean result = 
			exist(board, row, col + 1, word_array, index + 1) ||
			exist(board, row, col - 1, word_array, index + 1) ||
			exist(board, row + 1, col, word_array, index + 1) ||
			exist(board, row - 1, col, word_array, index + 1);
		board[row][col] ^= 256;  //Clear flag bit after this round of search
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = {{'A', 'B', 'C', 'E'},
						  {'S', 'F', 'C', 'S'},
						  {'A', 'D', 'E', 'E'}};
		String word = "ABCED";
		System.out.println(solution.exist(board, word));
	}
}
