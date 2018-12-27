public class MyHashMap3 {
    class ListNode {
        int key, val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int idx(int key) {
        // return Integer.hashCode(key) % nodes.length;
        return key % nodes.length;
    }

    ListNode find(ListNode head, int key) {
        ListNode node = head, previous = null;
        while (node != null && node.key != key) {
            previous = node;
            node = node.next;
        }
        return previous;
    }

    private final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public MyHashMap3() {}

    // O(1)
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if(nodes[i] == null) {
            nodes[i] = new ListNode(-1, -1);
        }
        ListNode previous = find(nodes[i], key);
        if(previous.next == null) {
            previous.next = new ListNode(key, value);
        } else {
            previous.next.val = value;
        }
    }

    // O(1)
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        if(nodes[i] == null) return -1;
        ListNode previous = find(nodes[i], key);
        return previous.next == null ? -1 : previous.next.val;
    }

    // O(1)
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        if(nodes[i] == null) return;
        ListNode previous = find(nodes[i], key);
        if(previous.next != null) {
            previous.next = previous.next.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap3 hashMap = new MyHashMap3();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));          // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);
    }
}
