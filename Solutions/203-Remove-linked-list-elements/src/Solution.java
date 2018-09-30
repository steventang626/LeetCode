public class Solution {
    // Create dummy node
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode del = cur.next;
                cur.next = del.next;
                del.next = null;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    // Does not create dummy node
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode del = cur.next;
                cur.next = del.next;
                del.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,6,3,4,5,6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        System.out.println(new Solution().removeElements(head, 1));
    }
}
