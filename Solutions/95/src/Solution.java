import java.util.ArrayList;
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
        //System.out.println(results.size());
        if(n < 1) return results;
        if(n == 1){
            results.add(new TreeNode(1 + k));
            return results;
        }
        for(int i = 1; i <= n; i++){
            List<TreeNode> left_result = generateTreesFromK(i - 1, k);
            List<TreeNode> right_result = generateTreesFromK(n - i, i + k);
            if(left_result.size() == 0){
                for(int j = 0; j < right_result.size(); j++){
                    TreeNode root = new TreeNode(i + k);
                    root.right = right_result.get(j);
                    results.add(root);
                }
                continue;
            }
            if(right_result.size() == 0){
                for(int j = 0; j < left_result.size(); j++){
                    TreeNode root = new TreeNode(i + k);
                    root.left = left_result.get(j);
                    results.add(root);
                }
                continue;
            }
            for(int j = 0; j < left_result.size(); j++){
                for(int l = 0; l < right_result.size(); l++){
                    TreeNode root = new TreeNode(i + k);
                    if(left_result.size() != 0){
                        root.left = left_result.get(j);
                    }
                    if(right_result.size() != 0){
                        root.right = right_result.get(l);
                    }
                    results.add(root);
                }
            }
        }
        return results;
    }

    public List<TreeNode> generateTrees(int n) {
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
