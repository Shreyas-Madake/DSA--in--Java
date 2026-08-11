package SDE_sheet;

import BT.TreeNode;

public class Q43_LCA_BT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;

        }
        if(root==p|| root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&& right!=null){// this is the case when both left and right are not null, which means we have found both p and q in different subtrees, so root is the LCA
            return root;
        }
        return left==null? right:left;// this for if one of them is null, we return the other one, which means we have found either p or q in one subtree, so we return that node

    }
}
