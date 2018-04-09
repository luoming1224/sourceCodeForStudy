package problems;

public class SwapNodesPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, tail = head.next;
        while (head != null && tail != null) {
            prev.next = tail;
            head.next = tail.next;
            tail.next = head;

            prev  = head;
            head = prev.next;
            if (head != null) {
                tail = head.next;
            }
        }
        return dummy.next;
    }
}
