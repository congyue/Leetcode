import java.util.*;
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null)
			return null;
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
			inorderMap.put(inorder[i], i);
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
	}
	private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap) {
		if (preStart > preEnd || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);  //Get root node of this round
		int rootIndex = inorderMap.get(root.val);	//Find index of root in in-order array, so we can get left and right part
		root.left = helper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1, inorderMap);
		root.right = helper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd, inorderMap);
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
		int[] preorder = {1, 2, 4, 5, 3, 6, 8, 7};
		int[] inorder = {4, 2, 5, 1, 6, 8, 3, 7};
		List<String> result = serialized(solution.buildTree(preorder, inorder));
		System.out.println(result);
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
