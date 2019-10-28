import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        boolean leftHasP = findNode(root.left, p);
        boolean leftHasQ = findNode(root.left, q);
        boolean rightHasP = findNode(root.right, p);
        boolean rightHasQ = findNode(root.right, q);
        if ((leftHasP && rightHasQ) || (leftHasQ && rightHasP)) {
            return root;
        }
        if (leftHasP && leftHasQ) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public boolean findNode (TreeNode root, TreeNode son) {
        if(root != null) {
            return (root.val == son.val || findNode(root.left, son) || findNode(root.right, son));
        } else {
            return false;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        if (left != null && left != p && left != q) {
            return left;
        }
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        findParents(root, p, q, parents);
        Set<TreeNode> setP = new HashSet<>();
        while (p != null) {
            setP.add(p);
            p = parents.get(p);
        }
        while (q != null) {
            if (setP.contains(q)) {
                return q;
            }
            q = parents.get(q);
        }
        return null;
    }

    private void findParents(TreeNode root, TreeNode p, TreeNode q, Map<TreeNode, TreeNode> parents) {
        if (parents.containsKey(p) && parents.containsKey(q)) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parents.put(root.left, root);
        }
        if (root.right != null) {
            parents.put(root.right, root);
        }
        findParents(root.left, p, q, parents);
        findParents(root.right, p, q, parents);
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        a1.left = a2;
        a1.right = a3;
        a3.left = new TreeNode(15);
        a3.right = new TreeNode(7);
        TreeNode result = new Solution().lowestCommonAncestor3(a1, a2, a3);
        System.out.println(result.val);
    }
}