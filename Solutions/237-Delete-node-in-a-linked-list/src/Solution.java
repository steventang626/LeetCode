public class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 9};
        ListNode head = new ListNode(nums);
        ListNode remove = head.next;
        new Solution().deleteNode(remove);
        System.out.print(head);
    }
}
