import java.util.*;
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int level = 0;

		while (!stack.isEmpty()) {  //Outer loop, for iterating all TreeNodes
			List<Integer> item = new LinkedList<Integer>();    //Store result in this level
			Stack<TreeNode> newStack = new Stack<TreeNode>();  //new stack for storing TreeNodes for next loop
			while(!stack.isEmpty()) {  //inner loop, for scanning all TreeNodes in current stack
				TreeNode cur = stack.pop();
				item.add(cur.val);
				if (level % 2 == 0) {
					if (cur.left != null)
						newStack.push(cur.left);
					if (cur.right != null)
						newStack.push(cur.right);
				}
				else {
					if (cur.right != null)
						newStack.push(cur.right);
					if (cur.left != null)
						newStack.push(cur.left);
				}
			}
			result.add(item);  //Add this level to result
			level++;           //Update level number
			stack = newStack;  //Switch to next stack for more TreeNodes if available
		}
		return result;
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(solution.zigzagLevelOrder(root));
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
