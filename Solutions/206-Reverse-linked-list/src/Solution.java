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
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head2 = new Solution().reverseList1(head);
        System.out.println(head2);
    }
}
