import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int num = 0;
    // Time O(k)
    public int kthSmallest(TreeNode root, int k) {
        int leftResult = 0, rightResult = 0;
        if (root.left != null) {
            leftResult = kthSmallest(root.left, k);
            if (num == k) {
                return leftResult;
            }
        }
        if (++num == k) {
            return root.val;
        }
        if (root.right != null) {
            rightResult = kthSmallest(root.right, k);
            if (num == k) {
                return rightResult;
            }
        }
        return 0;
    }

    int count = 0;
    // Time O(k)
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        return kthSmallestHelper(root);
    }

    public int kthSmallestHelper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftResult = kthSmallestHelper(root.left);
        if (count == 0) {
            return leftResult;
        }
        if (--count == 0) {
            return root.val;
        }
        return kthSmallestHelper(root.right);
    }

    // O(k)
    public int kthSmallest3(TreeNode root, int k) {
        int countNum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode help = root;
        while(help != null || !stack.empty()) {
            while(help != null) {
                stack.push(help);
                help = help.left;
            }
            help = stack.pop();
            if (++countNum == k) return help.val;
            help = help.right;
        }
        return 0;
    }

    // Time O(n)
    public int kthSmallest4(TreeNode root, int k) {
        int leftNum = countTreeNode(root.left);
        if (leftNum >= k) {
            return kthSmallest4(root.left, k);
        } else if (leftNum == k - 1) {
            return root.val;
        } else {
            return kthSmallest4(root.right, k - leftNum - 1);
        }
    }

    public int countTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countTreeNode(root.left) + 1 + countTreeNode(root.right);
    }

    Map<TreeNode, Integer> map = new HashMap<>();
    // Time O(n), using memory search, Space O(n)
    public int kthSmallest5(TreeNode root, int k) {
        int leftNum = countTreeNodeWithMap(root.left);
        if (leftNum >= k) {
            return kthSmallest5(root.left, k);
        } else if (leftNum == k - 1) {
            return root.val;
        } else {
            return kthSmallest5(root.right, k - leftNum - 1);
        }
    }

    public int countTreeNodeWithMap(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!map.containsKey(root)) {
            map.put(root, countTreeNodeWithMap(root.left) + 1 + countTreeNodeWithMap(root.right));
        }
        return map.get(root);
    }

    // Time O(n) + O(lgn) (Or O(height))
    // O(n) is for building the tree
    // O(lgn) is for searching
    // Space O(n)
    public int kthSmallest6(TreeNode root, int k) {
        TreeNodeWithCount rootNode = buildTree(root);
        return kthSmallestHelper2(rootNode, k);
    }

    public int kthSmallestHelper2(TreeNodeWithCount root, int k) {
        if (root.left != null) {
            int leftNum = root.left.count;
            if (leftNum >= k) {
                return kthSmallestHelper2(root.left, k);
            } else if (leftNum == k - 1) {
                return root.val;
            } else {
                return kthSmallestHelper2(root.right, k - leftNum - 1);
            }
        } else {
            if (k == 1) {
                return root.val;
            } else {
                return kthSmallestHelper2(root.right, k - 1);
            }
        }
    }

    public TreeNodeWithCount buildTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNodeWithCount rootNode = new TreeNodeWithCount(root.val);
        rootNode.left = buildTree(root.left);
        rootNode.right = buildTree(root.right);
        if (rootNode.left != null) {
            rootNode.count += rootNode.left.count;
        }
        if (rootNode.right != null) {
            rootNode.count += rootNode.right.count;
        }
        return rootNode;
    }

    class TreeNodeWithCount {
        int count;
        int val;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int value) {
            this.val = value;
            this.count = 1;
        }
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a3.left = new TreeNode(6);
        a3.right = new TreeNode(8);
        int result = new Solution().kthSmallest6(a1, 5);
        System.out.println(result);
    }
}
