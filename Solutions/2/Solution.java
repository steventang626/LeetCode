class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode beginning = new ListNode(-1);
        ListNode current = beginning;
        int nextDigit = 0;
        while((l1 != null) || (l2 != null)) {
            int n1 = l1 == null ? 0: l1.val;
            int n2 = l2 == null ? 0: l2.val;
            int sum = n1 + n2 + nextDigit;
            if(sum > 9) {
                nextDigit = 1;
                current.next = new ListNode(sum - 10);
            }else {
                nextDigit = 0;
                current.next = new ListNode(sum);
            }
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            // another way to write
            // if(l1 != null) l1 = l1.next;
            // if(l2 != null) l2 = l2.next;
            current = current.next;
        }
        if(nextDigit == 1){
            current.next = new ListNode(1);
        }
        return beginning.next;
    }

    public static void main(String[] args){
        //System.out.println("start");
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1, l2);
        //System.out.println("start");
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        //System.out.println("end");
    }
}





