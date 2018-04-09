package problems;

/**
 * 原始链表为：0-->1-->2-->3-->4-->5; k=3
 * 预期结果为：2-->1-->0-->5-->4-->3
 * 第一步先添加一个dummy节点：dummy-->0-->1-->2-->3-->4-->5
 * tail指向节点2，将head指向节点0，prev指向节点dummy
 * 依次将节点0、节点1移到tail节点2的后面
 * 第一步将节点0移到tail节点后面，则中间状态为：dummy-->1-->2-->0-->3-->4-->5
 * 第二步将节点1移到tail节点后面，则中间状态为：dummy-->2-->1-->0-->3-->4-->5
 * 更新prev、tail指向head（即节点0）,
 * 重新执行以上步骤，直到全部反转结束
 */

public class ReverseNodesKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1 || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy, temp;

        while (true) {
            for (int i = 0; i < k && tail != null; ++i) {
                tail = tail.next;
            }
            if (tail == null)
                break;

            head = prev.next;

            while (prev.next != tail) {

                temp = prev.next;

                prev.next = temp.next;

                temp.next = tail.next;

                tail.next = temp;

            }

            tail = head;

            prev = head;

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        for (int i = 2; i < 6; ++i) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }

        ListNode r = reverseKGroup(head, 2);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
        System.out.println();
    }
}
