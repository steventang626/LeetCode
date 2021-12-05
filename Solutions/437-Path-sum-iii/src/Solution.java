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
        System.out.println(new Solution().pathSum(root, 1));
    }

    // The number of paths that sum to a given number
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = pathSumWithRoot(root, sum);
        result += pathSum(root.left, sum);
        result += pathSum(root.right, sum);
        return result;
    }

    // The number of paths that sum to a given number and the paths must include the root
    public int pathSumWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == sum) {
            result++;
        }
        result += pathSumWithRoot(root.left, sum - root.val);
        result += pathSumWithRoot(root.right, sum - root.val);
        return result;
    }
}
