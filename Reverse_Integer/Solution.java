public class Solution {
	public int reverse(int x) {
		int input = 0, result = 0, nextBit = 0;
		input = Math.abs(x); //Convert input to positive number
		for(int i = 0; input != 0; i++) {
			nextBit = input % 10; //Get last digit from input

			if (result > (Integer.MAX_VALUE - nextBit) / 10) //Overflow detection
				return 0;

			result = result*10 + nextBit; //Append digit to result
			input /= 10; //Right shift input number
		}

		return x > 0 ? result : -result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = -2147483648;
		System.out.println(solution.reverse(x));
	}
}
