import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    private List<Pair<Integer, Integer>> hashMap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new ArrayList<>();
    }

    // O(n)
    /** value will always be non-negative. */
    public void put(int key, int value) {
        for(Pair<Integer, Integer> pair: hashMap) {
            if(key == pair.getKey()) {
                hashMap.remove(pair);
                break;
            }
        }
        hashMap.add(new Pair<>(key, value));
    }

    // O(n)
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(Pair<Integer, Integer> pair: hashMap) {
            if(key == pair.getKey()) {
                return pair.getValue();
            }
        }
        return -1;
    }

    // O(n)
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(Pair<Integer, Integer> pair: hashMap) {
            if(key == pair.getKey()) {
                hashMap.remove(pair);
                break;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
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
