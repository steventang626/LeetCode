class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 遍历两次
        int length = 0;
        ListNode ls = head;
        while (ls != null) {
            length++;
            ls = ls.next;
        }
        int num = length - n;
        ListNode ls1 = head;
        for(int i = 0; i < num-1;i++){
            ls1 = ls1.next;
        }
        if(num == 0){
            head = head.next;
        }else{
            ls1.next = ls1.next.next;
        }
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 遍历一次
        ListNode start = head;
        ListNode end = head;
        for(int i = 0; i < n;i++){
            end = end.next;
        }
        if(end == null){
            head = head.next;
        }else{
            while(end.next != null){
                end = end.next;
                start = start.next;
            }
            start.next = start.next.next;
        }
        return head;
    }
    public static void main(String[] args){
        //System.out.println("start");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = new Solution().removeNthFromEnd(l1, 2);
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

}