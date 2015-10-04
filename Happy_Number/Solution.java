//Floyd's cycle detection
public class Solution {
	public boolean isHappy(int n) {
		int slow = n, fast = n;  //Set n as starting point
		do {
			slow = squareSum(slow);             //Slow: 1X speed
			fast = squareSum(squareSum(fast));  //Fast: 2X speed
		}while(slow != fast);  //Both reach same place
		//May have two cases: 
		if (slow == 1)  //Both reach endpoint -- 1
			return true;
		return false;   //Loop Exist -- Both reach same digit at next loop
	}
	private int squareSum(int n) {
		int result = 0;
		while(n != 0) {
			result += Math.pow((n % 10), 2);
			n /= 10;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 19;
		System.out.println(solution.isHappy(n));
	}
}
