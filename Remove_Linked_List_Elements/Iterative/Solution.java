public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead, cur = head;
		while(cur != null) {
			if (cur.val == val)  //Delete current node
				pre.next = cur.next;
			else  //Ignore current node
				pre = cur;
			cur = cur.next;
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
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		ListNode result = solution.removeElements(head, 6);
		while(result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
