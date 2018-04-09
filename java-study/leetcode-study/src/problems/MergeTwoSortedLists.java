package problems;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        do {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;

            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        } while (l1 != null && l2 != null);

        head.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }
}
