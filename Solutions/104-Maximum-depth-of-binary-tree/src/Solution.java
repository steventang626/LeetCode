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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        // 递归终止条件
        if (root == null) {
            return 0;
        }

        // 递归过程
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
