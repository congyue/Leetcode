import java.util.*;
public class BSTIterator {
	Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while(root != null) {	//Push left most path to stack, smallest node will be on top of stack
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode cur = stack.pop();
		int result = cur.val;
		if (cur.right != null) {  //If current node has right child, push left path of that child to stack
			cur = cur.right;
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
		return result;
	}

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = null; right = null; }
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(7);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(4);
		node2.left = new TreeNode(6);
		node2.right = new TreeNode(8);
		root.left = node1;
		root.right = node2;
		
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext())
			System.out.print(i.next() + ", ");
		System.out.println();
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
