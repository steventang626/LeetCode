class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.right == null){
            return findBiggest(root.left) < root.val && isValidBST(root.left);
        }
        if(root.left == null){
            return findSmallest(root.right) > root.val && isValidBST(root.right);
        }
        return findBiggest(root.left) < root.val && isValidBST(root.left) && findSmallest(root.right) > root.val && isValidBST(root.right);
    }

    private int findBiggest(TreeNode root){
        if(root.right != null){
            return findBiggest(root.right);
        }else{
            return root.val;
        }
    }

    private int findSmallest(TreeNode root){
        if(root.left != null){
            return findSmallest(root.left);
        }else{
            return root.val;
        }
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;

        boolean result = new Solution().isValidBST(a1);
        System.out.println(result);
    }
}
