public class Solution {
	public int jump(int[] A) {
		if (A == null || A.length < 1)
			return 0;

		//step: how many steps have used so far
		//currentRange: longest index we can reach in current step
		//nextRange: longest index we can reach in next step
		int step = 0, currentRange = 0, nextRange = 0;
		for (int i = 0; i < A.length && i <= nextRange; i++) { //index i will never catch up nextRange if input is valid
			if (i > currentRange) {  //When index i beyond currentRange...
				currentRange = nextRange;  //We need update currentRange to nextRange...
				step++;  //And cost 1 more step
			}
			//Keep updating longest range for next step, when scanning each possible index of current step
			nextRange = Math.max(nextRange, i + A[i]);
		}
		return nextRange >= A.length - 1 ? step : 0;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] input = {2,2,1,1,4};
		System.out.println("Jump Game result is: " + solution.jump(input));
	}
}
