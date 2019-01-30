class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode current = root.right;
                while (current.left != null) current = current.left;
                root.val = current.val;
                root.right = deleteNode(root.right, current.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(20);
        a1.left = a2;
        a1.right = a3;
        TreeNode result = new Solution().deleteNode(a1, 3);
        System.out.println(result.val);
    }
}
