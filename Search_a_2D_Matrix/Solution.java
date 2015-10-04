public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;

		int l = 0, r = matrix.length - 1;
		while (l <= r) {  //Binary search to find target row
			int mid = (l + r) / 2;
			if (matrix[mid][0] == target)
				return true;
			else if (matrix[mid][0] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		int row = r;
		if (row < 0)    //If target is smaller than first element, return false.
			return false;
		l = 0;
		r = matrix[row].length - 1;
		while (l <= r) {  //Binary search to find target column
			int mid = (l + r) / 2;
			if (matrix[row][mid] == target)
				return true;
			else if (matrix[row][mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return false;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {{1, 3, 5, 7},
						  {10, 11, 16, 20},
						  {23, 30, 34, 50}};
		int target = 16;
		System.out.println(solution.searchMatrix(matrix, target));
	}
}
