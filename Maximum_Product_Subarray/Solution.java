public class Solution {
	public int maxProduct(int[] A) {
		if (A == null)
			return 0;

		int len = A.length;
		//result: Maximum product so far
		//subArrayProdMax: Maximum product in current contiguous subarray
		//subArrayProdMin: Minimum product in current contiguous subarray
		int result = A[0], subArrayProdMax = A[0], subArrayProdMin = A[0];
		for (int i = 1; i < len; i ++) {
			int maxCopy = subArrayProdMax;
			subArrayProdMax = Math.max(A[i], Math.max(maxCopy * A[i], subArrayProdMin * A[i]));
			subArrayProdMin = Math.min(A[i], Math.min(maxCopy * A[i], subArrayProdMin * A[i]));
			result = Math.max(result, subArrayProdMax);;
			//System.out.printf("Max = %d, Min = %d, result = %d\n", subArrayProdMax, subArrayProdMin, result);
		}
		return result;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {2, 3, -2, 4};
		System.out.println(solution.maxProduct(A));
	}
}
