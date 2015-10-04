public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode walker = head;
		ListNode runner = head;
		int index = 0;
		while(runner != null && index < k) {
			runner = runner.next;
			index++;
		}
		if (runner == null) {  //When runner == null, means k > length, and index == length
			k %= index;
			runner = head;
			index = 0;
			while(runner != null && index < k) {  //Runner run again after processing k
				runner = runner.next;
				index++;
			}
		}  //Runner now k steps away from walker
		while(runner.next != null) {
			walker = walker.next;
			runner = runner.next;
		}  //Runner now points to last node, walker points to kth last node
		runner.next = head;
		ListNode newHead = walker.next;
		walker.next = null;
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
		ListNode result = solution.rotateRight(head, 2);
		while(result.next != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println(result.val);
	}
}
