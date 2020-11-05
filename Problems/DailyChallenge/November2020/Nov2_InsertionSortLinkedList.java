package DailyChallenge.November2020;

/*
Sort a linked list using insertion sort.
 */

public class Nov2_InsertionSortLinkedList
{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode sorted = head;
        ListNode unsorted = head.next;
        // This is necessary to separate the sorted and unsorted lists.
        // Missed this in 1st iteration
        sorted.next = null;

        while(unsorted != null) {
            ListNode temp_unsorted = unsorted;
            unsorted = unsorted.next;
            temp_unsorted.next = null;

            if (temp_unsorted.val <= sorted.val) {
                temp_unsorted.next = sorted;
                sorted = temp_unsorted;
            }
            else {
                ListNode current = sorted;
                ListNode next = sorted.next;

                while(next != null && (next.val < temp_unsorted.val)) {
                    current = next;
                    next = next.next;
                }

                temp_unsorted.next = next;
                current.next = temp_unsorted;
            }
        }

        head = sorted;
        return head;
    }
}
