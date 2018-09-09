import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // O(1) Space Complexity
    public void recoverTree(TreeNode root) {
        //if(root == null) return;
        TreeNode current, previous;
        TreeNode parent = null;
        TreeNode first = null;
        TreeNode second = null;
        current = root;
        while (current != null) {
            if (current.left == null) {
                if (parent != null && parent.val > current.val){
                    if (first == null) first = parent;
                    second = current;
                }
                parent = current;
                current = current.right;
            } else {
                previous = current.left;
                while (previous.right != null && previous.right != current) previous = previous.right;
                if (previous.right == null){
                    previous.right = current;
                    current = current.left;
                } else {
                    previous.right = null;
                    if (parent.val > current.val){
                        if (first == null) first = parent;
                        second = current;
                    }
                    parent = current;
                    current = current.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    // Original solution, O(n) space, O(nlogn) time
    public void recoverTree0(TreeNode root) {
        //if(root == null) return;
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> node_values = new ArrayList<>();
        inorderTraversal(root, nodes, node_values);
        Collections.sort(node_values);
        for(int i = 0; i < nodes.size(); i++){
            nodes.get(i).val = node_values.get(i);
        }
    }

    //Optimize the sorting process, O(n) space, O(n) time
    public void recoverTree1(TreeNode root) {
        //if(root == null) return;
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> node_values = new ArrayList<>();
        inorderTraversal(root, nodes, node_values);

        int length = node_values.size();
        List<Integer> inOrderNodes = new ArrayList<>();
        for(int i = 0; i < length - 1; i++){
            if(node_values.get(i) > node_values.get(i + 1)){
                inOrderNodes.add(i);
                inOrderNodes.add(i + 1);
            }
        }
        if(inOrderNodes.size() == 4){
            nodes.get(inOrderNodes.get(0)).val = node_values.get(inOrderNodes.get(3));
            nodes.get(inOrderNodes.get(3)).val = node_values.get(inOrderNodes.get(0));
        }
        if(inOrderNodes.size() == 2){
            nodes.get(inOrderNodes.get(0)).val = node_values.get(inOrderNodes.get(1));
            nodes.get(inOrderNodes.get(1)).val = node_values.get(inOrderNodes.get(0));
        }
    }

    //Optimize the sorting process, O(n) space, O(n) time
    public void recoverTree2(TreeNode root) {
        //if(root == null) return;
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> node_values = new ArrayList<>();
        inorderTraversal(root, nodes, node_values);

        int length = node_values.size();
        int first = -1;
        int second = -1;

        for(int i = 0; i < length - 1; i++){
            if(node_values.get(i) > node_values.get(i + 1)){
                if(first == -1) first = i;
                second = i + 1;
            }
        }
        nodes.get(first).val = node_values.get(second);
        nodes.get(second).val = node_values.get(first);
    }

    public void inorderTraversal(TreeNode root, List<TreeNode> nodes, List<Integer> node_values) {
        if(root == null) return;
        inorderTraversal(root.left, nodes, node_values);
        nodes.add(root);
        node_values.add(root.val);
        inorderTraversal(root.right, nodes, node_values);
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.left = a3;
        a3.right = a2;
        new Solution().recoverTree(a1);
        //System.out.println(new Solution().inorderTraversal(a1));
    }
}
