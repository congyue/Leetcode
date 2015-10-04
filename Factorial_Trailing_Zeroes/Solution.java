//Example:
//2147483647!
//=2 * 3 * ...* 5 ... *10 ... 15* ... * 25 ... * 50 ... * 125 ... * 250...
//=2 * 3 * ...* 5 ... * (5^1*2)...(5^1*3)...*(5^2*1)...*(5^2*2)...*(5^3*1)...*(5^3*2)... (Equation 1)
//-> Just need to count how many 5s are there in Equation 1
//-> Multiple of 5 provides one 5, multiple of 25 provides two 5 and so on
//-> No need to count 2 since [5k + 1] ~ [5k + 4] have at least two 2s
//Steps:
//10 / 5 = 2
//2 / 5 = 0
//Result = 2 + 0 = 2

public class Solution {
	public int trailingZeroes(int n) {
		return n == 0 ? 0 : (n / 5 + trailingZeroes(n / 5));
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.trailingZeroes(25));	
	}
}
