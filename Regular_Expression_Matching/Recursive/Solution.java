public class Solution {
	public boolean isMatch(String s, String p) {
		int lenS = s.length();
		int lenP = p.length();
		//System.out.println("Matching " + s + " and " + p);

		if (lenP == 0 && lenS == 0)
			return true;
		else if (lenP == 0 && lenS > 0)
			return false;
		else if (lenS == 0 && lenP == 1)
			return false;
		else if (lenS == 0 && lenP > 1 && p.charAt(1) != '*')
			return false;

		//Inputs are leagal, start compare...
		if (lenP > 1 && p.charAt(1) == '*') {
			//If '*' is detected next to current letter of p, try to match s and p.substring(2) first.
			if (isMatch(s, p.substring(2)))
				return true;

			//Try to match more and more letters of s by using p[0-1]
			for (int i = 0; i < lenS; i++)
				//If current letter of p and s are matched, continue check the rest of s and p.
				if (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.') {
					//If find a valid match, return directly
					if (isMatch(s.substring(i+1), p.substring(2)))
						return true;
				}
				//If current letter have no way to match, abort iteration and return false.
				else
					break;
		}
		//If no '*' is detected, current letter must be match, then check the rest of s and p
		else if ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1)))
			return true;

		//System.out.println("Matching " + s + " and " + p + " failed, backtracking ...");
		return false;
		}

	public static void main (String[] args) {
		Solution solution = new Solution();
		String s = "a";
		String p = ".*..a*";
		System.out.println("\"" + p + "\" and \"" + s + "\" match? -- " + solution.isMatch(s, p));
	}
}
