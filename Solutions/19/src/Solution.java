class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {


    public static void main(String[] args) {
        //System.out.println("start");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = new Solution().removeNthFromEnd(l1, 2);
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 遍历两次
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int num = length - n;
        if (num == 0) {
            head = head.next;
            return head;
        }
        cur = head;
        for (int i = 0; i < num - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    // 遍历一次
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        if (end == null) {
            head = head.next;
        } else {
            while (end.next != null) {
                end = end.next;
                start = start.next;
            }
            start.next = start.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}