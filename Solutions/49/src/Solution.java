import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length == 0) return null;
        List<List<String>> result = new ArrayList<>();
        List<String> first = new ArrayList<>();
        first.add(strs[0]);
        result.add(first);
        for(int i = 1; i < strs.length; i++){
            boolean hasAnagram = false;
            for(int j = 0; j < result.size(); j++){
                List<String> recent = result.get(j);
                String recent_str = recent.get(0);
                if(isAnagram(recent_str, strs[i])){
                    recent.add(strs[i]);
                    hasAnagram = true;
                    break;
                }
            }
            if(!hasAnagram){
                List<String> new_list = new ArrayList<>();
                new_list.add(strs[i]);
                result.add(new_list);
            }
        }
        return result;
    }

    public boolean isAnagram2(String a, String b){
        // 超时
        if(a.length() != b.length()) return false;
        for(int i = 0; i < b.length(); i++){
            int index = a.indexOf(b.charAt(i));
            if(index == -1) return false;
            else{
                StringBuilder sb = new StringBuilder(a);
                sb.replace(index,index+1,"");
                a = sb.toString();
            }
        }
        return true;
    }

    public boolean isAnagram(String a, String b){
        // 能过
        if(a.length() != b.length()) return false;
        int[] charlist = new int[26];
        for(int i = 0; i < a.length(); i++){
            charlist[a.charAt(i)-'a']++;
        }
        for(int i = 0; i < b.length(); i++){
            charlist[b.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(charlist[i] != 0) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        // 不用排序，按字母统计
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] charlist = new int[26];
            String key = "";
            for(int j = 0; j < strs[i].length(); j++){
                charlist[strs[i].charAt(j)-'a']++;
            }
            for(int j = 0; j < 26; j++){
                key += String.valueOf(charlist[j]) + "/";
            }
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // 每个字符串字母排序
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] sa = s.toCharArray();
            Arrays.sort(sa);
            String t = new String(sa);
            if(!map.containsKey(t)){
                map.put(t,new ArrayList<String>());
            }
            map.get(t).add(s);
        }
        return new ArrayList<List<String>>(map.values());

    }

    public static void main(String[] args){
        String[] a = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new Solution().groupAnagrams(a);
        for(int i = 0;i<result.size(); i++){
            List<String> recent = result.get(i);
            for(int j = 0; j < recent.size(); j++){
                System.out.print(recent.get(j)+" ");
            }
            System.out.println();
        }
    }
}
