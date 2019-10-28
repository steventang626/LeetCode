import java.util.HashMap;
import java.util.Map;

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
}

public class LRUCache2 {
    private Map<Integer, DLinkedNode> cache;
    private int capacity, size;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache2(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        remove(node);
        addLast(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            size--;
        }
        DLinkedNode node = new DLinkedNode();
        node.key = key;
        node.value = value;
        addLast(node);
        cache.put(key, node);
        size++;
        if (size > capacity) {
            DLinkedNode first = head.next;
            remove(first);
            cache.remove(first.key);
        }
    }

    private void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addLast(DLinkedNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }
}
