import java.util.*;
public class Solution {
	public boolean isScramble(String s1, String s2) {
		//Return false if length are different
		if (s1.length() != s2.length())
			return false;
		//Base case, Return true if strings are equal
		if (s1.equals(s2))
			return true;

		//Check if inputs consist of same letters
		int len = s1.length();
		int[] chars = new int[26];
		for (int i = 0; i < len; i++) {
			chars[s1.charAt(i) - 'a']++;
			chars[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++)
			if (chars[i] != 0)
				return false;

		//Set breakPoints from 1 to len - 1, get substrings
		for (int breakPoint = 1; breakPoint < len; breakPoint++) {
			String s11 = s1.substring(0, breakPoint);
			String s12 = s1.substring(breakPoint);
			String s21 = s2.substring(0, breakPoint);
			String s22 = s2.substring(breakPoint);

			//Compare s1_left with s2_left, s1_right with s2_right
			boolean s11_s21 = isScramble(s11, s21);
			boolean s12_s22 = isScramble(s12, s22);
	/*		System.out.println("Are s11 \"" + s11 + "\" and s21 \"" + s21 + "\" Scramble ? : " + s11_s21);
			System.out.println("Are s12 \"" + s12 + "\" and s22 \"" + s22 + "\" Scramble ? : " + s12_s22);*/
			if (s11_s21 && s12_s22)
				return true;

			//Compare s1_left with s2_swap_left, s1_right with s2_swap_right
			s21 = s2.substring(0, len - breakPoint);
			s22 = s2.substring(len - breakPoint, len);
			boolean s11_s22 = isScramble(s11, s22);
			boolean s12_s21 = isScramble(s12, s21);
	/*		System.out.println("Are s11 \"" + s11 + "\" and s22 \"" + s22 + "\" Scramble ? : " + s11_s22);
			System.out.println("Are s12 \"" + s12 + "\" and s21 \"" + s21 + "\" Scramble ? : " + s12_s21);*/
			if (s11_s22 && s12_s21)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgtae";
		Solution solution = new Solution();
		boolean result = solution.isScramble(s1, s2);

		System.out.print(s1 + " and " + s2 + " are ");
		if (!result)
			System.out.print("not ");
		System.out.println("Scramble Strings to each other.");
	}
}
