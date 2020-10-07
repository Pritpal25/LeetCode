public class RotateList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {this.val = val;}
		ListNode(int val, ListNode next) {this.val = val, this.next = next;}
	}

	class Solution {
		public ListNode rotateRight(ListNode head, int k) {
			int size = 0;
			
			ListNode start = head;
			ListNode end = null;
			while(start != null) {
				size++;
				end = start;
				start = start.next;
			}

			if (size == 0)
				return head;
			
			if (k >= size)
				k = k % size;

			if (k == 0)
				return head;
			
			int curr_pos = 1;
			start = head;

			while(curr_pos < size - k) {
				start = start.next;
				curr_pos++;
			}

			end.next = head;
			head = start.next;
			start.next = null;

			return head;
		}
	}

	public static void main(String[] args) {
		
	}
}
