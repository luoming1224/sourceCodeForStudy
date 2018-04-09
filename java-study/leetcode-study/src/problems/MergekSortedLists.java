package problems;

public class MergekSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1) {
            return lists[0];
        }

        int len = lists.length;
        while (len > 1) {
            int mid = len / 2;
            for (int i = 0; i < mid; ++i) {
                lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
            }
            len = (len + 1)/2;
        }

        return lists[0];

        /*ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (true) {
            ListNode tmp = null;
            int idx = 0;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null)
                    continue;
                if (tmp == null || lists[i].val < tmp.val) {
                    tmp = lists[i];
                    idx = i;
                }
            }

            if (tmp == null)
                break;

            tail.next = lists[idx];
            lists[idx] = lists[idx].next;
            tail = tail.next;
        }

        return dummy.next;*/
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{};
//        listNodes[0] = new ListNode(1);
//        listNodes[1] = new ListNode(0);

        ListNode r = mergeKLists(listNodes);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
