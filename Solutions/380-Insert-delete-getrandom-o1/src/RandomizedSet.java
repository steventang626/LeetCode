import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int position = map.get(val);
            if (position != list.size() - 1) {
                int last = list.get(list.size() - 1);
                map.put(last, position);
                list.set(position, last);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int)(Math.random() * (list.size())));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        System.out.println(param_1);
        boolean param_2 = obj.remove(2);
        System.out.println(param_2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }
}
