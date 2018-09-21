class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    // Reversed recursively
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        if (head.next != null) {
            ListNode temp = head;
            head = reverseList(head.next);
            temp.next.next = temp;
            temp.next = null;
        }
        return head;
    }

    // Reversed iteratively
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = new Solution().reverseList1(l1);
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }
}
