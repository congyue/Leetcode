import java.util.*;
class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new LinkedList<String>();
		nextIPSegment(result, "", s, 1);
		return result;
	}

	public void nextIPSegment(List<String> result, String currentIP, String s, int segment) {
		if (s.length() < (4 - segment + 1) || s.length() > 3 * (4 - segment + 1))
			return;

		//System.out.println("Current IP is: " + currentIP + ", calculating segment " + segment);

		//Treat differently for last IP segment
		if (segment == 4) {
			//Starting zero is not allowed
			if (s.charAt(0) == '0' && s.length() > 1)
				return;

			//Find leagal result, add it to the list
			if (s.length() <= 2
					|| ((s.charAt(0)-'0')*100 + (s.charAt(1)-'0')*10 + (s.charAt(2) - '0')) <= 255) {
				result.add(currentIP + s);
				//System.out.println("--IP added: " + currentIP + s);
			}
			return;
		}

		//Take 1 digit for current position
		nextIPSegment(result, currentIP + s.charAt(0) + ".", s.substring(1), segment + 1);
		//Take 2 digit for current position
		if (s.length() >= 2 && s.charAt(0) != '0')
			nextIPSegment(result, currentIP + s.charAt(0) + s.charAt(1) + ".", s.substring(2), segment + 1);
		//Take 3 digit for current position
		if (s.length () >=3 && s.charAt(0) != '0'
				&& ((s.charAt(0)-'0')*100 + (s.charAt(1)-'0')*10 + (s.charAt(2) - '0')) <= 255)
			nextIPSegment(result, currentIP + s.charAt(0) + s.charAt(1) + s.charAt(2) + ".", s.substring(3), segment + 1);
		return;
	}

	public static void main (String[] args) {
		Solution solution = new Solution();
		String s = "172162541";
		System.out.println("Possible IPs for \"" + s + "\" are: " + solution.restoreIpAddresses(s));
	}
}
