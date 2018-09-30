class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) return null;
        if (size == 1) return lists[0];
        if (size == 2) return mergeTwoLists(lists[0], lists[1]);
        else {
            int size1 = size / 2;
            int size2 = size - size1;
            ListNode[] lists1 = new ListNode[size1];
            ListNode[] lists2 = new ListNode[size2];
            System.arraycopy(lists,0,lists1,0,size1);
            System.arraycopy(lists,size1,lists2,0,size2);
            return mergeTwoLists(mergeKLists(lists1), mergeKLists(lists2));
        }
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
        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(11);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(10);

        ListNode[] l = new ListNode[4];
        l[0] = null;
        l[1] = l1;
        l[2] = null;
        l[3] = l3;
        ListNode l4 = new Solution().mergeKLists(l);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}
