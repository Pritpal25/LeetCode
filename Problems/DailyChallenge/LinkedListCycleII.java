package DailyChallenge;

public class LinkedListCycleII
{
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if(fast == null) {
                return null;
            }

            fast = fast.next;
            if(fast == null) {
                return null;
            };

            fast = fast.next;
            slow = slow.next;

            if (slow == fast) {
                return findNode(head, slow);
            }

        }
    }

    private ListNode findNode(ListNode head, ListNode slow) {
        ListNode cur = head;

        // This check is needed for the case [1, 2] 0 input case
        if (cur == slow) {
            return cur;
        }

        while(cur.next != slow.next) {
            cur = cur.next;
            slow = slow.next;
        }

        return cur.next;
    }
}
