package SDE_sheet;
import BT.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class Q34_Morris_inorder_traversal {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                // Find the rightmost node of the left subtree
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // Construct thread
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                }
                // Break thread and print
                else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return inorder;
    }
}
