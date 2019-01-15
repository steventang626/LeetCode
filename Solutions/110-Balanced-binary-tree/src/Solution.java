class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // O(nlogn)
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = calculateDepth(root.left);
        int right = calculateDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int calculateDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
    }

    // O(n)
    boolean result = true;
    public boolean isBalanced2(TreeNode root) {
        calculateDepth2(root);
        return result;
    }

    public int calculateDepth2(TreeNode root) {
        if(!result) return -1;
        if(root == null) return 0;
        int left = calculateDepth2(root.left);
        int right = calculateDepth2(root.right);
        if(Math.abs(left - right) > 1) {
            result = false;
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    // O(n)
    public boolean isBalanced3(TreeNode root) {
        if(root == null) return true;
        return checkDepth(root) != -1;
    }

    public int checkDepth(TreeNode root) {
        if(root == null) return 0;
        int left = checkDepth(root.left);
        if(left == -1) return -1;
        int right = checkDepth(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        a1.left = a2;
        a1.right = a3;
        a2.left = new TreeNode(15);
        a2.right = new TreeNode(7);
        boolean results = new Solution().isBalanced2(a1);
        System.out.println(results);
    }
}
