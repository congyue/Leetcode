import java.util.*;
public class Solution {
	    public boolean isValid(String s) {
			//Create a stack
			Stack<Character> unpairStack = new Stack<Character>();
			//Get each letter of input string
			for (char letter : s.toCharArray()) {
				switch (letter) {
					//Push letter to stack if meet "([{"
					case '(':case '[':case '{':
						unpairStack.push(letter);
						break;
					//Pop letter and compare validness if meet ")]}"
					case ')':case ']':case '}':
						if (unpairStack.isEmpty())
							return false;
						else if (getPair(unpairStack.pop()) != letter)
							return false;
						else
							break;
				}
			}
			//Number does not match if stack isn't empty in the end
			return unpairStack.isEmpty();
		}

		public char getPair(char left) {
			switch (left) {
				case '(': return ')';
				case '[': return ']';
				case '{': return '}';
				default: return ' ';
			}
		}
		public static void main (String [] args) {
			String s = "()[]{}";
			Solution solution = new Solution();
			if (solution.isValid(s))
				System.out.println("String \"" + s + "\" is Valid!");
			else
				System.out.println("String \"" + s + "\" is not Valid!");
		}
}
