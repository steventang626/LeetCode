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

    public void mergeTwoList(ListNode l1, ListNode l2) {
        ListNode head = l1;
        while(head != null) {
            ListNode next = head.next;
            head.next = l2;
            head = next;
            if (l2 == null) break;
            next = l2.next;
            l2.next = head;
            l2 = next;
        }
    }

    public void mergeTwoList2(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headTwo = slow.next;
        slow.next = null;
        ListNode listTwo = reverseList(headTwo);
        mergeTwoList2(head, listTwo);
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(nums);
        //System.out.println(head);

        new Solution().reorderList(head);
        System.out.println(head);
    }
}
