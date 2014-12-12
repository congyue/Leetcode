public class Solution {
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int checkPoint = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j;
				checkPoint = i;
				j++;
			} else if (star != -1) {
				j = star + 1;
				i = ++checkPoint;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "mississippi", p = "m*issi*iss*";
		boolean result = solution.isMatch(s, p);
		System.out.println("\"" + p + "\"" + (result ? " matches " : " does not match ") + "\"" + s + "\"");
	}
}
