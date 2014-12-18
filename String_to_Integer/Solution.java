public class Solution {
	public int atoi(String str) {
		int len = str.length(), index = -1, result = 0;
		boolean negative = false, overflow = false;
		if (len < 1)
			return 0;
		//Find the first non-space character
		while (++index < len && str.charAt(index) == ' ');
		//System.out.println("Valid start at " + str.charAt(index));
		if (index == len)
			return 0;
		else if (str.charAt(index) == '-') {
			negative = true;
			index++;
		}
		else if (str.charAt(index) == '+')
			index ++;

		for(; index < len; index ++) {
			char c = str.charAt(index);
			if (isNumber(c)) {
				int gain = c - '0';
				//Evaluate two cases that may cause overflow
				if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && gain > Integer.MAX_VALUE%10)) {
					overflow = true;
					break;
				}
				result = 10*result + gain;
				//System.out.println("Current result = " + result);
			}
			else
				break;
		}

		if (overflow && !negative)
			return Integer.MAX_VALUE;
		else if (overflow && negative)
			return Integer.MIN_VALUE;
		else if (negative)
			return -result;
		else
			return result;
	}
	public boolean isNumber(char c) {
		return (c <= '9' && c >= '0');
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "2147483648";
		System.out.println("String \"" + str + "\" has been translated to integer \"" + solution.atoi(str) + "\"");
	}
}
