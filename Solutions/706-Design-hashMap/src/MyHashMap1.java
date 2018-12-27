import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap1 {
    private int[] hashMap;

    /** Initialize your data structure here. */
    public MyHashMap1() {
        hashMap = new int[1000001];
        for(int i = 0; i < 1000001; i++) {
            hashMap[i] = -1;
        }
    }

    // O(1)
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashMap[key] = value;
    }

    // O(1)
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashMap[key];
    }

    // O(1)
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMap[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap1 hashMap = new MyHashMap1();
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
