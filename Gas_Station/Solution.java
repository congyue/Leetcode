/*
   If no valid starting point:
   Sum{[0] ... [END]} < 0

   if valid starting point exist:
   There must be a "mid" that:
   Sum{[0] ... [END]} > 0, Sum{[0] ... [mid - 1]} < 0, Sum{[mid] ... [END]} > 0

   Define "total" to track Sum{[0] ... [END]}
   Define "localSum" to track Sum{[start] ... [current]} and find "mid"
*/

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length)
			return -1;
		int total = 0;    //(Total gas gain) - (total gas cost) in whole trip
		int localSum = 0; //(gas gain) - (gas cost) from current start point
		int start = 0;   //Valid starting point to finish the whole trip
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
			localSum += gas[i] - cost[i];
			if (localSum < 0) {  //Current starting point is invalid
				localSum = 0;    //Clear localSum
				start = i + 1;   //Pick starting point at i + 1
			}
		}
		return total >= 0 ? start : -1;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] gas = {1, 2, 2, 15, 2, 2, 1};
		int[] cost = {2, 3, 3, 4, 3, 3, 2};
		System.out.println(solution.canCompleteCircuit(gas, cost));
	}
}
