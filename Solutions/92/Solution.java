class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    // One-pass solution
    // Time O(n)
    // Space O(1)
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode left = dummy;
        int num = 0;
        while(num <= m - 2){
            left = left.next;
            num++;
        }
        ListNode pre = left;
        ListNode cur = left.next;
        while(num <= n - 1){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            num++;
        }
        left.next.next = cur;
        left.next = pre;
        return dummy.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode recent = dummy;
        int num = 0;
        while(num <= m - 2){
            recent = recent.next;
            num++;
        }
        ListNode left = recent;

        while(num <= n - 1){
            recent = recent.next;
            num++;
        }

        ListNode right = recent.next;
        recent.next = null;
        ListNode newHead = reverseList(left.next);
        left.next.next = right;
        left.next = newHead;
        return dummy.next;
    }

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

    // Add new Nodes
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) return head;
        ListNode negOne = new ListNode(-1);
        negOne.next = head;
        ListNode recent = negOne;
        int num = 0;
        while(num <= m - 2){
            recent = recent.next;
            num++;
        }
        int[] values = new int[n - m + 1];
        ListNode middle = recent;
        while(num <= n - 1){
            middle = middle.next;
            values[num - m + 1] = middle.val;
            num++;
        }
        recent.next = middle;
        ListNode last = middle.next;

        for(int i = 1; i < n - m + 1; i++){
            ListNode now = new ListNode(values[n-m-i]);
            middle.next = now;
            middle = middle.next;
        }
        middle.next = last;
        return negOne.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l4 = new Solution().reverseBetween2(l1, 1,5);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}
