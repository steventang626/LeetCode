import java.util.PriorityQueue;

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

    // 使用 Priority Queue, 理论上时间复杂度相同，但OJ上这个解法慢
    public ListNode mergeKLists2(ListNode[] lists) {
        int size = lists.length;
        if (size == 0) return null;
        if (size == 1) return lists[0];
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for(int i = 0; i < size; i++) {
            if(lists[i] != null) priorityQueue.add(lists[i]);
        }
        ListNode head = null, recent = null, pre = null;
        while(!priorityQueue.isEmpty()) {
            recent = priorityQueue.poll();
            if(pre == null) head = recent;
            else {
                pre.next = recent;
            }
            pre = recent;
            if(recent.next != null) {
                priorityQueue.add(recent.next);
            }
        }
        return head;
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
        ListNode l4 = new Solution().mergeKLists2(l);
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }
}
