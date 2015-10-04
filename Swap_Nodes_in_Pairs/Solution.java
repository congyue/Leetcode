public class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		
		for (ListNode cur = dummyHead; cur.next != null && cur.next.next != null; cur = cur.next.next)
			cur.next = swap(cur.next, cur.next.next);

		return dummyHead.next;
	}

	private ListNode swap (ListNode left, ListNode right) {
		left.next = right.next;
		right.next = left;
		return right;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);

		ListNode result = solution.swapPairs(l1);
		while (result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
