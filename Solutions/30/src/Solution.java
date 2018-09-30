import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring1(String s, String[] words) {
        // 超时
        List<Integer> result = new ArrayList<>();
        int num = words.length;
        int word_length = words[0].length();
        int string_length = s.length();
        int l = num * word_length;
        for(int i = 0; i <= string_length - l;i++){
            int[] word_usage = new int[num];
            boolean isResult = true;
            for(int j = 0;j<num; j++){
                String word = s.substring(i + j*word_length, i + j*word_length + word_length);
                int k;
                for(k = 0; k<num; k++){
                    if(word.equals(words[k])){
                        if(word_usage[k] == 0){
                            word_usage[k] = 1;
                            break;
                        }
                    }
                }
                if(k == num) {
                    isResult = false;
                    break;
                }
                if(!isResult) break;
            }
            if(!isResult) continue;
            boolean is_result = true;
            for(int j = 0;j<num; j++){
                if(word_usage[j] != 1){
                    is_result = false;
                    break;
                }
            }
            if(is_result) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        // 和上面的思路一样，只是换用了哈希表
        List<Integer> result = new ArrayList<>();
        int num = words.length;
        int word_length = words[0].length();
        int string_length = s.length();
        int l = num * word_length;

        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i = 0;i < num; i++){
            if(map1.containsKey(words[i])){
                map1.put(words[i],map1.get(words[i])+1);
            }else{
                map1.put(words[i],1);
            }
        }
        for(int i = 0; i <= string_length - l;i++){
            HashMap<String, Integer> map2 = new HashMap<>();
            int j;
            for(j = 0;j<num; j++){
                String word = s.substring(i + j*word_length, i + j*word_length + word_length);
                if(map1.containsKey(word)){
                    if(map2.containsKey(word)){
                        if(map2.get(word)+1 > map1.get(word)) break;
                        map2.put(word,map2.get(word)+1);
                    }else{
                        map2.put(word,1);
                    }
                }else{
                    break;
                }
            }
            if(j == num){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] a = {"word","good","best","good"};
        List<Integer> result = new Solution().findSubstring("wordgoodgoodgoodbestword",a);
        System.out.println(result);
    }
}
