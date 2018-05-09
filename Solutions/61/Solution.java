class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode count = head;
        int num = 0;
        while (count != null) {
            num++;
            count = count.next;
        }
        if(num == 0) return head;
        k = k % num;
        if(k == 0 || num == 1) return head;

        count = head;
        int recent = 0;
        while (count != null) {
            recent++;
            if(recent == num - k) break;
            count = count.next;
        }
        ListNode newHead = count.next;
        count.next = null;
        ListNode newCount = newHead;
        while (newCount.next != null) {
            newCount = newCount.next;
        }
        newCount.next = head;

        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        // 更快一点，第二遍不用遍历到末尾
        ListNode count = head;
        if(head == null || head.next == null) return head;
        int num = 0;
        while (count.next != null) {
            num++;
            count = count.next;
        }
        num++;
        k = k % num;
        if(k == 0) return head;

        count.next = head;
        count = head;
        int recent = 0;
        while (count != null) {
            recent++;
            if(recent == num - k) break;
            count = count.next;
        }
        ListNode newHead = count.next;
        count.next = null;
        return newHead;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l4 = new Solution().rotateRight2(l1, 3);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}
