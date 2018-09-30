import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    class Node{
        int val;
        Node next;
        Node(int x){val = x;}
    }

    public int trap(int[] height) {
        int length = height.length;
        if(length <= 2) return 0;
        int[] height1 = new int[length+2];
        for(int i = 0; i<length;i++){
            height1[i+1] = height[i];
        }

        int[] mountain = new int[length+2];
        for(int i = 1; i<=length;i++){
            if(height1[i] >= height1[i-1] && height1[i] > height1[i+1]){
                mountain[i] = height1[i];
            }
        }
        for(int i = 1; i<=length;i++){
            if(mountain[i] > 0){
                boolean left = false;
                boolean right = false;
                for(int j = i-1;j>=1;j--){
                    if(mountain[j] > mountain[i]){
                        left = true;
                    }
                }
                for(int j = i+1;j<=length;j++){
                    if(mountain[j] > mountain[i]){
                        right = true;
                    }
                }
                if(left && right){
                    mountain[i] = 0;
                }
            }
        }

        Node listNode = new Node(0);
        Node begin = listNode;
        for(int i = 1; i<=length;i++){
            if(mountain[i] > 0){
                listNode.next = new Node(i);
                listNode = listNode.next;
            }
        }

        int result = 0;
        int start, end = 0;
        while(begin.next != null && begin.next.next !=null){
            start = begin.next.val;
            end = begin.next.next.val;
            int l = end - start -1;
            int h = Math.min(height1[start], height1[end]);
            int m = l * h;
            for(int i = start+1; i<=end-1;i++){
                m = m - Math.min(height1[i],h);
            }
            result = result + m;
            begin = begin.next;
        }
        return result;
    }

    public int trap2(int[] height) {
        // 换了一个数据结构，用动态数组代替链表
        int length = height.length;
        if(length <= 2) return 0;
        int[] height1 = new int[length+2];
        for(int i = 0; i<length;i++){
            height1[i+1] = height[i];
        }

        ArrayList<Integer> mountain = new ArrayList<>();
        for(int i = 1; i<=length;i++){
            if(height1[i] >= height1[i-1] && height1[i] > height1[i+1]){
                mountain.add(i);
            }
        }

        int r = 1;
        while(r<mountain.size()){
            boolean left = false;
            boolean right = false;
            int now = height1[mountain.get(r)];
            for(int j = r-1;j>=0;j--){
                if(height1[mountain.get(j)] > now){
                    left = true;
                }
            }
            for(int j = r+1;j<mountain.size();j++){
                if(height1[mountain.get(j)] > now){
                    right = true;
                }
            }
            if(left && right){
                mountain.remove(r);
            }else{
                r++;
            }
        }

        int result = 0;
        int start, end = 0;
        for(int i = 0; i< mountain.size()-1;i++){
            start = mountain.get(i);
            end = mountain.get(i+1);
            int l = end - start -1;
            int h = Math.min(height1[start], height1[end]);
            int m = l * h;
            for(int j = start+1; j<=end-1;j++){
                m = m - Math.min(height1[j],h);
            }
            result = result + m;
        }
        return result;
    }

    public static void main(String[] args){
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = new Solution().trap2(a);
        System.out.print(result);
    }
}
