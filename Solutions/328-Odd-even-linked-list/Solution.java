public class Solution {
    // Time O(n)
    // Space O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenStart = head.next, recent = even.next;
        int num = 3;
        while (recent != null) {
            if (num % 2 == 1) {
                odd.next = recent;
                odd = recent;
            } else {
                even.next = recent;
                even = recent;
            }
            num++;
            recent = recent.next;
        }
        odd.next = evenStart;
        even.next = null;
        return head;
    }
    public static void main(String[] args){
        int[] nums = {2, 1, 3, 5, 6, 4, 7};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head1 = new Solution().oddEvenList(head);
        System.out.println(head1);
    }
}
