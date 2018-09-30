public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode small_recent = small;
        ListNode big_recent = big;
        ListNode recent = head;
        while (recent != null) {
            if(recent.val < x){
                small_recent.next = recent;
                small_recent = recent;
            }else{
                big_recent.next = recent;
                big_recent = recent;
            }
            recent = recent.next;
        }
        big_recent.next = null;
        small_recent.next = big.next;
        return small.next;
    }

    // Add new nodes, which is nor very good
    public ListNode partition1(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode small_recent = small;
        ListNode big_recent = big;
        while (head != null) {
            int recent = head.val;
            if(recent < x){
                small_recent.next = new ListNode(recent);
                small_recent = small_recent.next;
            }else{
                big_recent.next = new ListNode(recent);
                big_recent = big_recent.next;
            }
            head = head.next;
        }
        small_recent.next = big.next;
        return small.next;
    }

    public static void main(String[] args){
        int[] nums = {1, 4, 3, 2, 5, 1};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode head2 = new Solution().partition(head, 3);
        System.out.println(head2);
    }
}
