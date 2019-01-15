class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return findMinDepth(root);
    }

    public int findMinDepth(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) return 1;
        return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
    }

    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth2(root.right) + 1;
        if(root.right == null) return minDepth2(root.left) + 1;
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        System.out.println(new Solution().minDepth2(root));
    }
}
