class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        System.out.println(new Solution().hasPathSum(root, 1));
    }
}
