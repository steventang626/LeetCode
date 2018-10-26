import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    // Use stack
    public String simplifyPath2(String path) {
        String[] pathNames = path.split("/");
        Stack<String> pathStack = new Stack<>();
        for(int i = 0; i < pathNames.length; i++) {
            if(pathNames[i].equals("") || pathNames[i].equals(".")) continue;
            if(pathNames[i].equals("..")){
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else {
                pathStack.push(pathNames[i]);
            }
        }
        if (pathStack.empty()) return "/";
        List<String> list = new ArrayList<>(pathStack);
        return "/" + String.join("/", list);
    }

    public String simplifyPath(String path) {
        path = path + "/";
        int i = 1;
        while(i < path.length()){
            if(path.charAt(i) == '/' && path.charAt(i - 1) == '/'){
                path = path.substring(0,i) + path.substring(i+1,path.length());
            }else{
                i++;
            }
        }
        //System.out.println(path);
        i = 1;
        while(i < path.length()){
            if(path.charAt(i) == '.' && path.charAt(i - 1) == '/' && path.charAt(i + 1) == '/'){
                path = path.substring(0,i) + path.substring(i+2,path.length());
            }else{
                i++;
            }
        }
        //System.out.println(path);
        i = 1;
        while(i+2 < path.length()) {
            if (path.charAt(i) == '.' && path.charAt(i - 1) == '/' && path.charAt(i + 1) == '.' && path.charAt(i + 2) == '/') {
                if (i == 1) {
                    path = '/' + path.substring(i + 3, path.length());
                } else {
                    int j = i - 2;
                    while (j >= 0) {
                        if (path.charAt(j) != '/') j--;
                        else {
                            break;
                        }
                    }
                    path = path.substring(0, j + 1) + path.substring(i + 3, path.length());
                    i = j + 1;
                }
            } else {
                i++;
            }
        }
        if(path.length() == 1){
            return path;
        }else{
            return path.substring(0,path.length() - 1);
        }
    }
    public static void main(String[] args){
        String result = new Solution().simplifyPath2("/a//b////c/d//././/..");
        System.out.println(result);
    }
}
