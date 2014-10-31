
//Leetcode
//Integer to Roman
//
//Congyue Zhang
//zcy7376@gmail.com

public class Solution {
	public String intToRoman(int num) {
		if (num <= 0) {
			return "";
		}
		int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder result = new StringBuilder();

		for (int i = 0; num > 0; i++) {
			//Get weight on each bit
			int weight = num/radix[i];
			//Push roman character to result based on weight value
			for (;weight > 0; --weight)
				result.append(roman[i]);
			//Get the rest of value for next round calculation
			num %= radix[i];
		}

		return result.toString();
	}
	public static void main (String[] args) {
		int input = 1996;
		Solution solution = new Solution();
		System.out.println(input + " is converted to " + solution.intToRoman(input) + ".\n");
	}
}
