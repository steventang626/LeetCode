class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        ListNode l4 = new Solution().partition(l1, 3);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}
