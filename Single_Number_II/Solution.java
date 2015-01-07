public class Solution {
	public int singleNumber(int[] A) {
		if (A == null || A.length < 1)
			return 0;
		int ones = 0, twos = 0;
		for (int i:A) {
			ones = (ones ^ i) & ~twos;
			twos = (twos ^ i) & ~ones;
		}
		return ones;
	}
	public static void main(String[] args) {
		int[] A = {12,5,7,23,56,12,7,5,5,7,12,23,23};
		Solution solution = new Solution();
		System.out.print("The single number in array [");
		for (int i:A)
			System.out.print(i + ", ");
		System.out.println("] is " + solution.singleNumber(A));
	}
}

/*
   Create status machine for each bit of A[i]: 00 -> 01 -> 10 -> 00
   At the end of the execution, all duplicate number will be cleared, the single number will stay.
   State transition table:
    A[i]	ones	twos	ones'	twos'
	 0		 0		 0		 0		 0
	 0		 0		 1		 0		 1
	 0		 1		 0		 1		 0
	 1		 0		 0		 1		 0
	 1		 0		 1		 0		 0
	 1		 1		 0		 0		 1

	Get the equations for new states (by observation, or using Karnaugh map):
	ones' = (ones ^ A[i]) & ~twos
	twos' = (twos ^ A[i]) & ~ones'

	If input is valid, all bits of single number will eventually stay at ones, all bits of twos should be cleared.
   */
