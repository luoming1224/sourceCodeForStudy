package problems;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int num = x + y + carry;
            if (num >= 10) {
                carry = 1;
                num = num % 10;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(num);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

/*

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode first = null;

        do {
            int s = l1.val + l2.val + carry;
            carry = 0;
            if (s >= 10) {
                carry =1;
                s = s % 10;
            }
            ListNode node = new ListNode(s);
            if (result == null) {
                result = node;
                first = node;
            } else {
                first.next = node;
                first = node;
            }

            l1 = l1.next;
            l2 = l2.next;

        } while (l1 != null && l2 != null);

        if (l1 != null || l2 != null) {
            ListNode l = null;
            if (l1 != null) {
                l = l1;
            } else {
                l = l2;
            }
            do {
                int s = l.val + carry;
                carry = 0;
                if (s >= 10) {
                    carry = 1;
                    s = s % 10;
                }
                ListNode node = new ListNode(s);
                first.next = node;
                first = node;

                l = l.next;
            } while (l != null);
        }

        if (carry != 0) {
            first.next = new ListNode(carry);
        }

        return result;
    }
*/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode m1 = l1;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}