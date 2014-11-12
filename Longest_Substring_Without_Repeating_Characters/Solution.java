import java.util.*;
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len <= 1)
			return len;

		int result = 0;
		//Array to record last position for each letter
		int[] ascii = new int[256];
		//Initialize all position to -1
		Arrays.fill(ascii, -1);

		int start = 0, cursor = 0;
		for (cursor = 0; cursor < len; cursor++) {
			/*
			System.out.println("Evaluating : " + s.substring(i, j));*/
			char letter = s.charAt(cursor);
			//Letter didn't appear before, add to record
			if (ascii[letter] == -1)
				ascii[letter] = cursor;
			//Letter appeared before, update result if necessary
			//Move starting point next to this letter's last position
			//And clean all the position info on the way
			//e.g. [abcdefgd]hijklm -> abcd[efgd]hijklm, ascii[a,b,c,d] are cleaned to -1
			else {
				if (result < cursor - start)
					result = cursor - start;
				for (; s.charAt(start) != letter; start++)
					ascii[s.charAt(start)] = -1;

				start++;
				ascii[letter] = cursor;
			}
		}

		//Check last time for remaining letters
		if (result < cursor - start)
			result = cursor - start;

		return result;
	}
	public static void main (String[] args) {
		Solution solution = new Solution();
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println("The length of longest non-repeating substring is " + solution.lengthOfLongestSubstring(s));
	}
}
