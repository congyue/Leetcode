public class Solution {
	public String reverseWords(String s) {
		if (s == null || s.length() < 1)
			return "";
		//Split string using delima " "
		//May generate "" if there's two spaces in a row
		String[] sArray = s.split(" ");
		StringBuilder result = new StringBuilder();
		//Add each string to result from tail to head
		for (int i = sArray.length - 1; i >= 0; i--) {
			if (!sArray[i].equals(""))
				result.append(sArray[i]).append(" ");
		}

		//If result is valid, remove last space
		return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "the sky is blue";
		System.out.println("\"" + s + "\"");
		System.out.println("\"" + solution.reverseWords(s) + "\"");
	}
}
