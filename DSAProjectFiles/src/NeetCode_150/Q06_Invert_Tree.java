package NeetCode_150;


import BT.TreeNode;

public class Q06_Invert_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;

        }
        TreeNode left= invertTree(root.left);
        TreeNode right= invertTree(root.right);

        root.left=right;
        root.right=left;
        return root;
    }
}
