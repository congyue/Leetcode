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
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() < 2)
			return intervals;

		//Customized comparator to sort by Interval.start
		Comparator<Interval> comp = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		};

		Collections.sort(intervals, comp); // Sort List by Interval.start
		int start = intervals.get(0).start; //Get initial start and end range
		int end = intervals.get(0).end;
		List<Interval> result = new LinkedList<Interval>();
		for (Interval i : intervals) {
			if (i.start <= end)		//New entry has overlapped range, update end...
				end = Math.max(i.end, end);
			else {	//New entry does not overlap, push old (start, end) to result, then update start, end
				result.add(new Interval(start, end));
				start = i.start;
				end = i.end;
			}
		}
		result.add(new Interval(start, end)); //Add last one
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
		intervals.add(solution.new Interval(1, 3));
		intervals.add(solution.new Interval(2, 6));
		intervals.add(solution.new Interval(8, 10));
		intervals.add(solution.new Interval(15, 18));
		List<Interval> result = solution.merge(intervals);
		for (Interval i : result)
			System.out.print("[" + i.start + ", " + i.end + "], ");
		System.out.println();
	}
}
