public class Solution {
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;

		int result = 0;
		int min = num[0], max = min;
		for (int i : num) {
			if (i < min)
				min = i;
			else if (i > max)
				max = i;
		}

		int step = (max - min - 1)/(num.length - 1) + 1; //Formula to do Math.ceilling((max - min)/(num.length - 1))

		/*if ((max - min)%(num.length - 1) > 0)	//Alternative way to do ceilling
			step ++;*/
		//int bucketSize = step; 			//For regular bucket sort, set the bucketSize equal to step
		int bucketSize = 2; 				//For this question, we only store local max and min value
		int bucketNum = num.length;			//BucketNum is ((max - min)/len + 1), which is always num.size
		int[][] bucket = new int[bucketNum][bucketSize]; //bucket[N][0]: min value in this bucket
														 //bucket[N][1]: max value in this bucket
		for (int i : num) {
			int index = (i - min)/step;		//Index(offset) can be calculated by this formula
			if (bucket[index][0] == 0 && bucket[index][1] == 0) { //bucket not initialized
				bucket[index][0] = i;	//Set both max and min to first value
				bucket[index][1] = i;
			}
			else if (i <= bucket[index][0])
				bucket[index][0] = i;
			else if (i > bucket[index][1])
				bucket[index][1] = i;
		}
		/*
		System.out.println("Bucket layout: ");
		for (int[] arr : bucket) {
			System.out.print("{ ");
			for (int i : arr) {
				System.out.print(i + ", ");
			}
			System.out.print("}, ");
		} */

		int i = 0, j = i + 1;
		while(i < bucketNum && j < bucketNum) {
			//System.out.println("Comapring gap between: " + bucket[i][1] + " and " + bucket[j][0]);
			if (bucket[i][1] <= bucket[j][0]) {		//two buckets are valid to compare
				result = Math.max(result, bucket[j][0] - bucket[i][1]);
				i = j;								//continue to compare buckets after j
				j++;
			}
			else {									//bucket j may be empty, find next bucket
				j ++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.print("{");
		int[] num = {3, 6, 9, 1};
		for (int i : num)
			System.out.print(i + ", ");
		System.out.println("}");
		System.out.println(solution.maximumGap(num));
	}
}
