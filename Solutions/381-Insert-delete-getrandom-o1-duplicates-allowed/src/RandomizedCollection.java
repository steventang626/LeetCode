import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isNew = false;
        list.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            isNew = true;
        }
        map.get(val).add(list.size() - 1);
        return isNew;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Set<Integer> set = map.get(val);
            int position = set.iterator().next();
            if (list.get(list.size() - 1) != val) {
                int last = list.get(list.size() - 1);
                list.set(position, last);
                map.get(last).remove(list.size() - 1);
                map.get(last).add(position);
            }
            set.remove(position);
            if (set.isEmpty()) {
                map.remove(val);
            }
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int)(Math.random() * (list.size())));
    }

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        obj.insert(0);
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(3);
        obj.remove(2);
        obj.remove(3);
        obj.remove(0);
        obj.getRandom();
    }
}
