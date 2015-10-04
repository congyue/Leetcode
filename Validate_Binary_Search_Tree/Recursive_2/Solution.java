import java.util.*;
public class Solution {
	public boolean isValidBST(TreeNode root) {
		List<TreeNode> pre = new ArrayList<TreeNode>();  //Wrapper variable to pass the reference of predecessor node.
		pre.add(null);
		return isValidBST(root, pre);
	}
	public boolean isValidBST(TreeNode root, List<TreeNode> pre) {
		if (root == null)
			return true;
		
		if (!isValidBST(root.left, pre))		//Check left subtree
			return false;

		if (pre.get(0) != null && root.val <= pre.get(0).val)  //Check current node
			return false;
		pre.set(0, root);		//Update predecessor node

		return isValidBST(root.right, pre); //Check right subtree
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(12);
		System.out.println(solution.isValidBST(root));
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
