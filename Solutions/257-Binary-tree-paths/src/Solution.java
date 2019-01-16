import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if(root == null) return result;

        int value = root.val;
        if(root.left == null && root.right == null){
            result.add(String.valueOf(value));
            return result;
        }

        List<String> leftStrings = binaryTreePaths(root.left);
        StringBuilder sb = new StringBuilder();
        for(String str: leftStrings) {
            sb.append(value);
            sb.append("->");
            sb.append(str);
            result.add(sb.toString());
            sb.setLength(0);
        }

        List<String> rightStrings = binaryTreePaths(root.right);
        for(String str: rightStrings) {
            result.add(value + "->" + str);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        List<String> result = new Solution().binaryTreePaths(root);
        for(String str: result) {
            System.out.println(str);
        }
    }
}
