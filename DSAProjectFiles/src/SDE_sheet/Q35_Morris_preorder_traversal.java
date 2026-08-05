package SDE_sheet;

import BT.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q35_Morris_preorder_traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                // Find the rightmost node of the left subtree
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // Construct thread AND visit current node before moving left
                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                }
                // Break thread and move right
                else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        return preorder;
    }
}
