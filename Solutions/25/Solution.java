class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ls = head;
        for(int i = 0; i<k; i++){
            if(ls == null) return head;
            ls = ls.next;
        }
        ls = head;
        for(int i = 0; i<k-1; i++){
            head = head.next;
        }
        ListNode ls1 = head;
        while(ls1.next != null){
            ListNode ls2 = ls1.next;
            for(int i = k-1; i>0; i--){
                ListNode ls3 = ls;
                for(int j = 1;j<i;j++){
                    ls3 = ls3.next;
                }
                ls1.next = ls3;
                ls1 = ls1.next;
            }
            ListNode ls4 = ls2;
            for(int i = 0; i<k-1; i++){
                if(ls4.next == null) {
                    ls.next = ls2;
                    return head;
                }else {
                    ls4 = ls4.next;
                }
            }
            ls1 = ls4;
            ls.next = ls4;
            ls = ls2;
        }
        for(int i = k-1; i>0; i--){
            ListNode ls3 = ls;
            for(int j = 1;j<i;j++){
                ls3 = ls3.next;
            }
            ls1.next = ls3;
            ls1 = ls1.next;
        }
        ls.next = null;
        return head;
    }

    public static void main(String[] args) {
        //System.out.println("start");
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode l4 = new Solution().reverseKGroup(l1,3);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}
