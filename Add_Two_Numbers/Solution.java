public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode result = head;
		int localSum = 0;
		while(l1 != null || l2 != null) {
			if (l1 != null) {
				localSum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				localSum += l2.val;
				l2 = l2.next;
			}
			result.next = new ListNode(localSum % 10);
			result = result.next;
			localSum /= 10;  //Update carry for next round
		}
		if (localSum != 0)  //Check if there is additional carry bit
			result.next = new ListNode(localSum);

		return head.next;
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = solution.addTwoNumbers(l1, l2);
		while (result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
