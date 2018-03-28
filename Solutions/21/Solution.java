import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode beginning = new ListNode(-1);
        ListNode current = beginning;
        while((l1 != null) || (l2 != null)) {
            if((l1 == null) || ((l2 != null) && (l1.val > l2.val))){
                current.next = new ListNode(l2.val);
                l2 = l2.next;
                current = current.next;
            }else if(l2 == null || (l1.val <= l2.val)){
                current.next = new ListNode(l1.val);
                l1 = l1.next;
                current = current.next;
            }
        }
        return beginning.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode beginning = new ListNode(-1);
        ListNode current = beginning;
        while((l1 != null) && (l2 != null)) {
            if(l1.val > l2.val){
                current.next = l2;
                l2 = l2.next;
            }else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        if(l1 == null){
            current.next = l2;
        } else {
            current.next = l1;
        }
        return beginning.next;
    }

    public static void main(String[] args){
        //System.out.println("start");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new Solution().mergeTwoLists(l1, l2);
        //System.out.println("start");
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        //System.out.println("end");
    }
}
