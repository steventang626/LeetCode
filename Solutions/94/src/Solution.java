import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Command {
    String s; // go, print
    TreeNode node;
    Command(String str, TreeNode treeNode) {
        node = treeNode;
        s = str;
    }
}

public class Solution {
    // Recursion solution
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) return results;
        if(root.left != null){
            List<Integer> result_left = inorderTraversal(root.left);
            results.addAll(result_left);
        }
        results.add(root.val);
        if(root.right != null){
            List<Integer> result_right = inorderTraversal(root.right);
            results.addAll(result_right);
        }
        return results;
    }

    // Recursion solution2
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    // Non-recursion, non-stack solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        TreeNode current, previous;
        current = root;
        while (current != null) {
            if (current.left == null) {
                results.add(current.val);
                current = current.right;
            } else {
                previous = current.left;
                while (previous.right != null && previous.right != current) previous = previous.right;
                if (previous.right == null){
                    previous.right = current;
                    current = current.left;
                } else {
                    previous.right = null;
                    results.add(current.val);
                    current = current.right;
                }
            }
        }
        return results;
    }

    // Not recursion, use stack to simulate recursion
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while(!stack.empty()) {
            Command command = stack.pop();
            if (command.s.equals("print")) {
                result.add(command.node.val);
            } else {
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return result;
    }

    // Not recursion, use stack to simulate recursion
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode help = root;
        while(help != null || !stack.empty()) {
            while(help != null) {
                stack.push(help);
                help = help.left;
            }
            help = stack.pop();
            result.add(help.val);
            help = help.right;
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.right = a2;
        a2.left = a3;
        List<Integer> results = new Solution().inorderTraversal3(a1);
        System.out.println(results);
    }
}
