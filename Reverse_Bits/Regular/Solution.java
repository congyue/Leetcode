public class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result << 1 | (n & 1); //Copy 32 bits 1 by 1
			n >>>= 1;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = Integer.valueOf("00000010100101000001111010011100", 2);
		int result = solution.reverseBits(n);
		System.out.println("Decimal: " + result);
		System.out.println("Binary: " + Integer.toString(result, 2));
	}
}
