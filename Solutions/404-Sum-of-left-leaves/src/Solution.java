import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int result = 0;
        while(!stack.isEmpty()) {
            TreeNode recent = stack.pop();
            if(recent.left != null && recent.left.left == null && recent.left.right == null) result += recent.left.val;
            if(recent.left != null) stack.push(recent.left);
            if(recent.right != null) stack.push(recent.right);
        }
        return result;
    }

    public int sumOfLeftLeaves3(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while(!queue.isEmpty()) {
            TreeNode recent = queue.poll();
            if(recent.left != null && recent.left.left == null && recent.left.right == null) result += recent.left.val;
            if(recent.left != null) queue.add(recent.left);
            if(recent.right != null) queue.add(recent.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        System.out.println(new Solution().sumOfLeftLeaves3(root));
    }
}
