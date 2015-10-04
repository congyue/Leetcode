import java.util.*;
public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;
		return sortedArrayToBST(num, 0, num.length - 1);
	}
	public TreeNode sortedArrayToBST(int[] num, int low, int high) {
		if (low > high)
			return null;
		int mid = (high + low)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, low, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, high);
		return root;
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = {1, 2, 3, 4, 5, 6, 7};
		TreeNode result = solution.sortedArrayToBST(num);
		System.out.println(serialized(result));
	}
	public static List<String> serialized(TreeNode t) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<String> result = new ArrayList<String>();

		queue.add(t);
		while(!queue.isEmpty()) {
			TreeNode newNode = queue.remove();
			if (newNode != null)
				result.add(Integer.toString(newNode.val));
			else {
				result.add("#");
				continue;
			}
			queue.add(newNode.left);
			queue.add(newNode.right);
		}
		return result;
	}
}
