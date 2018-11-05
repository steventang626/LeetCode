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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    // Not recursion, use stack to simulate recursion
    public List<Integer> preorderTraversal2(TreeNode root) {
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
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
            }
        }
        return result;
    }

    // Not recursion, use stack to simulate recursion
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return result;
    }

    // Not recursion, use stack to simulate recursion
    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode help = root;
        while(help != null || !stack.empty()) {
            if(help != null) {
                stack.push(help);
                result.add(help.val);
                help = help.left;
            } else{
                help = stack.pop();
                help = help.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.right = a2;
        a2.left = a3;
        List<Integer> results = new Solution().preorderTraversal4(a1);
        System.out.println(results);
    }
}
