import java.util.*;

public class Solution {
    // Time O(nlogn), Space O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        assert k > 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        assert k <= map.size();
        ValueComparator vc = new ValueComparator();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(vc);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    private class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> map1, Map.Entry<Integer, Integer> map2) {
            return map2.getValue() - map1.getValue();
        }
    }

    // Time O(nlogk), Space O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int n: map.keySet()) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> result = new LinkedList<>();
        while(!heap.isEmpty()) {
            result.add(heap.poll());
        }
        return result;
    }

    // Time O(n), Space O(n)
    public List<Integer> topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<ArrayList<Integer>> frequencies = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            frequencies.add(new ArrayList<>());
        }
        for(int n: map.keySet()) {
            frequencies.get(map.get(n)).add(n);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length; i >= 0; i--) {
            ArrayList<Integer> recent = frequencies.get(i);
            int size = recent.size();
            for (int j = 0; j < size; j++) {
                result.add(recent.get(j));
                if(result.size() == k) {
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        List<Integer> list = new Solution().topKFrequent(nums, 2);
        for(int num: list) {
            System.out.println(num);
        }
    }
}
