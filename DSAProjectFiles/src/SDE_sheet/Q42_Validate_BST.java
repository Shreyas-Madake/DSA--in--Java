package SDE_sheet;

import BT.TreeNode;

public class Q42_Validate_BST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // An empty tree/leaf branch is a valid BST
        if (node == null) {
            return true;
        }

        // Current node's value must be strictly within the allowed range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively check left and right subtrees with updated bounds
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
