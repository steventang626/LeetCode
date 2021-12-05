import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        System.out.println(new Solution().invertTree(root));
    }

    public TreeNode invertTree2(TreeNode root) {
        // 递归终止条件
        if (root == null) {
            return null;
        }

        // 递归下一步
        invertTree(root.left);
        invertTree(root.right);

        // 递归处理
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode recent = queue.poll();
            TreeNode temp = recent.left;
            recent.left = recent.right;
            recent.right = temp;
            if (recent.left != null) {
                queue.add(recent.left);
            }
            if (recent.right != null) {
                queue.add(recent.right);
            }
        }
        return root;
    }
}
