import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> watchResult;
    public List<String> readBinaryWatch(int num) {
        watchResult = new ArrayList<>();
        if (num < 0 || num >= 9) {
            return watchResult;
        }
        generateWatchResult(1, num, new ArrayList<>());
        return watchResult;
    }

    private void generateWatchResult(int start, int num, List<Integer> recentResult) {
        if (num == 0) {
            int hour = 0;
            int minute = 0;
            for (int i: recentResult) {
                if (i <= 4) {
                    hour += (1 << (i - 1));
                } else {
                    minute += (1 << (i - 5));
                }
            }
            if (hour <= 11 && minute <= 59) {
                watchResult.add(hour + ":" + String.format("%02d", minute));
            }
            return;
        }
        for (int i = start; i <= 10; i++) {
            recentResult.add(i);
            generateWatchResult(i + 1, num - 1, recentResult);
            recentResult.remove(recentResult.size() - 1);
        }
    }

    public static void main(String[] args){
        List<String> result = new Solution().readBinaryWatch(2);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
