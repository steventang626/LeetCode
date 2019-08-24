public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while(pre.next != null) {
            ListNode current = pre.next;
            int currentNum = current.val;
            ListNode position = dummyHead;
            while(currentNum > position.next.val) {
                position = position.next;
            }
            if(current != position.next) {
                pre.next = current.next;
                current.next = position.next;
                position.next = current;
            } else {
                pre = current;
            }
        }
        return dummyHead.next;
    }

    // The sorted list increases each time, this implementation is easier than the original one
    public ListNode insertionSortList1(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur;
        while(head != null) {
            ListNode t = head.next;
            cur = dummyHead;
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = t;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2 ,3};
        ListNode head = new ListNode(nums);
        ListNode result = new Solution().insertionSortList(head);
        System.out.print(result);
    }
}
