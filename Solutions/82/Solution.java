class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode start = head;
        ListNode end = head.next;
        if(end == null) return head;
        ListNode result = new ListNode(-1);
        ListNode result_list = result;

        while(end != null){
            if(end.val != start.val){
                if(start.next == end){
                    result_list.next = new ListNode(start.val);
                    result_list = result_list.next;
                    start = end;
                    end = end.next;
                }else{
                    start = end;
                    end = end.next;
                }
            }else{
                end = end.next;
            }
        }
        if(start.val != result_list.val && start.next == null){
            result_list.next = new ListNode(start.val);
        }
        return result.next;
    }
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(3);
        a.next.next.next.next.next = new ListNode(4);
        ListNode r = new Solution().deleteDuplicates(a);
        while(r != null){
            System.out.print(r.val+" ");
            r = r.next;
        }
    }
}
