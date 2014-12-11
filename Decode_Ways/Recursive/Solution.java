//Result is correct but time limit will exceed
public class Solution {
	public int numDecodings(String s) {
		//System.out.println("Processing \"" + s + "\"...");
		int len = s.length();
		if (len == 0)
			return 0;
		else if (len == 1 && s.charAt(0) != '0')
			return 1;
		else if (len == 1)
			return 0;
		else if (len == 2) {
			if (s.charAt(1) == '0' && (s.charAt(0) == '1' || s.charAt(0) == '2'))
				return 1;
			else if (s.charAt(0) == '1' && s.charAt(1) != '0')
				return 2;
			else if (s.charAt(0) == '2' && s.charAt(1) <= '6' && s.charAt(1) != '0')
				return 2;
		}

		int result = 0;
		if (s.charAt(1) == '0' && (s.charAt(0) == '1' || s.charAt(0) == '2'))
			result += numDecodings(s.substring(2));
		else if ((s.charAt(0) == '1') || (s.charAt(0) == '2' && s.charAt(1) <= '6'))
			result += numDecodings(s.substring(2)) + numDecodings(s.substring(1));
		else if (s.charAt(0) != '0')
			result += numDecodings(s.substring(1));

		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "2411";
		System.out.println("String \"" + s + "\" have " + solution.numDecodings(s) + " decoding ways.");
	}
}
