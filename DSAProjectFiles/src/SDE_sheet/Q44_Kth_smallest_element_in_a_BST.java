package SDE_sheet;

import BT.TreeNode;

public class Q44_Kth_smallest_element_in_a_BST {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        // 1. Traverse left
        inorder(node.left, k);

        // 2. Process current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // 3. Traverse right
        inorder(node.right, k);
    }
}
