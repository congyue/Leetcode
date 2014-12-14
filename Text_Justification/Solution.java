import java.util.*;
public class Solution {
	public List<String> fullJustify(String[] words, int L) {
		int start, end, count = 0;
		StringBuilder thisLine = new StringBuilder();
		List<String> result = new LinkedList<String>();
		end = words.length;
		if (end <= 0)
			return result;
		//Get words for this line.
		//When finish, "start" will be next to last word
		for (start = 0; start < end; start++) {
			//First word, no space is needed
			if (count == 0 && count + words[start].length() <= L)
				count += words[start].length();
			//Following words must start with a space
			else if (count != 0 && count + words[start].length() + 1 <= L)
				count += words[start].length() + 1;
			//Abort if meet the requirement
			else
				break;
		}

		//paddings: How many extra spaces needed to add
		//slots: How many slots currently have in this line
		//quotient: How many spaces needed add to each slot
		//remainder: How many extra spaces needed to distribute from left to right
		int paddings = L - count, slots = start - 1;
		int quotient = (slots == 0 ? 0 : paddings/slots);
		int remainder = (slots == 0 ? paddings : paddings%slots);
		//System.out.println("This line need " + paddings + " paddings inserted to " + slots + " slots. Add " + quotient + " to each slot and allocate " + remainder + " extra slots from left to right.");
		//For each line except last line...
		if (start != end) {
			for (int i = 0; i < start; i++) {
				thisLine.append(words[i]);
				if (slots-- > 0) {
					//For each slot, add regular space and "quotient" extra spaces
					addSpaces(thisLine, quotient + 1);
					//If remainder exist, keep adding 1 more space at this slot
					if (remainder-- > 0)
						addSpaces(thisLine, 1);
				}
			}
			//For remainder > slots cases, append all remainder spaces to the end
			addSpaces(thisLine, remainder);
		}
		//In case of last line...
		else {
			for (int i = 0; i < start; i++) {
				thisLine.append(words[i]);
				if (slots-- > 0)
					//Each slot only add 1 space
					addSpaces(thisLine, 1);
			}
			//Then append all required spaces to the end
			addSpaces(thisLine, paddings);
		}
		//Add this line to result, then recursively process the rest of words array.
		result.add(thisLine.toString());
		result.addAll(fullJustify(Arrays.copyOfRange(words, start, end), L));
		return result;
	}

	//Helper function
	public void addSpaces(StringBuilder s, int count) {
		if (count > 0) {
			int i = 0;
			while (i++ < count) s.append(" ");
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int L = 6;
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		List<String> result = solution.fullJustify(words, L);
		System.out.println("[");
		for (String s : result)
			System.out.println("\"" + s + "\"");
		System.out.println("]");
	}
}
