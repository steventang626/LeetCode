import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    // Actually even if we do not add these two functions, it could work.
    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ListNode other = (ListNode) obj;
        if (val != other.val) {
            return false;
        }
        if (next != other.next) {
            return false;
        }
        return true;
    }
}

class Solution {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (pointerA != null) {
            lengthA++;
            pointerA = pointerA.next;
        }
        while (pointerB != null) {
            lengthB++;
            pointerB = pointerB.next;
        }
        int difference = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            for (int i = 0; i < difference; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < difference; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB && headA != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        return pointerA;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        while (headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (setA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = headA.next;
        ListNode result = new Solution().getIntersectionNode3(headA, headB);
        System.out.println(result.val);
    }
}