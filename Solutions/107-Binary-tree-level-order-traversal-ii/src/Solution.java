import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(root, 0));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> recent = queue.removeFirst();
            TreeNode node = recent.getKey();
            int level = recent.getValue();

            if(result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            if (node.left != null) {
                queue.addLast(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.addLast(new Pair<>(node.right, level + 1));
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        a1.left = a2;
        a1.right = a3;
        a3.left = new TreeNode(15);
        a3.right = new TreeNode(7);
        List<List<Integer>> results = new Solution().levelOrderBottom(a1);
        System.out.println(results);
    }
}
