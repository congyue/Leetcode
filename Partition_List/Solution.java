public class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode walker = fakeHead;
		ListNode runner = fakeHead;
		while (walker.next != null) {
			if (walker.next.val >= x) {
				runner = walker.next;
				while (runner.next != null && runner.next.val >= x)
					runner = runner.next;
				//System.out.println("walker at: " + walker.val + ", runner at: " + runner.val);
				if (runner.next != null) {  //Runner now points to node that needs to insert after walker
					ListNode next = runner.next.next;
					runner.next.next = walker.next;
					walker.next = runner.next;
					runner.next = next;
					walker = walker.next;
				}
				else
					walker = runner;  //The list is valid when runner points to last node, so fast-forward the walker too
			}
			else
				walker = walker.next;
		}
		return fakeHead.next;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		ListNode result = solution.partition(head, 3);
		while(result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
