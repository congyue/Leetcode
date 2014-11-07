/**
  * P   A   H   N
  * A P L S I I G
  * Y   I   R
  *
  * Index: letter's position at original string
  * Step: index distance between (P,A), (A,H), (H,N), etc
  * midOffset: index distance between (A,P), (L,S), etc
  */
public class Solution {
	public String convert(String s, int nRows) {
		int len = s.length();
		int step = 2*(nRows-1);
		//Arguments that leads to return original string
		if (nRows <= 1 || len <= nRows)
			return s;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < nRows; i++)
			//j always add "step" to jump to next column
			for (int j = i; j < len; j += step) {
				result.append(s.charAt(j));

				//Add middle letter to result, if it exist (Current position isn't at top/bottom line, and j+offset not overflow)
				int midOffset = 2*(nRows - i - 1);
				if (i > 0 && i < nRows - 1 && j + midOffset < len)
					result.append(s.charAt(j + midOffset));
			}

		return result.toString();
	}

	public static void main (String args[]) {
		Solution solution = new Solution();
		String s = "PAYPALISHIRING";
		int nRows = 3;

		System.out.println("Input string: " + s);
		System.out.println("String after " + nRows + " rows ZigZag conversion: " + solution.convert(s, nRows));
	}
}
