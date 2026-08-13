package SDE_sheet;

import BT.TreeNode;

public class Q47_Max_sum_BST_in_BT {
    int ans;

    public int maxSumBST(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    // arr -> min, max, sum
    public int[] dfs(TreeNode root) {
        // base case
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int leftSubtree[] = dfs(root.left);
        int rightSubtree[] = dfs(root.right);

        // check if current subtree is bst
        if (root.val > leftSubtree[1] && root.val < rightSubtree[0]) {
            int curSum = leftSubtree[2] + rightSubtree[2] + root.val;
            ans = Math.max(ans, curSum);
            int minVal = Math.min(root.val, leftSubtree[0]);
            int maxVal = Math.max(root.val, rightSubtree[1]);
            return new int[]{minVal, maxVal, curSum};
        }

        int maxSum = Math.max(leftSubtree[2], rightSubtree[2]);
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, maxSum};
    }
}
