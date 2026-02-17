package NeetCode_150;

public class Q40_Balanced_BT {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // Returns the height of the subtree if it is balanced,
    // otherwise returns -1 to indicate the tree is not balanced
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;  // Left subtree is unbalanced → whole tree is unbalanced
        }

        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;  //tree is unbalanced
        }


        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Tree is balanced  return actual height
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
