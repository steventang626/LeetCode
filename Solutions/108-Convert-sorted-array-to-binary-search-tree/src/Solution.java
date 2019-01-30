class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) {
            TreeNode root = new TreeNode(nums[0]);
            return root;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid - 1];
        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid + 1, right, 0, nums.length - mid - 1);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper (int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, begin, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        TreeNode result = new Solution().sortedArrayToBST(nums);
        System.out.println(result.val);
    }
}
