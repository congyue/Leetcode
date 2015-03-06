public class Solution {
	public boolean canJump(int[] A) {
		if (A == null || A.length < 1)
			return false;

		int maxRange = 0;
		for (int i = 0; i < A.length; i++) {
			//Check if index i is reachable, or if maxRange cover last index already.
			if (i > maxRange || maxRange >= A.length - 1) break;
			maxRange = Math.max(maxRange, i + A[i]); //Update maxRange if possible
		}
		return maxRange >= A.length - 1 ? true : false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] input = {2,2,1,0,4};
		System.out.println("Jump Game result is: " + solution.canJump(input));
	}
}
