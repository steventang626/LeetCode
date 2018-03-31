class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode ls = head;
        head = head.next;
        while(ls.next.next != null){
            ListNode ls1 = ls.next.next;
            ls.next.next = ls;
            if(ls1.next != null){
                ls.next = ls1.next;
                ls = ls1;
            } else {
                ls.next = ls1;
                return head;
            }
        }
        ls.next.next = ls;
        ls.next = null;
        return head;
    }

    public static void main(String[] args){
        //System.out.println("start");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//        ListNode l3 = new ListNode(6);
//        l3.next = new ListNode(10);
//
//        ListNode[] l = new ListNode[4];
//        l[0] = null;
//        l[1] = l1;
//        l[2] = null;
//        l[3] = l3;

        ListNode l4 = new Solution().swapPairs(l1);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}
