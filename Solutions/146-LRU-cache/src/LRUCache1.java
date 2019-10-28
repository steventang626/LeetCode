import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1 extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache1(int capacity) {
        super(capacity, 1.0f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}