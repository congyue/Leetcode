public class Solution {
	    public int lengthOfLastWord(String s) {
			//i and j point to the head and tail of last word.
			int j = s.length()-1, i;

			while(j >= 0) {
				//Find the tail of last word
				if (s.charAt(j) == ' ')
					j--;
				//j points to tail, then find the head of last word
				else {
					for (i = j; i >= 0; i--)
						if (s.charAt(i) == ' ')
							break;
					i++;
					return j - i + 1;
				}
			}
			return 0;
		}
		public static void main (String[] args) {
			String s = "Hello World";
			Solution solution = new Solution();
			System.out.println("The last word length of \"" + s + "\" is " + solution.lengthOfLastWord(s));
		}
}
