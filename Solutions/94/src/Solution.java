import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // Recursion solution
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) return results;
        if(root.left != null){
            List<Integer> result_left = inorderTraversal(root.left);
            results.addAll(result_left);
        }
        results.add(root.val);
        if(root.right != null){
            List<Integer> result_right = inorderTraversal(root.right);
            results.addAll(result_right);
        }
        return results;
    }

    // Non-recursion, non-stack solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        TreeNode current, previous;
        current = root;
        while (current != null) {
            if (current.left == null) {
                results.add(current.val);
                current = current.right;
            } else {
                previous = current.left;
                while (previous.right != null && previous.right != current) previous = previous.right;
                if (previous.right == null){
                    previous.right = current;
                    current = current.left;
                } else {
                    previous.right = null;
                    results.add(current.val);
                    current = current.right;
                }
            }
        }
        return results;
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.right = a2;
        a2.left = a3;
        List<Integer> results = new Solution().inorderTraversal(a1);
        System.out.println(results);
    }
}