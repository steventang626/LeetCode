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
    public List<Integer> inorderTraversal(TreeNode root) {
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

    public List<TreeNode> generateTreesFromK(int n, int k){
        List<TreeNode> results = new ArrayList<>();
        if(n < 1) {
            results.add(null);
            return results;
        }
        for(int i = 1; i <= n; i++){
            List<TreeNode> left_result = generateTreesFromK(i - 1, k);
            List<TreeNode> right_result = generateTreesFromK(n - i, i + k);
            for(TreeNode l : left_result){
                for(TreeNode r: right_result){
                    TreeNode root = new TreeNode(i + k);
                    root.left = l;
                    root.right = r;
                    results.add(root);
                }
            }
        }
        return results;
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateTreesFromK(n, 0);
    }

    public static void main(String[] args){
        List<TreeNode> results = new Solution().generateTrees(3);
        System.out.println(results.size());
        for(int i = 0; i < results.size(); i++){
            List<Integer> result = new Solution().inorderTraversal(results.get(i));
            System.out.println(result);
        }
    }
}
