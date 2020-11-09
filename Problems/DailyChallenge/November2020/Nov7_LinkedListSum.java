package DailyChallenge.November2020;

public class Nov7_LinkedListSum
{
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      // This solution modifies the input lists
/*    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode sum = add(l1, l2);
        return reverse(sum);
    }

    private static ListNode reverse(ListNode l) {
        ListNode result = null;
        while(l != null) {
            ListNode temp = l;
            l = l.next;
            temp.next = null;

            if (result == null) {
                result = temp;
            } else {
                temp.next = result;
                result = temp;
            }
        }

        return result;
    }

    private static ListNode add(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum;
        ListNode result = null;
        ListNode last = null;

        while(l1 != null || l2 != null) {
            sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int nodeVal = 0;
            if (sum >= 10) {
                nodeVal = sum % 10;
                carry = 1;
            } else {
                nodeVal = sum;
                carry = 0;
            }

            ListNode temp = new ListNode(nodeVal);

            if (result == null) {
                result = temp;
            } else {
                last.next = temp;
            }
            last = temp;
        }

        // Keep this in mind, its easier to forget this case where the carry
        // still has some value in it even when all the node processing is done.
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            last.next = temp;
        }

        return result;
    }*/

    // The below solution does not modify the lists
    static ListNode result = null;
    static int carry = 0;
    static int extra = 0;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        extra = count(l1) - count(l2);

        recursion(l1, l2);

        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = result;
            result = temp;
        }

        return result;
    }

    private static void recursion(ListNode l1, ListNode l2) {
        if (extra > 0) {
            --extra;
            recursion(l1.next, l2);
            createNode(l1.val, 0);
        } else if (extra < 0) {
            ++extra;
            recursion(l1, l2.next);
            createNode(0, l2.val);

        }
        else {
            if (l1.next != null && l2.next != null) {
                recursion(l1.next, l2.next);
            }
            createNode(l1.val, l2.val);
        }
    }

    private static void createNode(int a, int b) {
        int sum = a + b + carry;
        int nodeVal = 0;

        if (sum >= 10) {
            nodeVal = sum%10;
            carry = 1;
        } else {
            nodeVal = sum%10;
            carry = 0;
        }

        ListNode temp = new ListNode(nodeVal);

        if (result == null) {
            result = temp;
        } else {
            temp.next = result;
            result = temp;
        }
    }

    private static int count(ListNode l) {
        int count = 0;

        while(l != null) {
            count++;
            l = l.next;
        }

        return count;
    }

    public static void main(String[] args) {
          ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
          ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(5))));

          ListNode res = addTwoNumbers(l1, l2);

          while(res != null) {
              System.out.println(res.val);
              res = res.next;
          }
    }
}
