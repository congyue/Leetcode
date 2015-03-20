import java.util.*;
public class Solution {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		int result = 1;			//Result should be at least 1
		int len = points.length;
		for (int i = 0; i < len - 1; i ++) {	//Pick each point as starting point i
			HashMap<Double, Integer> pointMap = new HashMap<Double, Integer>(); //In each loop, create a pointMap to keep track of <slope, num of points>
			int duplicates = 0, localMax = 1;	//duplicates: how many points are same as starting point
			for (int j = i + 1; j < len; j++) { //Pick each point j at right side of starting point

				//System.out.printf("\nProcess points (%d, %d) and (%d, %d)...\n",points[i].x, points[i].y, points[j].x, points[j].y);
				double slope = slopeOf(points[i], points[j]);	//Get slope of point i, j
				if (slope == Double.NEGATIVE_INFINITY) {		//Found dupliates, increase flag and skip this loop
					duplicates++;
					continue;
				}

				if (pointMap.containsKey(slope))
					pointMap.put(slope, pointMap.get(slope) + 1); //If this slope exist, add one more point to pointMap
				else
					pointMap.put(slope, 2);						  //Otherwise, create a new <slope, num of points> pair

				//System.out.println("There are " + pointMap.get(slope) + " points on slope " + slope + ", duplicates = "  + duplicates);
				localMax = Math.max(localMax, pointMap.get(slope)); //Update the max number of unrepeated points in a line
			}
			result = Math.max(result, localMax + duplicates); //Add num of duplicates points to localMax and compare with result
		}
		return result;
	}

	private double slopeOf(Point p1, Point p2) {	//method to get slope of two points
		if (p1.y == p2.y && p1.x == p2.x)
			return Double.NEGATIVE_INFINITY;
		else if (p1.y == p2.y)
			return 0.0;
		else if (p1.x == p2.x)
			return Double.POSITIVE_INFINITY;
		else
			return (double)(p2.y - p1.y)/(p2.x - p1.x);

	}

	static class Point {
		private int x;
		private int y;
		public Point() { x = 0; y = 0; }
		public Point(int a, int b) { x = a; y = b; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		Point[] points = new Point[3];
		points[0] = new Point(0, 0);
		points[1] = new Point(1, 1);
		points[2] = new Point(0, 0);
		/*points[3] = new Point(7, 6);
		points[4] = new Point(8, 4);
		points[5] = new Point(4, 4);
		points[6] = new Point(8, 8);*/
		System.out.println(solution.maxPoints(points));
	}
}
