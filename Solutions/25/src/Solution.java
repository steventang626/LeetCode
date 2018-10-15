public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int num = 0;
        ListNode temp = dummy;
        while(temp.next != null) {
            num++;
            temp = temp.next;
        }
        ListNode pre = dummy;
        ListNode cur = head;
        while(num >= k) {
            for(int i = 1; i < k; i++){
                ListNode t = cur.next;
                cur.next = t.next;
                t.next = pre.next;
                pre.next = t;
            }
            pre = cur;
            cur = cur.next;
            num = num - k;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
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
                    System.out.println(ls2.val);
                    return head;
                }else {
                    ls4 = ls4.next;
                    System.out.println("here"+ls4.val);
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

        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);

        ListNode result = new Solution().reverseKGroup(head,3);
        System.out.println(result);
    }
}
