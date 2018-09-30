public class Solution {
    // Do not create new linked list
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode start = dummyHead;
        ListNode end = head.next;
        while(end != null){
            if(end.val != start.next.val){
                if(start.next.next == end){
                    start = start.next;
                    end = end.next;
                }else{
                    start.next = end;
                    end = end.next;
                }
            }else{
                end = end.next;
            }
        }
        if (start.next.next != null && start.next.val == start.next.next.val) {
            start.next = null;
        }
        return dummyHead.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
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
        int[] nums = {2, 2};
        ListNode head = new ListNode(nums);
        ListNode result = new Solution().deleteDuplicates(head);
        System.out.println(result);
    }
}
