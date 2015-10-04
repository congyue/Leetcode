public class Solution {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode walker = head;
		ListNode runner = head;
		while(runner.next != null && runner.next.next != null) {  //Find middle node using two pointers
			walker = walker.next;
			runner = runner.next.next;
		}
		ListNode head1 = head;
		ListNode head2 = walker.next;
		walker.next = null;  //Break list to two parts
		head2 = reverse(head2);  //Reverse second part
		while(head1 != null && head2 != null) {  //Merge two lists
			ListNode next = head2.next;
			head2.next = head1.next;
			head1.next = head2;
			head1 = head2.next;
			head2 = next;
		}
	}
	private ListNode reverse(ListNode head) {
		ListNode newHead = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = newHead;
			newHead = cur;
			cur = next;
		}
		return newHead;
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
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		solution.reorderList(head);
		ListNode result = head;
		while(result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
