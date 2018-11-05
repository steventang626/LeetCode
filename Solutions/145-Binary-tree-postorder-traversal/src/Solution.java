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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }

    // Not recursion, use stack to simulate recursion
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while(!stack.empty()) {
            Command command = stack.pop();
            if (command.s.equals("print")) {
                result.add(command.node.val);
            } else {
                stack.push(new Command("print", command.node));
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return result;
    }

    // Not recursion, use stack to simulate recursion
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode help = root;
        while(help != null || !stack.empty()) {
            while(help != null) {
                stack.push(help);
                result.add(0, help.val);
                help = help.right;
            }
            help = stack.pop();
            help = help.left;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.right = a2;
        a2.left = a3;
        List<Integer> results = new Solution().postorderTraversal3(a1);
        System.out.println(results);
    }
}
