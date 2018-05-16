import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] blank_space = new int[words.length];
        int recent_length = 0;
        int recent_start = 0;
        int recent_end = 0;
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            if(recent_length + words[i].length() <= maxWidth){
                recent_length = recent_length + words[i].length() + 1;
                recent_end = i;
                i++;
            }else{
                int words_num = recent_end - recent_start + 1;
                if(words_num == 1){
                    blank_space[recent_end] = maxWidth - words[recent_end].length();
                    String recent = words[recent_end];
                    for(int j = 0; j < blank_space[recent_end]; j++){
                        recent+=" ";
                    }
                    result.add(recent);
                }else{
                    int words_length = 0;
                    for(int j = recent_start; j <= recent_end; j++){
                        words_length += words[j].length();
                    }
                    int blank = (maxWidth - words_length) / (words_num - 1);
                    int more_blank = maxWidth - words_length - blank * (words_num - 1);
                    for(int j = recent_start; j <= recent_end - 1; j++) {
                        if(j < recent_start + more_blank){
                            blank_space[j] = blank + 1;
                        }else{
                            blank_space[j] = blank;
                        }
                    }
                    String recent = "";
                    for(int j = recent_start; j <= recent_end; j++){
                        recent += words[j];
                        for(int k = 0; k < blank_space[j]; k++){
                            recent+=" ";
                        }
                    }
                    result.add(recent);
                }
                recent_length = 0;
                recent_start = i;
            }
        }
        int words_num = recent_end - recent_start + 1;
        if(words_num == 1){
            blank_space[recent_end] = maxWidth - words[recent_end].length();
            String recent = words[recent_end];
            for(int j = 0; j < blank_space[recent_end]; j++){
                recent+=" ";
            }
            result.add(recent);
        }else{
            String recent = "";
            for(int j = recent_start; j <= recent_end - 1; j++){
                recent += words[j];
                recent +=" ";
            }
            recent += words[recent_end];
            int blank = maxWidth - recent.length();
            for(int j = 0; j < blank; j++){
                recent+=" ";
            }
            result.add(recent);
        }
//        System.out.println("rs"+recent_start);
//        System.out.println("re"+recent_end);
        return result;
    }
    public static void main(String[] args){
        int max = 20;
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        List<String> result = new Solution().fullJustify(words, max);
        for(String i: result){
            System.out.println(i);
        }
    }
}
