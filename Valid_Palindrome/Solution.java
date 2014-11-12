public class Solution {
	public boolean isPalindrome(String s) {
		int len = s.length();
		if (len <=1)
			return true;

		char[] sArray = s.toLowerCase().toCharArray();
		int start = 0, end = len - 1;
		while(start < end) {
			while (start < end && !Character.isLetterOrDigit(sArray[start]))
				start ++;

			while (start < end && !Character.isLetterOrDigit(sArray[end]))
				end--;

			//System.out.println("Comparing " + sArray[start] + " and " + sArray[end] + " ...");
			if (sArray[start] != sArray[end])
				return false;

			start++;
			end--;
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "A man, a plan, a canal: Panama";
		System.out.printf("String \"" + s + "\" is ");
		if (!solution.isPalindrome(s))
			System.out.printf("not ");
		System.out.println("palindrome");
	}
}
