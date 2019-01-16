import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                List<Integer> oneResult = new ArrayList<>();
                oneResult.add(sum);
                result.add(oneResult);
                return result;
            } else {
                return result;
            }
        }

        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        for(List<Integer> list: left) {
            list.add(0, root.val);
            result.add(list);
        }

        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        for(List<Integer> list: right) {
            list.add(0, root.val);
            result.add(list);
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        List<List<Integer>> result = new Solution().pathSum(root, 10);
        for(List<Integer> list: result) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
