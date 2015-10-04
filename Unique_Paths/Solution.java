public class Solution {
	public int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;

		int[] dp = new int[n];  //Array to store numbers of paths for last row
		dp[0] = 1;  //Initial value at starting point
		for (int row = 0; row < m; row++) {
			for (int col = 1; col < n; col++) {  //j start from 1 since first element in each row is always 1

				//In-place update the value in dp
				dp[col] = dp[col] + dp[col - 1];
			}
		}
		return dp[n - 1];
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int m = 3;
		int n = 7;
		System.out.println(solution.uniquePaths(m, n));
	}
}
