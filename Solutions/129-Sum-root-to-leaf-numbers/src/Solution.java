import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<List<Integer>> lists = paths(root);
        for(List<Integer> list: lists) {
            int length = list.size() - 1;
            for(int i = 0; i <= length; i++) {
                sum += list.get(i) * Math.pow(10, length - i);
            }
        }
        return sum;
    }

    public List<List<Integer>> paths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right == null) {
            List<Integer> oneResult = new ArrayList<>();
            oneResult.add(root.val);
            result.add(oneResult);
            return result;
        }

        List<List<Integer>> left = paths(root.left);
        for(List<Integer> list: left) {
            list.add(0, root.val);
            result.add(list);
        }

        List<List<Integer>> right = paths(root.right);
        for(List<Integer> list: right) {
            list.add(0, root.val);
            result.add(list);
        }

        return result;
    }

    public int sumNumbers2(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    public int sumNumbersHelper(TreeNode root, int sum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return sum * 10 + root.val;
        } else {
            sum = sum * 10 + root.val;
        }
        return sumNumbersHelper(root.left, sum) + sumNumbersHelper(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        int result = new Solution().sumNumbers2(root);
        System.out.println(result);
    }
}
