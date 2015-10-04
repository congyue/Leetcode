public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int len = prices.length;
		int minPrice = prices[0];
		int result = 0;

		for (int i = 1; i < len; i++) {
			if (prices[i] < minPrice)
				minPrice = prices[i];
			else 
				result = Math.max(result, prices[i] - minPrice);
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = {20, 18, 15, 17, 19, 14, 16, 21, 30, 27};
		System.out.println(solution.maxProfit(prices));
	}
}
