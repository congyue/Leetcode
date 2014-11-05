public class Solution {
	public String addBinary(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		//Return initial value if any of them is empty
		if (lenA == 0 || lenB == 0)
			return a + b;

		int carry = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= Math.max(lenA, lenB); i++) {
			//Get each bit start from LSB, if applicable
			int bitA = lenA - i >= 0 ? a.charAt(lenA - i) - '0' : 0;
			int bitB = lenB - i >= 0 ? b.charAt(lenB - i) - '0' : 0;
			//Get decimal sum
			int sum = bitA + bitB + carry;
			//binray sum is sum%2, binary carry bit is sum/2
			result.insert(0, sum % 2);
			carry = sum/2;
		}
		//If carry still exist, put it to MSB
		if (carry == 1)
			result.insert(0, "1");

		return result.toString();
	}
	public static void main (String[] args) {
		Solution solution = new Solution();
		String a = "11";
		String b = "1";
		System.out.println("Result of " + a + " + " + b + " is " + solution.addBinary(a, b));
	}
}
