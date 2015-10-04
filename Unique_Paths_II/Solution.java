public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[] dp = new int[col];  //Array to store numbers of paths for last row
		dp[0] = 1;  //Initial value at starting point
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {  //j start from 1 since first element in each row is always 1
				if (obstacleGrid[i][j] == 1)
					//No way to get here if there is obstacle
					dp[j] = 0;
				else
					//In-place update the value in dp
					if (j > 0)
						dp[j] = dp[j] + dp[j - 1];
			}
		}
		return dp[col - 1];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] obstacleGrid = {{0, 0, 0},
								{0, 1, 0},
								{0, 0, 0}};
		System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
	}
}
