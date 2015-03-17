/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null)
			return null;

		int newStart = newInterval.start;
		int newEnd = newInterval.end;
		List<Interval> result = new LinkedList<Interval>();
		for (Interval i : intervals) {
			if (newStart > i.end)			// [i], {new} --> "pre-overlapping" mode, when new range after i
				result.add(i);
			else if (newEnd >= i.start){	// {[ ]} or {[ }] or [{ ]} --> "overlapping" mode, when new range and i overlapping
				newStart = Math.min(newStart, i.start);
				newEnd = Math.max(newEnd, i.end);
			}
			else {							// {new} [i] --> "post-overlapping" mode, when new before i
				if (newStart >= 0 && newEnd >=0) {
					result.add(new Interval(newStart, newEnd));
					newStart = -1;
					newEnd = -1;
				}
				result.add(i);
			}
		}
		if (newStart >=0 && newEnd >=0)		// ...[last i]}, if loop finished from "overlapping" mode, need add new range to result manually
			result.add(new Interval(newStart, newEnd));
		return result;
	}

	public class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(solution.new Interval(1, 2));
		intervals.add(solution.new Interval(3, 5));
		intervals.add(solution.new Interval(6, 7));
		intervals.add(solution.new Interval(8, 10));
		intervals.add(solution.new Interval(12, 16));
		List<Interval> result = solution.insert(intervals, solution.new Interval(4, 9));
		for (Interval i : result)
			System.out.print("[" + i.start + ", " + i.end + "], ");
		System.out.println();
	}
}
