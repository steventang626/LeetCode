import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right));
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.right = a2;
        a2.left = a3;

        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(3);
        a4.right = a5;
        a5.left = a6;
        boolean results = new Solution().isSameTree(a1, a4);
        System.out.println(results);
    }
}
