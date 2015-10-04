import java.util.*;
public class Solution {
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {	//Find the left most node and store the path to stack
				stack.push(cur);
				cur = cur.left;
			}
			else {
				cur = stack.pop();  //Pick next node to process
				if (pre != null && cur.val <= pre.val)  //Current node should larger than predecessor
					return false;
				pre = cur;			//Update predecessor to current node
				cur = cur.right;	//Update current to right child (if null, it will pick one from stack next loop)
			}
		}
		return true;
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
