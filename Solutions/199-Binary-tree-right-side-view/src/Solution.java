import javafx.util.Pair;

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
    // Using queue
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(root, 0));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> recent = queue.removeFirst();
            TreeNode node = recent.getKey();
            int level = recent.getValue();

            if(result.size() == level) {
                result.add(node.val);
            }
            if (node.right != null) {
                queue.addLast(new Pair<>(node.right, level + 1));
            }
            if (node.left != null) {
                queue.addLast(new Pair<>(node.left, level + 1));
            }
        }
        return result;
    }

    // Using dfs
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (result.size() == level) {
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        a1.left = a2;
        a1.right = a3;
        a3.left = new TreeNode(15);
        a3.right = new TreeNode(7);
        List<Integer> results = new Solution().rightSideView2(a1);
        System.out.println(results);
    }
}
