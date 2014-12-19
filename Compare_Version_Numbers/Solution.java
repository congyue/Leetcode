public class Solution {
	public int compareVersion(String version1, String version2) {
		int len1 = version1.length(), len2 = version2.length(), i = 0, j = 0;
		//Get number of each segment divide by '.'
		while(i < len1 || j < len2) {
			int value1 = 0, value2 = 0;
			//Get current segment from version1
			while(i < len1 && version1.charAt(i) != '.')
				value1 = 10*value1 + version1.charAt(i++) - '0';
			i++;

			//Get current segment from version2
			while(j < len2 && version2.charAt(j) != '.')
				value2 = 10*value2 + version2.charAt(j++) - '0';
			j++;

			//Compare this segment, return result if different
			if (value1 > value2)
				return 1;
			else if (value1 < value2)
				return -1;
		}
		//No different till the end, return 0
		return 0;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String version1 = "5.6", version2 = "13.2";
		switch(solution.compareVersion(version1, version2)) {
			case 1: System.out.println(version1 + " is newer than " + version2); break;
			case -1: System.out.println(version1 + " is older than " + version2); break;
			case 0: System.out.println(version1 + " is same with " + version2); break;
			default: break;
		}
	}
}
