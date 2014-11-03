public class Solution {
	public String countAndSay(int n) {
		//Set initial sequence to "1"
		String currentSeq = "1";

		if (n <= 0)
			return "";
		if (n == 1)
			return currentSeq;

		//Get next sequence for n-1 times to get nth sequence
		while (--n > 0)
			currentSeq = getNextSeq(currentSeq);

		return currentSeq;
	}

	public String getNextSeq(String currentSeq) {

			StringBuilder nextSeq = new StringBuilder();
			int count = 0;
			char c_last = currentSeq.charAt(0);
			for (char c : currentSeq.toCharArray()) {
					//Count add 1 if current letter = last letter
					if (c_last == c)
						count++;
					//Append count and last letter to result if different letter is met
					else
					{
						nextSeq.append(count);
						nextSeq.append(c_last);
						c_last = c;
						count = 1;
					}
			}
			//Append count and letter for tail letters
			nextSeq.append(count);
			nextSeq.append(c_last);
			return nextSeq.toString();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 5;
		System.out.println("The sequence at index " + n + " is " + solution.countAndSay(n));
	}
}
