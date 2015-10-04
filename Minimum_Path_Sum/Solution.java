public class Solution {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return -1;

		int[] dp = new int[grid[0].length];
		dp[0] = grid[0][0];
		for (int i = 1; i < grid[0].length; i++)  //Initialize first line
			dp[i] = dp[i - 1] + grid[0][i];

		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0)  //First column can only come from top element
					dp[j] += grid[i][j];
				else {  //The rest of nodes can come from left or top
				dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
				System.out.println("[" + i + ", " + j + "]: " + dp[j]);
				}
			}
		}
		return dp[grid[0].length - 1];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] grid = {{3, 5, 2},
						{5, 6, 8},
						{7, 1, 9}};
		System.out.println(solution.minPathSum(grid));
	}
}
