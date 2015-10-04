public class Solution {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1/x;
		}
		return n % 2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		double x = 4;
		int n = 3;
		System.out.println(solution.myPow(x, n));
	}
}
