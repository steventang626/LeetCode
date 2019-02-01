import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        for(int first = 1; first <= 3; first++){
            for(int second = 1; second <= 3; second++){
                for(int third = 1; third <= 3; third++){
                    for(int fourth = 1; fourth <= 3; fourth++){
                        if(first + second + third + fourth == s.length()){
                            int a = Integer.valueOf(s.substring(0, first));
                            int b = Integer.valueOf(s.substring(first, first + second));
                            int c = Integer.valueOf(s.substring(first + second, first + second + third));
                            int d = Integer.valueOf(s.substring(first + second + third, s.length()));
                            if( a < 256 && b < 256 && c < 256 && d < 256){
                                String result = String.valueOf(a) + "." + String.valueOf(b) + "." +
                                        String.valueOf(c) + "." + String.valueOf(d);
                                if(result.length() == s.length() + 3){
                                    results.add(result);
                                }
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    List<String> resultIPAddresses;
    public List<String> restoreIpAddresses2(String s) {
        resultIPAddresses = new ArrayList<>();
        if (s.length() > 0) {
            restoreIpAddressesHelper(s, new ArrayList<>());
        }
        return resultIPAddresses;
    }

    void restoreIpAddressesHelper(String s, List<Integer> places) {
        int num = places.size();
        int beginPlace = 0;
        if (num == 3) {
            int last = places.get(2);
            if (s.length() - last - 1 <= 3) {
                int lastValue = Integer.valueOf(s.substring(last + 1));
                if (lastValue < 256) {
                    String result = Integer.valueOf(s.substring(0, places.get(0) + 1)) + "." +
                            Integer.valueOf(s.substring(places.get(0) + 1, places.get(1) + 1)) + "." +
                            Integer.valueOf(s.substring(places.get(1) + 1, last + 1)) + "." +
                            lastValue;
                    if(result.length() == s.length() + 3){
                        resultIPAddresses.add(result);
                        return;
                    }
                }
            }
        } else {
            if (num == 0) {
                beginPlace = -1;
            } else {
                beginPlace = places.get(num - 1);
            }
            for(int i = 1; i <= 3; i++) {
                int place = beginPlace + i;
                if (place < s.length() - 1 && Integer.valueOf(s.substring(beginPlace + 1, place + 1)) < 256) {
                    List<Integer> newPlaces = new ArrayList<>(places);
                    newPlaces.add(place);
                    restoreIpAddressesHelper(s, newPlaces);
                }
            }
        }
    }

    public List<String> restoreIpAddresses3(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() > 0) {
            restoreIpAddressesHelper2(s, 0, "", results);
        }
        return results;
    }

    void restoreIpAddressesHelper2(String s, int n, String out, List<String> results) {
        if (n == 4) {
            if(s.isEmpty()) {
                results.add(out);
            }
            return;
        }
        for(int i = 1; i <= 3; i++) {
            if (s.length() < i) {
                break;
            }
            int value = Integer.parseInt(s.substring(0, i));
            if (value > 255 || String.valueOf(value).length() != i) {
                continue;
            }
            restoreIpAddressesHelper2(s.substring(i), n + 1, out + s.substring(0, i) + (n == 3 ? "" : "."), results);
        }
    }

    public static void main(String[] args){
        String s = "010010";
        List<String> results = new Solution().restoreIpAddresses3(s);
        System.out.println(results);
    }
}
