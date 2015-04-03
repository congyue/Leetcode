public class Solution {
	public int rob(int[] num) {
		if (num == null || num.length == 0)
			return 0;

		int len = num.length;
		int[] dp = new int[len + 1]; //If compression needed, change here to int[] dp = new int [3]
		dp[1] = num[0];
		for (int i = 2; i < len + 1; i ++)
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i - 1]); //If compression needed, change all dp[x] to dp[x % 3]
		return dp[len];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = {1,3,2,6,5,3,7};
		System.out.println(solution.rob(num));
	}
}
