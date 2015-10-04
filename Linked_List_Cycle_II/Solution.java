//Floyd's cycle detection
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode walker = head;
		ListNode runner = head;
		while(runner != null && runner.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner)
				break;
		}

		if (walker != runner)
			return null;
		runner = head;
		while(walker != runner) {
			walker = walker.next;
			runner = runner.next;
		}
		return walker;
	}
	private void printList(ListNode node) {
		while(node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(8);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(7);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;

		System.out.println(solution.detectCycle(n1).val);
	}
}
