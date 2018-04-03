package problems;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1))
            return null;
        ListNode pred = null, last = head;

        for (int i = 0; i < n-1; ++i) {
            last = last.next;
        }
        while (last.next != null) {
            last = last.next;
            if (pred == null) {
                pred = head;
            } else {
                pred = pred.next;
            }
        }
        if (pred == null) {
            ListNode first = head.next;
            head.next = null;
            return first;
        }
        ListNode first = pred.next;
        pred.next = first.next;
        first.next = null;
        return head;
    }
}
