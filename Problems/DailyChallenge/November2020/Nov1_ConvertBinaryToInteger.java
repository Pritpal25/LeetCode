package DailyChallenge.November2020;

/*
Given head which is a reference node to a singly-linked list.
The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.
 */

public class Nov1_ConvertBinaryToInteger
{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int getDecimalValue(ListNode head) {
        int len = 0;

        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;
        int result = 0;

        while (temp != null) {
            result += temp.val*Math.pow(2, len-1);
            len--;
            temp = temp.next;
        }

        return result;
    }
}
