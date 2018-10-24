public class Solution {
    // count the length first
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current = head;
        int num = 1;
        while (num < length / 2) {
            current = current.next;
            num++;
        }
        ListNode listTwo = current.next;
        current.next = null;
        return mergeTwoSortedLists(sortList(head), sortList(listTwo));
    }

    // Do not need to count the length first, but actually does not reduce the operations
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            current = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        current.next = null;
        return mergeTwoSortedLists(sortList1(head), sortList1(slow));
    }

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode recent = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                recent.next = l1;
                l1 = l1.next;
            } else {
                recent.next = l2;
                l2 = l2.next;
            }
            recent = recent.next;
        }
        if(l1 == null) {
            recent.next = l2;
        } else {
            recent.next = l1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode head = new ListNode(nums);
        ListNode result = new Solution().sortList1(head);
        System.out.print(result);
    }
}
