public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 5, 3, 4, 0};
        ListNode head = new ListNode(nums);
        head.next.next.next.next = head.next;
        //System.out.print(head);
        Boolean result = new Solution().hasCycle(head);
        System.out.print(result);
    }
}
