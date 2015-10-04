public class Solution {
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == 1)
			return dividend;

		if (dividend > 0)  //Use negative range to avoid overflow
			return -divide(-dividend, divisor);
		if (divisor > 0)
			return -divide(dividend, -divisor);
		if (dividend > divisor) //abs(dividend) < abs(divisor)
			return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1)  //Handle overflow case
			return Integer.MAX_VALUE;

		int shift = 0;
		int result = 0;
		while (divisor >= (dividend >> 1)) {  //when abs(divisor) <= abs(dividend >> 1), need to increase abs(divisor)
			divisor <<= 1;
			shift ++;	//Record offset value of divisor
		}
		while (shift >= 0) {
			//System.out.println("dividend is: " + dividend);
			//System.out.println("divisor is: " + divisor);
			if (divisor >= dividend) {  //when abs(divisor) <= abs(dividend), will let abs(dividend) - abs(divisor) and update result
				dividend -= divisor;
				result += 1 << shift;
				//System.out.println("Intermediate quotient: " + result);
			}
			divisor >>= 1;
			shift--;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.divide(1, -1));
	}
}
