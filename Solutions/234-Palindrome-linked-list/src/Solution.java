public class Solution {
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

    public boolean compareTwoLists(ListNode l1, ListNode l2) {
        while(l2 != null) {
            if (l2.val != l1.val) return false;
            l2 = l2.next;
            l1 = l1.next;
        }
        return true;
    }

    // Time O(n), Space O(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headTwo = slow.next;
        slow.next = null;
        ListNode listTwo = reverseList(headTwo);
        return compareTwoLists(head, listTwo);
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 2, 3, 2, 2, 1};
        ListNode head = new ListNode(nums);
        //System.out.println(head);

        boolean result = new Solution().isPalindrome(head);
        System.out.println(result);
    }
}
