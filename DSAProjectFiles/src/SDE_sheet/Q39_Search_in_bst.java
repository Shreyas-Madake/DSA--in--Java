package SDE_sheet;

import BT.TreeNode;

public class Q39_Search_in_bst {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.val!=val){
            root= val<root.val? root.left:root.right;
        }
        return root;

    }
}
