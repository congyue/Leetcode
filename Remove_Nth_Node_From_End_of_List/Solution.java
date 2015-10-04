public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 1)
			return head;

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fast = dummyHead, slow = dummyHead;
		
		int gap = 0;
		for (gap = 0; gap < n && fast!= null; gap++)  //Make the gap: fast - slow = n
			fast = fast.next;

		if (gap != n)  //List size less than n
			return dummyHead.next;
		
		//Get the preNode of last Nth node, since we need to reconnect linkedlist
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next; //Delete Nth node (jump over it)
		return dummyHead.next;
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
		
		ListNode result = solution.removeNthFromEnd(head, 2);

		while (result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
