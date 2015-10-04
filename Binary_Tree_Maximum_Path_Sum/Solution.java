/*
   From Leetcode forum
   A path from start to end, goes up on the tree for 0 or more steps, 
   then goes down for 0 or more steps. Once it goes down, it can't go up. 

   Each path has a highest node, 
   which is also the lowest common ancestor of all other nodes on the path.

   A recursive method maxPathDown(TreeNode node) 
   (1) computes the maximum path sum with highest node is the input node, update maximum if necessary 
   (2) returns the maximum sum of the path that can be extended to input node's parent.
 */

import java.util.*;
public class Solution {
	
	int result; //Final result need to be accessible from any recursion call

	public int maxPathSum(TreeNode root) {
		result = Integer.MIN_VALUE;
		maxPathDown(root);
		return result;
	}
	private int maxPathDown(TreeNode root) {
		if (root == null)
			return 0;
		
		int left = Math.max(0, maxPathDown(root.left));  //If maxPathDown(left) < 0, ignore left path 
		int right = Math.max(0, maxPathDown(root.right)); //Same as right path
		result = Math.max(result, left + right + root.val); //Update final result if possible
		return Math.max(left, right) + root.val;  //Choose a larger root-to-leaf sum and return to parent
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(solution.maxPathSum(root));
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
