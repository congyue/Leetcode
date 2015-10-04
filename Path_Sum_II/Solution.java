import java.util.*;
public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> item = new LinkedList<Integer>();
		helper(result, item, root, sum);
		return result;
	}
	private void helper (List<List<Integer>> result, List<Integer> item, TreeNode root, int sum) {
		if (root == null)
			return;
		if (root.left == null && root.right == null && root.val == sum) {  //Valid path found
			List<Integer> itemCopy = new LinkedList<Integer>(item);  //Create deep copy of item
			itemCopy.add(root.val);  //Add final node to itemCopy
			result.add(itemCopy);  //Add to result
			return;
		}
		
		if (root.left != null) {
			item.add(root.val);  //Add current node to item
			helper(result, item, root.left, sum - root.val); //Explore left path
			item.remove(item.size() - 1); //Recover the state of item after recursion call
		}

		if (root.right != null) {
			item.add(root.val);
			helper(result, item, root.right, sum - root.val); //Explore right path
			item.remove(item.size() - 1);
		}
	}
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(4);
		root1.left.left = new TreeNode(8);
		root1.left.right = new TreeNode(4);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(3);

		System.out.println(solution.pathSum(root1, 11));
	}
}
