public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int result = 0;
		while(n != 0) {
			result++;
			n &= n - 1; //Delete last "1" in the binary sequence
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 11;
		System.out.println(solution.hammingWeight(n));
	}
}
