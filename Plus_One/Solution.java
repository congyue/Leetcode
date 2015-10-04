public class Solution {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return digits;

		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (carry == 0)    //digits is final result when carry is 0
				return digits;

			int digit = (digits[i] + carry) % 10;  //Do +1 to current bit
			carry = (digits[i] + carry) / 10;  //update carry
			digits[i] = digit;  //update current bit
		}
		if (carry != 0) {  //Overflow handling
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] digits = {2, 4, 1, 8, 9};
		int[] result = solution.plusOne(digits);
		for ( int i : result)
			System.out.print(i);
		System.out.println();
	}
}
