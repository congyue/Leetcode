//Special case of "Buy and Sell Stock IV"
public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int k = 2;
		int len = prices.length;
		int[][] dp = new int[k + 1][len];
		for (int kk = 1; kk < k + 1; kk++) {
			int tmpMax = dp[kk - 1][0] - prices[0];
			for (int ii = 1; ii < len; ii++) {
				dp[kk][ii] = Math.max(dp[kk][ii - 1], prices[ii] + tmpMax);
				tmpMax = Math.max(tmpMax, dp[kk - 1][ii] - prices[ii]);
			}   
		}   
		return dp[k][len - 1]; 
	}   

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = {20, 18, 15, 17, 19, 14, 16, 21, 30, 27};
		System.out.println(solution.maxProfit(prices));
	}   
}
