public class Solution {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int lengthL1 = listLength(l1);
        int lengthL2 = listLength(l2);
        ListNode longList = lengthL1 > lengthL2 ? l1 : l2;
        ListNode shortList = lengthL1 > lengthL2 ? l2 : l1;

        int difference = Math.abs(lengthL1 - lengthL2);
        if (difference > 0) {
            ListNode zeros = new ListNode(0);
            ListNode zeroHead = zeros;
            for (int i = 0;i < difference; i++) {
                ListNode zero = new ListNode(0);
                zeros.next = zero;
                zeros = zero;
            }
            zeros.next = shortList;
            shortList = zeroHead;
        } else {
            ListNode zero = new ListNode(0);
            zero.next = shortList;
            shortList = zero;
        }
        ListNode zero = new ListNode(0);
        zero.next = longList;
        longList = zero;

        ListNode result = new ListNode(-1);
        ListNode leftUp = result;
        ListNode resultHead = result;
        while (longList != null) {
            int val = longList.val + shortList.val;
            if (val > 9) {
                val = val % 10;
                leftUp.val++;
                while (leftUp.next != null) {
                    leftUp = leftUp.next;
                    leftUp.val = 0;
                }
            }
            result.next = new ListNode(val);
            if (val < 9) {
                leftUp = result.next;
            }
            longList = longList.next;
            shortList = shortList.next;
            result = result.next;
        }
        if (resultHead.next.val == 0) {
            return resultHead.next.next;
        } else {
            return resultHead.next;
        }
    }

    int listLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    // Modify the input lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1_new = reverseList(l1);
        ListNode l2_new = reverseList(l2);
        return reverseList(addTwoNumbersI(l1_new, l2_new));
    }

    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
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
            current = current.next;
        }
        if(nextDigit == 1){
            current.next = new ListNode(1);
        }
        return beginning.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args){
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);

        ListNode head3 = new Solution().addTwoNumbers2(head1, head2);
        System.out.println(head3);
    }
}
