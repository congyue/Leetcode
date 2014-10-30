
//Leetcode
//Roman to Integer
//
//Congyue Zhang
//zcy7376@gmail.com

public class Solution {
		public int romanToInt(String s) {
			int result = 0, digit1, digit2;

			//Traversal each roman digit
			for (int i = 0; i < s.length(); i++) {
				//If meet last digit, simply add to the end and return.
				if (i == s.length()-1)
					return result + map(s.charAt(i));

				digit1 = map(s.charAt(i));
				digit2 = map(s.charAt(i + 1));
				//If digit1 < digit2, comsume both digits and move index to next untouched digit.
				if (digit1 < digit2) {
					result += digit2 - digit1;
					i ++;
				}
				//If digit1 >= digit2, comsume digit1 and move index to digit2.
				else
					result += digit1;
			}
			return result;
		}

		public int map(char c) {
			switch (c) {
				case 'I': return 1;
				case 'V': return 5;
				case 'X': return 10;
				case 'L': return 50;
				case 'C': return 100;
				case 'D': return 500;
				case 'M': return 1000;
				default: return 0;
			}
		}

		public static void main (String[] args) {
			String roman = "MCMXCVI";

			Solution solution = new Solution();
			int result = solution.romanToInt(roman);

			System.out.printf("%s is converted to %d.\n", roman, result);
		}
}
