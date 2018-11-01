public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode head = new ListNode(nums);
        head.next.next.next.next = head.next;
        //System.out.print(head);
        ListNode result = new Solution().detectCycle(head);
        System.out.print(result.val);
    }
}
