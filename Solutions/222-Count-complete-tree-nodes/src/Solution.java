import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int countNodes(TreeNode root) {
        int result = 0;
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode recent = queue.poll();
            result++;
            if (recent.left != null) {
                queue.add(recent.left);
            }
            if (recent.right != null) {
                queue.add(recent.right);
            }
        }
        return result;
    }

    // Slow
    public int countNodes2(TreeNode root) {
        int result = 0, step = 0;
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                TreeNode recent = queue.poll();
                if (recent.left != null) {
                    queue.add(recent.left);
                }
                if (recent.right != null) {
                    queue.add(recent.right);
                }
            }
            step++;
        }
        int secondStep = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                TreeNode recent = queue.poll();
                if(secondStep == step - 1) result++;
                if (recent.left != null) {
                    queue.add(recent.left);
                }
                if (recent.right != null) {
                    queue.add(recent.right);
                }
            }
            secondStep++;
        }
        result += (int) Math.pow(2, step - 1) - 1;
        return result;
    }

    // Fast
    public int countNodes3(TreeNode root) {
        int leftStep = 1, rightStep = 1;
        TreeNode leftNode = root, rightNode = root;
        if (root == null) return 0;
        while(leftNode.left != null) {
            leftNode = leftNode.left;
            leftStep++;
        }
        while(rightNode.right != null) {
            rightNode = rightNode.right;
            rightStep++;
        }
        if(leftStep == rightStep) return (int) Math.pow(2, leftStep) - 1;
        return countNodes3(root.left) + countNodes3(root.right) + 1;
    }

    public int countNodes4(TreeNode root) {
        if(root == null) return 0;
        return countNodes4(root.left) + countNodes3(root.right) + 1;
    }


    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        a1.left = a2;
        a1.right = a3;
        a2.left = new TreeNode(15);
        a2.right = new TreeNode(7);
        int results = new Solution().countNodes4(a1);
        System.out.println(results);
    }
}
