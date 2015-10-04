public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) //Negative or ..0 are not palindrome
			return false;
		int reverse = 0;
		while(reverse < x) {	//Reverse half or (half + 1) length of x and save to "reverse"
			reverse = reverse * 10 + (x % 10);
			x /= 10;
		}
		return (reverse == x) || (reverse/10 == x); //Consider 123321 and 12321
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = 12321;
		System.out.println(solution.isPalindrome(x));
	}
}
